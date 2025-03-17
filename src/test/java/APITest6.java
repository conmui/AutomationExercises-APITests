import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class APITest6 extends BaseTest {
    @Test
    public void postSearchProductWithoutParams_checkBadRequest() {
        BaseService baseService = new BaseService();
        Response response = baseService.sendPostRequest("/searchProduct");

        assertThat(response.getStatusCode(), equalTo(OK_RESPONSE_STATUS_CODE));
        assertThat(baseService.getResponseCode(response), equalTo(BAD_REQUEST_CODE));
        assertThat(baseService.getResponseMessage(response), equalTo(BAD_REQUEST_MESSAGE_SEARCH));
    }
}
