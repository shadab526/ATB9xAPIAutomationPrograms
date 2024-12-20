package com.thetestingacademy.ex02_RestAssuredBasics.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting0111_PUT_NonBDDStyle {
    @Test
    public void test_PUT_non_bdd(){
        String token = "f59b9e3ed2b99d7";
        String bookingId = "1470";
        String payloadPUT = "{\n" +
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

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingId);
        r.contentType(ContentType.JSON);
        r.cookies("token",token);
        r.body(payloadPUT).log().all();
        Response response = r.when().put();
        ValidatableResponse vr = response.then().log().all().statusCode(200);
    }
}
