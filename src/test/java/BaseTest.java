import java.util.List;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BaseTest {
    final int OK_RESPONSE_CODE = 200;
    final int NOT_ALLOWED_RESPONSE_CODE = 405;
    final String NOT_ALLOWED_MESSAGE = "This request method is not supported.";

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://automationexercise.com/api";
    }

    public void checkResponseCode(Response response, int expectedResponseCode) {
        int responseCode = response.getBody().jsonPath().get("responseCode");
        assertThat(responseCode, equalTo(expectedResponseCode));
    }

    public void verifyListExists(Response response, String listName) {
        List<Map<String, Object>> list = response.getBody().jsonPath().get(listName);

        assertThat(list, is(notNullValue()));
        assertThat(list, not(empty()));
    }

    public List<Map<String, Object>> getResponseList(String endpoint, String listName) {
        Response response = when().get(endpoint);

        return response.getBody().jsonPath().get(listName);
    }

    public void verifyResponse(String method, String endpoint, Map<String, Object> newMap, int expectedResponseCode, String expectedMessage) {
        Response response = null;

        RequestSpecification request = given().contentType("application/json").body(newMap);

        if (method.equals("post")) {
            response = request.post(endpoint);
        } else if (method.equals("put")) {
            response = request.put(endpoint);
        }

        JsonPath json = response.getBody().jsonPath();
        int responseCode = json.getInt("responseCode");
        String responseMessage = json.get("message");

        assertThat(responseCode, equalTo(expectedResponseCode));
        assertThat(responseMessage, equalTo(expectedMessage));
    }
}