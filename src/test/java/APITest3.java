import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

//        API 3: Get All Brands List
//        API URL: https://automationexercise.com/api/brandsList
//        Request Method: GET
//        Response Code: 200
//        Response JSON: All brands list
public class APITest3 extends BaseTest {
    @Test
    public void getAllBrandsList_checkProductsListExists() {
        BaseService baseService = new BaseService();
        String endpoint = "/brandsList";

        Response response = baseService.getRequest(endpoint);

        checkResponseCode(response, OK_RESPONSE_CODE);

        verifyListExists(response, "brands");
    }
}
