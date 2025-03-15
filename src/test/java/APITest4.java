import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

//        API 4: PUT To All Brands List
//        API URL: https://automationexercise.com/api/brandsList
//        Request Method: PUT
//        Response Code: 405
//        Response Message: This request method is not supported.
public class APITest4 extends BaseTest {
    @Test
    public void putUpdateProduct_checkReqNotAllowedAndBrandsListSameBeforeAndAfterReq() {
        BaseService baseService = new BaseService();
        String endpoint = "/brandsList";
        Map<String, Object> updatedBrand = createBrand(3, "Uniqlo");
        String listName = "brands";

        Response initialGetResponse = baseService.getRequest(endpoint);
        Response putResponse = baseService.putRequest(endpoint, updatedBrand);
        Response finalGetResponse = baseService.getRequest(endpoint);

        List<Map<String, Object>> initialBrandsList = getResponseList(initialGetResponse, listName);

        verifyResponse(putResponse, NOT_ALLOWED_RESPONSE_CODE, NOT_ALLOWED_MESSAGE);

        List<Map<String, Object>> finalBrandsList = getResponseList(finalGetResponse, listName);
        assertThat(initialBrandsList, equalTo(finalBrandsList));
    }

    public Map<String, Object> createBrand(int brandId, String brandName) {
        Map<String, Object> map = new HashMap<>();

        map.put("id", brandId);
        map.put("brand", brandName);

        return map;
    }
}
