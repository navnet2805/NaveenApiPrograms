package IntegrationScenario1;


import io.qameta.allure.internal.shadowed.jackson.databind.jsontype.impl.AsExistingPropertyTypeSerializer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Screnario1 {
    // details are in Scenario1.md file

//global variable
    RequestSpecification requestSpecification = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    String bookingID;
    String token;


    public String getToken()
     {
         //Create token request

         String body = "{\n" +
                 "    \"username\" : \"admin\",\n" +
                 "    \"password\" : \"password123\"\n" +
                 "}";

         requestSpecification.baseUri("https://restful-booker.herokuapp.com");
         requestSpecification.basePath("/auth");
         requestSpecification.contentType(ContentType.JSON);
         requestSpecification.body(body);

         response = requestSpecification.when().post();

         validatableResponse = response.then().log().all();
         validatableResponse.statusCode(200);

         token = response.jsonPath().getString("token");

         return token;
     }

    //    2. Create Booking
//    create a booking - get the booking id - method
     public String getBookingID()
     {
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

         bookingID = response.jsonPath().getString("bookingid");

         return bookingID;
     }


    //1. Auth -Create Token
    //create a token - get the token - method
    @Test(priority = 1)
    public void Login()
    {
        System.out.println("login request");
        token = getToken();
        System.out.println(token);
        bookingID = getBookingID();
        System.out.println(bookingID);
    }


//    3.Get Booking
//    use the booking ID and token - to fetch the booking details
    @Test(priority = 2)
    public void GetBooking()
    {
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);

        response = requestSpecification.when().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.contentType(ContentType.JSON);
    }

    //4. Partial update
    //use the booking ID and token - to update firstname and lastname - print the updated details.
    @Test(priority = 3)
    public void PartialUpdateBooking()
    {
        String body = "{\n" +
                "    \"firstname\" : \"Naveen\",\n" +
                "    \"lastname\" : \"RP\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(body);

        response = requestSpecification.when().patch();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.contentType(ContentType.JSON);

        String firstname = response.jsonPath().getString("firstname");
        String lastname = response.jsonPath().getString("lastname");

        Assert.assertEquals(firstname,"Naveen");
        Assert.assertEquals(lastname,"RP");
    }

    //5. Delete Booking
    //use the bookingid and token to delete the booking.
    @Test(priority = 4)
    public void DeleteBooking()
    {
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        response = requestSpecification.when().delete();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }

    @Test(priority = 5)
    public void VerifyDeletedBookingID()
    {
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);

        response = requestSpecification.when().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }

    @BeforeTest
    public void ping()
    {
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/ping");

        response = requestSpecification.when().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
    }
}
