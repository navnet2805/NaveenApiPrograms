package TestNG_Features;

import org.testng.annotations.Test;

public class groupTest {

    @Test(groups = {"Dev"})
    public void method1()
    {
        System.out.println("method 1 -> priority3");
    }

    @Test(groups = {"Dev", "prod"})
    public void method3()
    {
        System.out.println("method 3 -> priority1");
    }

    @Test(groups = {"qa", "prod"})
    public void method2()
    {
        System.out.println("method 2 -> priority2");
    }

    @Test(groups = {"Dev", "qa"})
    public void method4()
    {
        System.out.println("method 4 -> priority1");
    }

    @Test(groups = {"qa"})
    public void method5()
    {
        System.out.println("method 5 -> priority1");
    }

}
