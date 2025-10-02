package API.tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class RegisterUserTest extends ApiBaseTest
{
    @Test
    public void testUserRegistrationByDeviceId()
    {
        String reqBody = """ 
                {"deviceId": "9516-65dfbdf"}
                """;
                given()
                .contentType(ContentType.JSON)
                .body(reqBody)
                .when().post("/register")
                        .then()
                        .statusCode(200)
                        .body("success", equalTo(true))
                        .body("user.deviceId", equalTo("9516-65dfbdf"))
                        .body("user._playerData.tokens", equalTo(100))
                        .body("user._playerData.ownedEquipment[0].equipmentId", equalTo("char001"))
                        .body("user._playerData.ownedEquipment[1].equipmentId", equalTo("bat001"))
                        .body("token", notNullValue())
                        .body("user._id", notNullValue());

        System.out.println("Test PASSED: User registration API validated successfully.");
        }
    }
