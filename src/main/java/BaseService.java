import java.util.Map;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class BaseService {
    final String URL = "https://automationexercise.com/api";

    public Response getRequest(String endpoint) {
        return when().get(URL + endpoint);
    }

    public Response postRequest(String endpoint, Map<String, Object> newMap) {
        return given().contentType("application/json").body(newMap)
                .when().post(URL + endpoint);
    }

    public Response putRequest(String endpoint, Map<String, Object> updatedMap) {
        return given().contentType("application/json").body(updatedMap)
                .when().put(URL + endpoint);
    }
}
