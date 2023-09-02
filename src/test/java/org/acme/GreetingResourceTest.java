package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void postWithValidDataShouldReturn201() {
        given()
                .body("{\"name\": \"John\"}")
                .header("Content-Type", "application/json")
                .when()
                .post("/gift")
                .then()
                .statusCode(201);
    }

}