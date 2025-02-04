package TestNG_Features;

import org.testng.annotations.Test;

public class Priority_Test001 {

    @Test(priority = 3)
    public void method1()
    {
        System.out.println("method 1 -> priority3");
    }

    @Test(priority = 1)
    public void method3()
    {
        System.out.println("method 3 -> priority1");
    }

    @Test(priority = 2)
    public void method2()
    {
        System.out.println("method 2 -> priority2");
    }
}
