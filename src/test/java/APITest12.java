import java.util.Map;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

//        API 12: DELETE METHOD To Delete User Account
//        API URL: https://automationexercise.com/api/deleteAccount
//        Request Method: DELETE
//        Request Parameters: email, password
//        Response Code: 200
//        Response Message: Account deleted!
public class APITest12 extends BaseTest {
    @Test
    public void deleteUserAccount_checkDeletedSuccessfully() {
        BaseService baseService = new BaseService();
        Map<String, String> loginDetails = Map.of("email", "charliekelly@email.com", "password", "itsalwayssunny");
        Response response = baseService.sendDeleteRequest("/deleteAccount", loginDetails);

        assertThat(response.getStatusCode(), equalTo(OK_RESPONSE_STATUS_CODE));
        assertThat(baseService.getResponseCode(response), equalTo(OK_RESPONSE_STATUS_CODE));
        assertThat(baseService.getResponseMessage(response), equalTo(OK_RESPONSE_ACCOUNT_DELETED));
    }
}
