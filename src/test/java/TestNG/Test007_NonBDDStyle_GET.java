package TestNG;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Test007_NonBDDStyle_GET {

    static RequestSpecification r = RestAssured.given();

    @Severity(SeverityLevel.CRITICAL)
@Description("Test case1 : Verify the positive test case1")
    @Test
    public void test_GET()
    {
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/560016");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test case2 : Verify the Negative test case2")
    @Test
    public void test_GET1()
    {
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/-1");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test case3 : Verify the positive test case3")
    @Test
    public void test_GET3()
    {
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/560015");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }

}
