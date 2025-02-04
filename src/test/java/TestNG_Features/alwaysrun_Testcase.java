package TestNG_Features;

import org.testng.Assert;
import org.testng.annotations.Test;

public class alwaysrun_Testcase {
    @Test
    public void method1()
    {
        System.out.println("method 1 -> priority3");
    }

    @Test
    public void method3()
    {
        System.out.println("method 3 -> priority1");
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true, dependsOnMethods = "method3") // this parameter represents it will always run even its
    //dependents methods are failed.
    public void method2()
    {
        System.out.println("method 2 -> priority2");
    }
}
