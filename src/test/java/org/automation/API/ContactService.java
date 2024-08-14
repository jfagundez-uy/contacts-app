package org.automation.API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Getter;
import org.json.JSONObject;

import static io.restassured.RestAssured.*;

public class ContactService {

    @Getter
    private static String bearerToken;

    public static void login(String username, String password) {
        String loginUrl = "https://thinking-tester-contact-list.herokuapp.com/users/login";

        JSONObject requestBody = new JSONObject();
        requestBody.put("email", username);
        requestBody.put("password", password);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post(loginUrl);

        if (response.getStatusCode() == 200) {
            bearerToken = response.jsonPath().getString("token");
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed: " + response.getStatusCode());
        }
    }

    public static String createContact(String jsonFilePath, String bearerToken) {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com/contacts";
        String requestBody = "";

        requestBody = String.valueOf(new Utils().readPayloadFromJson(jsonFilePath));

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .body(requestBody)
                .post();

        return response.jsonPath().getString("_id");
    }

    public static void updateContact(String jsonFilePath, String bearerToken, String contactId) {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com/contacts/" + contactId;
        String requestBody = "";

        requestBody = String.valueOf(new Utils().readPayloadFromJson(jsonFilePath));

        given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .body(requestBody)
                .put();
    }

    public static void deleteContact(String bearerToken, String contactId) {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com/contacts/"+ contactId;
        String requestBody = "";

        given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .body(requestBody)
                .delete();
    }

    public static Response getContact(String bearerToken, String contactId) {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com/contacts/"+ contactId;
        String requestBody = "";

        return given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .body(requestBody)
                .get();
    }
}