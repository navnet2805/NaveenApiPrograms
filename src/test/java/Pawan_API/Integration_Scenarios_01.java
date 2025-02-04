package Pawan_API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Integration_Scenarios_01 {

    RequestSpecification requestSpecification= RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    String id_book;
    String token;

    @Test(priority = 1)
    public void Login() {
        System.out.println("login Request");
        token=Create_Token();
        System.out.println(token);
        id_book= Create_booking();
        System.out.println(id_book);
    }

    //Ping - HealthCheck
    @BeforeTest
    public void ping_TC1(){

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/ping");

        response=requestSpecification.when().get();

        validatableResponse= response.then().log().all();
        validatableResponse.statusCode(201);

    }

    public String Create_Token(){

        String body="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.body(body);
        requestSpecification.contentType(ContentType.JSON);

        response=requestSpecification.when().post();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);

        token=response.jsonPath().getString("token");

        return token;
    }


    public String Create_booking(){

        String body="{\n" +
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

        response=requestSpecification.when().post();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);

        id_book=response.jsonPath().getString("bookingid");
        return id_book;
    }

    @Test(priority = 3)
    public  void get_booking(){
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+ id_book);

         response=requestSpecification.when().log().all().get();

         validatableResponse=response.then();
         validatableResponse.statusCode(200);
         validatableResponse.contentType(ContentType.JSON);
    }

    @Test(priority = 4)
    public void UpdateBooking(){

        String body ="{\n" +
                "    \"firstname\" : \"Pawan\",\n" +
                "    \"lastname\" : \"White\",\n" +
                "    \"totalprice\" : 112,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"1999-012-09\",\n" +
                "        \"checkout\" : \"1999-012-09\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"dinner\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" +id_book);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(body);

        response=requestSpecification.when().log().all().put();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.contentType(ContentType.JSON);

        String firstname = response.jsonPath().getString("firstname");
        String lastname = response.jsonPath().getString("lastname");
        String totalprice = response.jsonPath().getString("totalprice");
        String additionalneeds = response.jsonPath().getString("additionalneeds");

        Assert.assertEquals(firstname,"Pawan");
        Assert.assertEquals(lastname,"White");
        Assert.assertEquals(totalprice,"112");
        Assert.assertEquals(additionalneeds,"dinner");

    }

    @Test(priority = 5)
    public void deletebooking()
    {
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+id_book );
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        response = requestSpecification.when().log().all().delete();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);

    }

    @Test(priority = 6)
    public void verifyDelete(){
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+ id_book);

        response=requestSpecification.when().log().all().get();

        validatableResponse=response.then();
        validatableResponse.statusCode(404);

    }
}
