package DELETE_RestFullBooker;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_DELETE_01 {
    static RequestSpecification r = RestAssured.given();

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test case: Verify the delete request using nonBDD style with booking id 759")
    @Test
    public void test_delete()
    {
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/759");
        r.contentType(ContentType.JSON);
        r.when().log().all().delete();
        r.then().statusCode(201);
    }

}
