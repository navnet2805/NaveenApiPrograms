package TestNG_Features;

import org.testng.annotations.Test;

public class Enable_Disable_TC {

    @Test
    public void method1()
    {
        System.out.println("method 1 -> priority3");
    }

    @Test(enabled = false) //enabled=false means this tc will not run.
    public void method3()
    {
        System.out.println("method 3 -> priority1");
    }

    @Test
    public void method2()
    {
        System.out.println("method 2 -> priority2");
    }
}
