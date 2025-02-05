package Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.assertj.core.api.Assertions.*;

public class Assertion_AssertJ {
    RequestSpecification requestSpecification = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    String bookingID;
    String token;

    public void getBookingID() {
        //Create Booking
        String body = "{\n" +
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

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(body);

        response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //AssertJ
        bookingID = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("firstname");
        String lastname = response.then().extract().path("lastname");

        assertThat(bookingID).isNotNull().isNotEmpty();
        assertThat(firstname).isEqualTo("Jim").isNotEmpty().isNotBlank().isAlphanumeric();



    }
}
