import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.when;

//        API 1: Get All Products List
//        API URL: https://automationexercise.com/api/productsList
//        Request Method: GET
//        Response Code: 200
//        Response JSON: All products list
public class APITest1 extends BaseTest {
    @Test
    public void getAllProductsList_checkProductsListExists() {
        Response response = when().get("/productsList");
        int expectedStatusCode = 200;

        checkStatusCode(response, expectedStatusCode);

        verifyListExists(response, "products");
    }
}