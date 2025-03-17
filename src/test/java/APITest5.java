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
        String searchValue = "jean";
        Map<String, Object> queries = Map.of("search_product", searchValue);
        Response response = baseService.sendPostRequestWithQueries( "/searchProduct", queries);
        List<Map<String, Object>> productsList = baseService.getResponseList(response,"products");

        assertThat(response.getStatusCode(), equalTo(OK_RESPONSE_STATUS_CODE));

        assertThat(baseService.getResponseCode(response), equalTo(OK_RESPONSE_STATUS_CODE));

        verifyProductsRelatedToSearch(productsList, searchValue);
    }

    public void verifyProductsRelatedToSearch(List<Map<String, Object>> productsList, String searchText) {
        for (Map<String, Object> product : productsList) {
            String productName = product.get("name").toString().toLowerCase();

            assertThat(productName, containsString(searchText));
        }
    }
}
