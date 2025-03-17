import java.util.Map;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class APITest13 extends BaseTest {
    @Test
    public void updateUser_checkUserUpdated() {
        BaseService baseService = new BaseService();
        Map<String, Object> updatedUser = createUserMap("nightman", "charliekelly@email.com", "itsalwayssunny", "Mr", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "90013", "California", "Los Angeles", "2136265731");
        Response response = baseService.sendPutRequest("/updateAccount", updatedUser);

        assertThat(response.getStatusCode(), equalTo(OK_RESPONSE_STATUS_CODE));
        assertThat(baseService.getResponseCode(response), equalTo(OK_RESPONSE_STATUS_CODE));
        assertThat(baseService.getResponseMessage(response), equalTo(OK_RESPONSE_ACCOUNT_UPDATED));
    }
}
