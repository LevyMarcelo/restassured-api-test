package br.com.restassured.api;

import br.com.restassured.design.BaseTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

public class TodosTest extends BaseTest {

    @Test(groups = { "health_check" })
    public void healthCheck() {
        when().
            get("/1").
        then().
            statusCode(HttpStatus.SC_OK);
    }

    @Test(groups = "contract")
    public void contrato() {
        when().
            get("/1").
        then().
            body(matchesJsonSchemaInClasspath("schemas/todos.json"));
    }

    @Test(groups = { "functional" })
    public void getComSucesso() {
        when().
            get("/1").
        then().
            statusCode(HttpStatus.SC_OK).
            body("userId", is(1)).
            body("id", is(1)).
            body("title", is("delectus aut autem")).
            body("completed", is(false));
    }

    @Test(groups = "negative")
    public void getInexistente() {
        when().
            get("9999999").
        then().
            statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
