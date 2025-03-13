import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

//        API 2: POST To All Products List
//        API URL: https://automationexercise.com/api/productsList
//        Request Method: POST
//        Response Code: 405
//        Response Message: This request method is not supported.
public class APITest2 extends BaseTest {
    @Test
    public void postNewProduct_checkReqNotSupportedAndProductsListSameBeforeAndAfter() {
        Map<String, Object> newProduct = createProduct(50, "Relaxed Jeans", "Rs. 1100", "H&M", "Men", "Jeans");
        final int EXPECTED_RESPONSE_CODE = 405;
        final String EXPECTED_MESSAGE = "This request method is not supported.";

        List<Map<String, Object>> initialProductsList = getProductsList();

        verifyPostResponse(newProduct, EXPECTED_RESPONSE_CODE, EXPECTED_MESSAGE);

        List<Map<String, Object>> finalProductsList = getProductsList();
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

    public List<Map<String, Object>> getProductsList() {
        Response response = when().get("/productsList");

        return response.getBody().jsonPath().get("products");
    }

    public void verifyPostResponse(Map<String, Object> newProduct, int expectedResponseCode, String expectedMessage) {
        Response response = given().contentType("application/json").body(newProduct).when().post("/productsList");
        JsonPath json = response.getBody().jsonPath();
        int responseCode = json.getInt("responseCode");
        String responseMessage = json.get("message");

        assertThat(responseCode, equalTo(expectedResponseCode));
        assertThat(responseMessage, equalTo(expectedMessage));
    }
}
