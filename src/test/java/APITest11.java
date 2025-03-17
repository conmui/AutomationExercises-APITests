import java.util.Map;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class APITest11 extends BaseTest {
    @Test
    public void createRegisterNewUser_checkUserAddedSuccessfully() {
        BaseService baseService = new BaseService();
        Map<String, Object> newUser = createUserMap("dayman", "charliekelly@email.com", "itsalwayssunny", "Mr", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "90013", "California", "Los Angeles", "2136265731");
        Response response = baseService.sendPostRequestWithQueries("/createAccount", newUser);

        assertThat(response.getStatusCode(), equalTo(OK_RESPONSE_STATUS_CODE));
        assertThat(baseService.getResponseCode(response), equalTo(CREATED_CODE));
        assertThat(baseService.getResponseMessage(response), equalTo(CREATED_MESSAGE));
    }
}
