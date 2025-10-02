package API.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class ApiBaseTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://13.49.60.37:3000/api";
        // Optionally set defaults: port, basePath, authentication, etc.
    }
}
