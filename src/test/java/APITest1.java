import java.util.List;
import java.util.Map;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class APITest1 extends BaseTest {
    @Test
    public void getAllProductsList_checkProductsListExists() {
        BaseService baseService = new BaseService();
        Response response = baseService.sendGetRequest("/productsList");
        List<Map<String, Object>> productsList = baseService.getResponseData(response, "products");

        assertThat(response.getStatusCode(), equalTo(OK_RESPONSE_STATUS_CODE));

        assertThat(baseService.getResponseCode(response), equalTo(OK_RESPONSE_STATUS_CODE));

        verifyResponseListExists(productsList);
    }
}