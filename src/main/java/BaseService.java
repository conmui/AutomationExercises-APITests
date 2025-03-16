import java.util.List;
import java.util.Map;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class BaseService {
    final String URL = "https://automationexercise.com/api";

    //GET
    public Response sendGetRequest(String endpoint) {
        return given()
                .when()
                    .get(URL + endpoint);
    }

    //POST
    public Response sendPostRequest(RequestSpecification requestSpecification, String endpoint) {
        return requestSpecification
                .when()
                    .post(URL + endpoint);
    }

    public Response sendPostRequest(String endpoint) {
        return given()
                .when()
                    .post(URL + endpoint);
    }

    public Response sendPostRequestWithQueries(String endpoint, Map<String, String> queries) {
        RequestSpecification requestSpecification =
                given()
                        .params(queries);

        return sendPostRequest(requestSpecification, endpoint);
    }

    public Response sendPostRequestWithBody(String endpoint, Map<String, Object> newMap) {
        RequestSpecification requestSpecification =
                given()
                        .contentType("application/json")
                        .body(newMap);

        return sendPostRequest(requestSpecification, endpoint);
    }

    //PUT
    public Response sendPutRequest(String endpoint, Map<String, Object> updatedMap) {
        return given()
                    .contentType("application/json")
                    .body(updatedMap)
                .when()
                    .put(URL + endpoint);
    }

    //DELETE
    public Response sendDeleteRequest(String endpoint, String queryParam, String queryValue) {
        return given()
                    .param(queryParam, queryValue)
                .when()
                    .delete(URL + endpoint);
    }

    //Response
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
