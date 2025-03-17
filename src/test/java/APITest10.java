import java.util.Map;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class APITest10 extends BaseTest {
    @Test
    public void postLoginWithInvalidDetails_checkUserNotFound() {
        BaseService baseService = new BaseService();
        Map<String, Object> invalidDetails = Map.of("email", "charlie@email.com", "password", "itsalwaysSunny");
        Response response = baseService.sendPostRequestWithQueries("/verifyLogin", invalidDetails);

        assertThat(response.getStatusCode(), equalTo(OK_RESPONSE_STATUS_CODE));
        assertThat(baseService.getResponseCode(response), equalTo(NOT_FOUND_CODE));
        assertThat(baseService.getResponseMessage(response), equalTo(NOT_FOUND_MESSAGE));
    }
}
