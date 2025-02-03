package PATCH_RestFullBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_PATCH_01 {
    /*
    URI : https://restful-booker.herokuapp.com
    path : /booking/2
  header: application/json'
    {
    "firstname" : "James",
    "lastname" : "Brown"
}'
     */
static RequestSpecification r = RestAssured.given();
    @Test
    public void test_patch()
    {
        String input = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/2");
        r.contentType(ContentType.JSON);
        r.body(input);
        r.when().log().all().patch();
        r.then().statusCode(200);

    }
}
