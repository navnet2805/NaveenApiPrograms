package TestNG_Features;

import io.restassured.internal.common.assertion.Assertion;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DependsMethod {


    @Test(dependsOnMethods = "method3")
    public void method1()
    {
        System.out.println("method 1 -> priority3");
        Assert.assertTrue(true);
    }

    @Test (dependsOnMethods = "method2")
    public void method3()
    {
        System.out.println("method 3 -> priority1");
        Assert.assertTrue(true);
    }

    @Test
    public void method2()
    {
        System.out.println("method 2 -> priority2");
        Assert.assertTrue(true);
    }

}
