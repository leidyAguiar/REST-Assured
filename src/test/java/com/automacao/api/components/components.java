package com.automacao.api.components;

import com.automacao.api.system.RestAssuredBase;
import netscape.javascript.JSObject;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class components {

    String pointDelete;

    public components(String url) {
        RestAssuredBase.setup(url);
        pointDelete = url;
    }

    public void validationPath(String path, String value) {
        get().then().body(path, is(value));
    }

    public void validationSchema() {
        get().then().body(matchesJsonSchemaInClasspath("jsonValidation.json"));
    }

    public void postEndpoint() {
       JSONObject json = new JSONObject();
       json.put("name", "Scorpions");
       json.put("job", "music");

       given().body(json).when().post().then().statusCode(HttpStatus.SC_CREATED).body(containsString("created"));
    }

    public void updateEndpoint() {
        JSONObject json = new JSONObject();
        json.put("name", "Scorpionsaaasas");
        json.put("job", "music rock");

        given().body(json).when().put().then().statusCode(HttpStatus.SC_OK).body(containsString("update"));
    }

    public void deleteEndpoint() {
       when().delete(pointDelete).then().statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
