package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

    @Test
    public void test_softAssertion()
    {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Start of the program");
        softAssert.assertTrue(false);
        System.out.println("This line will be executed");

    }
}
