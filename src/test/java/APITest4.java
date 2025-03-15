import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Map<String, Object> updatedBrand = createBrand(3, "Uniqlo");
        String endpoint = "/brandsList";
        String listName = "brands";

        List<Map<String, Object>> initialBrandsList = getResponseList(endpoint, listName);

        verifyResponse("put", endpoint, updatedBrand, NOT_ALLOWED_RESPONSE_CODE, NOT_ALLOWED_MESSAGE);

        List<Map<String, Object>> finalBrandsList = getResponseList(endpoint, listName);
        assertThat(initialBrandsList, equalTo(finalBrandsList));
    }

    public Map<String, Object> createBrand(int brandId, String brandName) {
        Map<String, Object> map = new HashMap<>();

        map.put("id", brandId);
        map.put("brand", brandName);

        return map;
    }
}
