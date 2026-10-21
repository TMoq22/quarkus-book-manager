package com.example;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void testGetAllBooks() {
        given()
                .when().get("/books")
                .then()
                .statusCode(200)
                .body("size()", greaterThanOrEqualTo(0));
    }

    @Test
    public void testCreateBook() {
        String newBookJson = """
                {
                    "title": "L'Étranger",
                    "author": "Albert Camus",
                    "pages": 159
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(newBookJson)
                .when().post("/books")
                .then()
                .statusCode(201)
                .body("title", is("L'Étranger"))
                .body("author", is("Albert Camus"));
    }
}