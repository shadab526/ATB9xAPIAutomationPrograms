package com.thetestingacademy.ex02_RestAssuredBasics.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_POST_NonBDD {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_POST_NonBDD(){
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("password123");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        Response response1 = r.when().log().all().post();

        ValidatableResponse vr = response1.then().log().all().statusCode(201);


    }
}
