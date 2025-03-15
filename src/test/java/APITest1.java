import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

//        API 1: Get All Products List
//        API URL: https://automationexercise.com/api/productsList
//        Request Method: GET
//        Response Code: 200
//        Response JSON: All products list
public class APITest1 extends BaseTest {
    @Test
    public void getAllProductsList_checkProductsListExists() {
        BaseService baseService = new BaseService();
        String endpoint = "/productsList";

        Response response = baseService.getRequest(endpoint);

        checkResponseCode(response, OK_RESPONSE_CODE);

        verifyListExists(response, "products");
    }
}