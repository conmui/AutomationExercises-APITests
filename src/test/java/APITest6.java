import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

//        API 6: POST To Search Product without search_product parameter
//        API URL: https://automationexercise.com/api/searchProduct
//        Request Method: POST
//        Response Code: 400
//        Response Message: Bad request, search_product parameter is missing in POST request.
public class APITest6 extends BaseTest {
    @Test
    public void postSearchProductWithoutParams_checkBadRequest() {
        BaseService baseService = new BaseService();
        Response response = baseService.postRequest("/searchProduct");

        assertThat(response.getStatusCode(), equalTo(OK_RESPONSE_STATUS_CODE));
        assertThat(baseService.getResponseCode(response), equalTo(BAD_REQUEST_CODE));
        assertThat(baseService.getResponseMessage(response), equalTo(BAD_REQUEST_MESSAGE_SEARCH));
    }
}
