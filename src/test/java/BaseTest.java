import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BaseTest {
    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://automationexercise.com/api";
    }

    public void checkStatusCode(Response response, int responseCode) {
        response.then().assertThat().statusCode(responseCode);
    }

    public void verifyListExists(Response response, String listName) {
        List<Map<String, Object>> list = response.getBody().jsonPath().get(listName);

        assertThat(list, is(notNullValue()));
        assertThat(list, not(empty()));
    }
}