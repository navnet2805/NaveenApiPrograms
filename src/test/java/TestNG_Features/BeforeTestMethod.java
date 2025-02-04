package TestNG_Features;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeTestMethod {

    @BeforeTest
    public void Start1()
    {
        System.out.println("I am starting");
    }


    @Test
    public void method1()
    {
        System.out.println("method 1 -> priority3");
    }

    @Test
    public void method3()
    {
        System.out.println("method 3 -> priority1");
    }

    @BeforeTest
    public void Start2()
    {
        System.out.println("I am started");
    }

    @Test
    public void method2()
    {
        System.out.println("method 2 -> priority2");
    }
}
