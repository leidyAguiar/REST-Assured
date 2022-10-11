package com.automacao.api.components;

import com.automacao.api.system.RestAssuredBase;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

public class components {

    public components(String url) {
        RestAssuredBase.setup(url);
    }

    public void validationPath(String path, String value) {
        get().then().body(path, is(value));
    }

    public void validationSchema() {
        get().then().body(matchesJsonSchemaInClasspath("jsonValidation.json"));
    }
}
