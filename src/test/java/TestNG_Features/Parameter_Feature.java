package TestNG_Features;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter_Feature {

    @Parameters("browser")
    @Test
    public void method1(String value)
    {
        System.out.println("Browser is: " +value);
    }
}
