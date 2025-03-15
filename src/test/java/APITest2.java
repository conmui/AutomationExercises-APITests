import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

//        API 2: POST To All Products List
//        API URL: https://automationexercise.com/api/productsList
//        Request Method: POST
//        Response Code: 405
//        Response Message: This request method is not supported.
public class APITest2 extends BaseTest {
    @Test
    public void postNewProduct_checkReqNotAllowedAndProductsListUnchanged() {
        BaseService baseService = new BaseService();
        String endpoint = "/productsList";
        Map<String, Object> newProduct = createProduct(50, "Relaxed Jeans", "Rs. 1100", "H&M", "Men", "Jeans");
        String listName = "products";

        Response initialGetResponse = baseService.getRequest(endpoint);
        Response postResponse = baseService.postRequest(endpoint, newProduct);
        Response finalGetResponse = baseService.getRequest(endpoint);

        List<Map<String, Object>> initialProductsList = getResponseList(initialGetResponse, listName);

        verifyResponse(postResponse, NOT_ALLOWED_RESPONSE_CODE, NOT_ALLOWED_MESSAGE);

        List<Map<String, Object>> finalProductsList = getResponseList(finalGetResponse, listName);
        assertThat(initialProductsList, equalTo(finalProductsList));
    }

    public Map<String, Object> createProduct(int productId, String productName, String productPrice, String productBrand, String productUserType, String productCategory) {
        Map<String, Object> product = new HashMap<>();
        Map<String, Object> category = new HashMap<>();

        product.put("id", productId);
        product.put("name", productName);
        product.put("price", productPrice);
        product.put("brand", productBrand);
        category.put("usertype", productUserType);
        category.put("category", productCategory);
        product.put("category", category);

        return product;
    }
}
