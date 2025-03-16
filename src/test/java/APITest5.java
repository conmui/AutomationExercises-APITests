import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class APITest5 extends BaseTest {
    @Test
    public void postSearchProduct_checkProductsListRelatedToSearch() {
        BaseService baseService = new BaseService();
        String queryValue = "jean";
        Map<String, String> queries = Map.of("search_product", queryValue);
        Response postResponse = baseService.postRequestWithQueries( "/searchProduct", queries);
        List<Map<String, Object>> productsList = baseService.getResponseList(postResponse,"products");

        assertThat(postResponse.getStatusCode(), equalTo(OK_RESPONSE_STATUS_CODE));

        assertThat(baseService.getResponseCode(postResponse), equalTo(OK_RESPONSE_STATUS_CODE));

        verifyProductsRelatedToSearch(productsList, queryValue);
    }

    public void verifyProductsRelatedToSearch(List<Map<String, Object>> productsList, String searchText) {
        for (Map<String, Object> product : productsList) {
            String productName = product.get("name").toString().toLowerCase();

            assertThat(productName, containsString(searchText));
        }
    }
}
