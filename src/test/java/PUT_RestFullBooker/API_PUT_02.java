package PUT_RestFullBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_PUT_02 {

    @Test
    public void test_put()
    {
        String token = "0d844e08fd340c9";
        String BookingID = "946";
        String input = "{\n" +
                "    \"firstname\" : \"Naveen\",\n" +
                "    \"lastname\" : \"Kumar\",\n" +
                "    \"totalprice\" : 121,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-20\",\n" +
                "        \"checkout\" : \"2019-01-21\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" +BookingID);
        r.contentType(ContentType.JSON);
        r.body(input).log().all();
        r.cookie("token", token);
        //r.auth().preemptive().basic("admin","password123");

        Response response = r.when().log().all().patch();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }
}
