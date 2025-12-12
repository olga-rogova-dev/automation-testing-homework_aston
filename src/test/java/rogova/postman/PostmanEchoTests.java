package rogova.postman;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTests {

    @BeforeAll
    static void setup() {
        baseURI = "https://postman-echo.com";
    }

    @Test
    void getRequestTest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    void postRawTextTest() {
        String body = "{\"test\":\"value\"}";
        given()
                .contentType("application/json")
                .body(body)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data.test", equalTo("value"));
    }

    @Test
    void postFormDataTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    void putRequestTest() {
        String body = "{\"test\":\"value\"}";
        given()
                .contentType("application/json")
                .body(body)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data.test", equalTo("value"));
    }

    @Test
    void patchRequestTest() {
        String body = "{\"test\":\"value\"}";
        given()
                .contentType("application/json")
                .body(body)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data.test", equalTo("value"));
    }

    @Test
    void deleteRequestTest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }
}