package PUT_RestFullBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_PUT_01 {

    static RequestSpecification r = RestAssured.given();
    @Test
    public void test_put()
    {
        String input = "{\n" +
                "    \"firstname\" : \"James\",\n" +
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
        r.basePath("/booking/3");
        r.contentType(ContentType.JSON);
        r.body(input);

        r.when().log().all().patch();

        r.then().statusCode(200);

    }
}

