import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

//        API 8: POST To Verify Login without email parameter
//        API URL: https://automationexercise.com/api/verifyLogin
//        Request Method: POST
//        Request Parameter: password
//        Response Code: 400
//        Response Message: Bad request, email or password parameter is missing in POST request.
public class APITest8 extends BaseTest {
    @Test
    public void postLoginWithoutParams_checkBadRequest() {
        BaseService baseService = new BaseService();
        Response response = baseService.sendPostRequest("/verifyLogin");

        assertThat(response.getStatusCode(), equalTo(OK_RESPONSE_STATUS_CODE));
        assertThat(baseService.getResponseCode(response), equalTo(BAD_REQUEST_CODE));
        assertThat(baseService.getResponseMessage(response), equalTo(BAD_REQUEST_MESSAGE_LOGIN));
    }
}
