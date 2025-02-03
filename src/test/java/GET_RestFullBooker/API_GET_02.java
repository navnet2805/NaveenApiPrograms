package GET_RestFullBooker;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_GET_02 {
    static RequestSpecification r = RestAssured.given();

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test case: Verify the get request using nonBDD style with booking id 759")
    @Test
    public void get_request_NonBDDStyle()
    {
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/759");
        r.when().log().all().get();
        r.then().statusCode(200);
    }
}
