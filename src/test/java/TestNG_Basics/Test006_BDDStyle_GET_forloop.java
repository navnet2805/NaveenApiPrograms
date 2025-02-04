package TestNG_Basics;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test006_BDDStyle_GET_forloop {

    @Test
    public void test_GET_Request()
    {
        String[] pincode = {"560016", "583201", "Naveen"};
        for (String s : pincode)
        {
            RestAssured
                    .given()
                    .baseUri("https://api.zippopotam.us/")
                    .basePath("/IN/" + s)
                    .when()
                    .log()
                    .all()
                    .get()
                    .then()
                    .log().all()
                    .statusCode(200);
        }
    }

}
