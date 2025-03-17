import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class APITest4 extends BaseTest {
    @Test
    public void putUpdateProduct_checkReqNotAllowedAndBrandsListUnchanged() {
        BaseService baseService = new BaseService();
        String endpoint = "/brandsList";
        String listName = "brands";
        Map<String, Object> updatedBrand = createBrand(3, "Uniqlo");
        List<Map<String, Object>> initialBrandsList = baseService.getResponseData(baseService.sendGetRequest(endpoint), listName);
        Response putResponse = baseService.sendPutRequest(endpoint, updatedBrand);
        List<Map<String, Object>> finalBrandsList = baseService.getResponseData(baseService.sendGetRequest(endpoint), listName);

        assertThat(putResponse.getStatusCode(), equalTo(OK_RESPONSE_STATUS_CODE));
        assertThat(baseService.getResponseCode(putResponse), equalTo(NOT_ALLOWED_RESPONSE_CODE));
        assertThat(baseService.getResponseMessage(putResponse), equalTo(NOT_ALLOWED_MESSAGE));

        assertThat(initialBrandsList, equalTo(finalBrandsList));
    }

    public Map<String, Object> createBrand(int brandId, String brandName) {
        Map<String, Object> map = new HashMap<>();

        map.put("id", brandId);
        map.put("brand", brandName);

        return map;
    }
}
