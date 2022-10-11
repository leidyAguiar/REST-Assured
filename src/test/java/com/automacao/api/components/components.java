package com.automacao.api.components;

import com.automacao.api.system.RestAssuredBase;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

public class components {

    public components(String url) {
        RestAssuredBase.setup(url);
    }

    public void endpointReturn() {
        given().when().get().then().log().all();
    }

    public void validationPath(String path, String value) {
        given().when().get().then().body(path, is(value));
    }

    public void validationSchema() {
        given().when().get().then().body(matchesJsonSchemaInClasspath("jsonValidation.json"));
    }
}
