package TestNG;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test005_BDDStyle_GET {

    @Test
    public void test_GET_Request()
    {
        String pincode = "560016";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us/")
                    .basePath("/IN/" +pincode)
                .when()
                    .log()
                    .all()
                    .get()
                .then()
                    .log().all()
                    .statusCode(200);
    }

    @Test
    public void test_GET_Request1()
    {
        String pincode = "-1";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("/IN/" +pincode)
                .when()
                .log()
                .all()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }
}
