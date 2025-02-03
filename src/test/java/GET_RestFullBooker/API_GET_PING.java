package GET_RestFullBooker;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_GET_PING {
    static RequestSpecification r = RestAssured.given();

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test case: Verify the helath check of the URL")
    @Test
    public void get_request_ping()
    {
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/ping");
        r.when().log().all().get();
        r.then().statusCode(201);
    }
}
