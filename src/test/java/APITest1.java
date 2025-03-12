import java.util.List;
import java.util.Map;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.when;

//        API 1: Get All Products List
public class APITest1 extends BaseTest {
    @Test
    public void test() {
//        API URL: https://automationexercise.com/api/productsList
//        Request Method: GET
        Response response = when().get("/productsList");

//        Response Code: 200
        response.then().statusCode(200);

//        Response JSON: All products list
        List<Map<String, Object>> products = response.jsonPath().get("products");
    }
}