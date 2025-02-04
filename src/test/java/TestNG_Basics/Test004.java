package TestNG_Basics;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test004 {

    @Test
    public void test_GET_request()
    {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .when()
                .get()
                .then()
                .log().all();
    }
}
