package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {

    @Test
    public void test_hardAssertion()
    {
        System.out.println("Start of the program");
        Assert.assertTrue(false);
        System.out.println("This line will not be executed");

    }
}
