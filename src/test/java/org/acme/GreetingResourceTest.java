package org.acme;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectSpy;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@QuarkusTest
public class GreetingResourceTest {

    @InjectSpy
    SantaClausService santaClausService;

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

    @Test
    public void givenAValidGiftIdWhenGetThenReturnGift() {
        final var expectedGift = new Gift();
        expectedGift.setId(1L);
        expectedGift.setName("John");

        doReturn(expectedGift).when(santaClausService).get(expectedGift.getId().longValue());

        given()
                .when()
                .get("/gift/1")
                .then()
                .statusCode(200)
                .body("id", is(expectedGift.getId().intValue()))
                .body("name", is("John"));
    }

}