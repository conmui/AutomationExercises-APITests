import java.util.Map;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class APITest7 extends BaseTest {
    @Test
    public void postValidLogin_checkUserExists() {
        BaseService baseService = new BaseService();
        Map<String, Object> queries = Map.of("email", "charliekelly@email.com", "password", "itsalwayssunny");
        Response response = baseService.sendPostRequestWithQueries("/verifyLogin", queries);

        assertThat(response.getStatusCode(), equalTo(OK_RESPONSE_STATUS_CODE));
        assertThat(baseService.getResponseCode(response), equalTo(OK_RESPONSE_STATUS_CODE));
        assertThat(baseService.getResponseMessage(response), equalTo(OK_RESPONSE_USER_EXISTS_MESSAGE));
    }
}
