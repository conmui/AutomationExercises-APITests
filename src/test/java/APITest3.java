import java.util.List;
import java.util.Map;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

//        API 3: Get All Brands List
//        API URL: https://automationexercise.com/api/brandsList
//        Request Method: GET
//        Response Code: 200
//        Response JSON: All brands list
public class APITest3 extends BaseTest {
    @Test
    public void getAllBrandsList_checkProductsListExists() {
        BaseService baseService = new BaseService();
        Response response = baseService.sendGetRequest("/brandsList");
        List<Map<String, Object>> brandsList = baseService.getResponseList(response, "brands");

        assertThat(response.getStatusCode(), equalTo(OK_RESPONSE_STATUS_CODE));

        assertThat(baseService.getResponseCode(response), equalTo(OK_RESPONSE_STATUS_CODE));

        verifyResponseListExists(brandsList);
    }
}
