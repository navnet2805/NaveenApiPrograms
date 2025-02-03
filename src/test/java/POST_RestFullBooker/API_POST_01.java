package POST_RestFullBooker;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_POST_01 {
    /*
    URL: https://restful-booker.herokuapp.com/booking
    URI: https://restful-booker.herokuapp.com
    basepath: /booking
    method: POST
    Content-Type - application/JSON

    {
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
     */

    static RequestSpecification r = RestAssured.given();

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test case 5: Verify the booking id is created")
    @Test
    public void post_request()
    {
        String inputs ="{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(inputs);
        r.when().log().all().post();
        r.then().statusCode(200).contentType(ContentType.JSON);
        r.log().all().response();
    }
}
