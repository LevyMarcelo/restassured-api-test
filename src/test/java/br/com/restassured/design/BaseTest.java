package br.com.restassured.design;

import br.com.restassured.Configuration;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public abstract class BaseTest {

    @BeforeClass(alwaysRun = true)
    public static void beforeClass() {
        // versão 1
        Configuration configuration = new Configuration();

        baseURI = configuration.getBaseUrl();
        basePath = configuration.getBasePath();

        // versão 2 (sem "Configuration", "ReadProperties" e "configuration.properties")
//        baseURI = "https://jsonplaceholder.typicode.com";
//        basePath = "/todos";
    }
}
