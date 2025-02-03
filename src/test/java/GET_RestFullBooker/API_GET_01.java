package GET_RestFullBooker;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_GET_01 {
/*
URL: https://restful-booker.herokuapp.com/booking/1
      URI: https://restful-booker.herokuapp.com
      basepath: /booking/1
method: GET
header : application/json
 */
static RequestSpecification r = RestAssured.given();

@Severity(SeverityLevel.BLOCKER)
@Description("Test case1: Verify the get request using nonBDD style with booking id 1")
    @Test
    public void get_request_NonBDDStyle()
    {
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/1");
        r.when().log().all().get();
        r.then().statusCode(200);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test case2: Verify the get request using nonBDD style with booking id 2")
    @Test
    public void get_request_NonBDDStyle1()
    {
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/2");
        r.when().log().all().get();
        r.then().statusCode(200);
    }

}
