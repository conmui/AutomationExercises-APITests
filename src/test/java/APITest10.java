import java.util.Map;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

//        API 10: POST To Verify Login with invalid details
//        API URL: https://automationexercise.com/api/verifyLogin
//        Request Method: POST
//        Request Parameters: email, password (invalid values)
//        Response Code: 404
//        Response Message: User not found!
public class APITest10 extends BaseTest {
    @Test
    public void postLoginWithInvalidDetails_checkUserNotFound() {
        BaseService baseService = new BaseService();
        Map<String, String> invalidDetails = Map.of("email", "charlie@email.com", "password", "itsalwaysSunny");
        Response response = baseService.sendPostRequestWithQueries("/verifyLogin", invalidDetails);

        assertThat(response.getStatusCode(), equalTo(OK_RESPONSE_STATUS_CODE));
        assertThat(baseService.getResponseCode(response), equalTo(NOT_FOUND_CODE));
        assertThat(baseService.getResponseMessage(response), equalTo(NOT_FOUND_MESSAGE));
    }
}
