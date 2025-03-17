import java.util.Map;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

//        API 9: DELETE To Verify Login
//        API URL: https://automationexercise.com/api/verifyLogin
//        Request Method: DELETE
//        Response Code: 405
//        Response Message: This request method is not supported.
public class APITest9 extends BaseTest {
    @Test
    public void deleteLogin_checkNotAllowed() {
        BaseService baseService = new BaseService();
        Map<String, Object> loginDetails = Map.of("email", "charliekelly@email.com", "password", "itsalwayssunny");
        Response response = baseService.sendDeleteRequest("/verifyLogin", loginDetails);

        assertThat(response.getStatusCode(), equalTo(OK_RESPONSE_STATUS_CODE));
        assertThat(baseService.getResponseCode(response), equalTo(NOT_ALLOWED_RESPONSE_CODE));
        assertThat(baseService.getResponseMessage(response), equalTo(NOT_ALLOWED_MESSAGE));
    }
}