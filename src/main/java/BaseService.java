import java.util.List;
import java.util.Map;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class BaseService {
    final String URL = "https://automationexercise.com/api";

    //GET
    public Response getRequest(String endpoint) {
        return given()
                .when()
                    .get(URL + endpoint);
    }

    //POST
    public Response postRequest(RequestSpecification requestSpecification, String endpoint) {
        return requestSpecification
                .when()
                    .post(URL + endpoint);
    }

    public Response postRequest(String endpoint) {
        return given()
                .when()
                    .post(URL + endpoint);
    }

    public Response postRequestWithQuery(String endpoint, String param, String value) {
        RequestSpecification requestSpecification =
                given()
                    .param(param, value);

        return postRequest(requestSpecification, endpoint);
    }

    public Response postRequestWithBody(String endpoint, Map<String, Object> newMap) {
        RequestSpecification requestSpecification =
                given()
                        .contentType("application/json")
                        .body(newMap);

        return postRequest(requestSpecification, endpoint);
    }

    //PUT
    public Response putRequest(String endpoint, Map<String, Object> updatedMap) {
        return given()
                    .contentType("application/json")
                    .body(updatedMap)
                .when()
                    .put(URL + endpoint);
    }

    public int getResponseCode(Response response) {
        return response
                .getBody()
                .jsonPath()
                .getInt("responseCode");
    }

    public List<Map<String, Object>> getResponseList(Response response, String listName) {
        return response
                .getBody()
                .jsonPath()
                .get(listName);
    }

    public String getResponseMessage(Response response) {
        return response
                .getBody()
                .jsonPath()
                .get("message");
    }
}
