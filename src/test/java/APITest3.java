import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.when;

//        API 3: Get All Brands List
//        API URL: https://automationexercise.com/api/brandsList
//        Request Method: GET
//        Response Code: 200
//        Response JSON: All brands list
public class APITest3 extends BaseTest {
    @Test
    public void getAllBrandsList_checkProductsListExists() {
        Response response = when().get("/brandsList");
        int expectedStatusCode = 200;

        checkStatusCode(response, expectedStatusCode);

        verifyListExists(response, "brands");
    }
}
