package TestNG_Features;

import org.testng.Assert;
import org.testng.annotations.Test;

public class invocation_test {

    @Test(invocationCount = 4)
    public void method3()
    {
        System.out.println("method 3 -> priority1");

    }
}
