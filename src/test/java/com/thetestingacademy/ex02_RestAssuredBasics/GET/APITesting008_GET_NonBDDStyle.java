package com.thetestingacademy.ex02_RestAssuredBasics.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting008_GET_NonBDDStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_GET_NonBDDStyle(){
        String pin_code = "560016";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pin_code);
        response = r.when().log().all().get();
        vr = response.then().log().all().statusCode(200);

    }
    @Test
    public void test_GET_NonBDDStyleNegative(){
        String pin_code = "-1";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pin_code);
        response = r.when().log().all().get();
        vr = response.then().log().all().statusCode(404);
    }

    @Test
    public void test_GET_NonBDDStyle_SpecialCharector(){
        String pin_code = "@@##";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pin_code);
        response = r.when().log().all().get();
        vr = response.then().log().all().statusCode(404);
    }
}
