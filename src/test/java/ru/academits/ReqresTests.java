package ru.academits;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReqresTests {

    @Test
    public void singleResource() {
        Response response = RestAssured
                .get("https://reqres.in/api/unknown/2")
                .andReturn();

        int statusCode = response.statusCode();
        System.out.println("Status code: " + statusCode);

        assertEquals(200, statusCode, "Unexpected status code");

    }

    @Test
    public void delayedResponse() {
        ValidatableResponse response = RestAssured
                .given()
                .queryParam("delay", "3")
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .statusCode(200);
    }


    @Test
    public void create() {
        Map<String, String> body = new HashMap<>();
        body.put("name", "morpheus");
        body.put("job", "leader");
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://reqres.in/api/users")
                .andReturn();

        response.prettyPrint();

        int statusCode = response.statusCode();
        System.out.println("Status code: " + statusCode);

        assertEquals(201, statusCode, "Unexpected status code");
    }

    @Test
    public void registrationSuccessful() {
        Map<String, String> body = new HashMap<>();
        body.put("email", "eve.holt@reqres.in");
        body.put("password", "pistol");
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://reqres.in/api/register")
                .andReturn();

        response.prettyPrint();

        int statusCode = response.statusCode();
        System.out.println("Status code: " + statusCode);

        assertEquals(200, statusCode, "Unexpected status code");
    }

    @Test
    public void updatePut() {
        Map<String, String> body = new HashMap<>();
        body.put("name", "morpheus");
        body.put("job", "zion resident");
        JsonPath response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put("https://reqres.in/api/users/2")
                .jsonPath();
        response.prettyPrint();

        Assertions.assertEquals("morpheus", response.get("name").toString());
        Assertions.assertEquals("zion resident", response.get("job").toString());
    }

    @Test
    public void updatePatch() {
        Map<String, String> body = new HashMap<>();
        body.put("name", "morpheus");
        body.put("job", "zion resident");
        JsonPath response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .patch("https://reqres.in/api/users/3")
                .jsonPath();
        response.prettyPrint();

        Assertions.assertEquals("morpheus", response.get("name").toString());
        Assertions.assertEquals("zion resident", response.get("job").toString());
    }

    @Test
    public void delete() {
        Response response = RestAssured
                .delete("https://reqres.in/api/users/2")
                .andReturn();

        int statusCode = response.statusCode();
        System.out.println("Status code: " + statusCode);

        assertEquals(204, statusCode, "Unexpected status code");
    }

    @Test
    public void deleteNegative() {
        Response response = RestAssured
                .delete("https://reqres.in/api/users/2")
                .andReturn();

        int statusCode = response.statusCode();
        System.out.println("Status code: " + statusCode);

        assertEquals(404, statusCode, "Unexpected status code");
    }
}
