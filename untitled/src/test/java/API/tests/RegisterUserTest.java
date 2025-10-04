package API.tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class RegisterUserTest extends ApiBaseTest {
    static String userToken;
    static String userId = "776559654585";

    @BeforeClass
    @Test
    public void testUserRegistrationByDeviceId() {
        String reqBody = """ 
                {"deviceId": "%s"}
                """.formatted(userId);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(reqBody)
                .when().post("/register")
                .then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("user.deviceId", equalTo(userId))
                .body("user._playerData.tokens", equalTo(100))
                .body("user._playerData.ownedEquipment[0].equipmentId", equalTo("char001"))
                .body("user._playerData.ownedEquipment[1].equipmentId", equalTo("bat001"))
                .body("token", notNullValue())
                .body("user._id", notNullValue()).extract().response();

        userToken = response.jsonPath().getString("token");

        System.out.println("Test PASSED: User registration API validated successfully.");
    }

    @Test
    public void updateEquipmentTest() {
        given()
                .header("Authorization", "Bearer " + userToken)
                .contentType("application/json")
                .body("{ \"equipmentId\": \"char001\", \"currentLevel\": \"3\" }")
                .when()
                .post("/updateEquipment")
                .then()
                .statusCode(200)
                .body("user._playerData.ownedEquipment[0].equipmentId", equalTo("char001"))
                .body("user._playerData.ownedEquipment[0].currentLevel", equalTo("3"));
    }

    @Test
    public void updateCoins()
    {
        given()
                .header("Authorization", "Bearer " + userToken)
                .contentType("application/json")
                .body("{\n" +
                        "    \"coins\": 200\n" +
                        "}")
                .when()
                .post("/updateCoins")
                .then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("updatedValue", equalTo(300));
    }

    @Test
    public void updateTokens()
    {
        given()
                .header("Authorization", "Bearer " + userToken)
                .contentType("application/json")
                .body("{\n" +
                        "    \"tokens\": 200\n" +
                        "}")
                .when()
                .post("/updateTokens")
                .then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("updatedValue", equalTo(300));
    }

    @Test
    public void updateGems()
    {
        given()
                .header("Authorization", "Bearer " + userToken)
                .contentType("application/json")
                .body("{\n" +
                        "    \"gems\": 200\n" +
                        "}")
                .when()
                .post("/updateGems")
                .then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("updatedValue", equalTo(300));
    }
}

