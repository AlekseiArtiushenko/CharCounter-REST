package ru.artiushenko.charcounterrest.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class ApiTests {
    @BeforeAll
    public static void init() {
        Specs.installSpec(
                Specs.requestSpec("http://localhost", 8080, "uniqueSymbols"),
                Specs.responseSpec()
        );
    }

    @Test
    void responseCodeIs200() {
        RestAssured
                .given()
                .when()
                    .get("/parse?line=a")
                .then()
                    .statusCode(200);
    }

    @Test
    void responseCodeIs400() {
        RestAssured
                .given()
                .when()
                    .get("/parse{line}", Map.of("line", "?line=1231_"))
                .then()
                    .statusCode(400);
        RestAssured
                .given()
                .when()
                    .get("/parse{line}", Map.of("line", "?line="))
                .then()
                    .statusCode(400);
    }

    @Test
    void responseCodeIs404() {
        RestAssured
                .given()
                .when()
                    .get("/pars")
                .then()
                    .statusCode(404);
    }
}
