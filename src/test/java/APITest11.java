import java.util.HashMap;
import java.util.Map;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

//        API 11: POST To Create/Register User Account
//        API URL: https://automationexercise.com/api/createAccount
//        Request Method: POST
//        Request Parameters: name, email, password, title (for example: Mr, Mrs, Miss), birth_date, birth_month, birth_year, firstname, lastname, company, address1, address2, country, zipcode, state, city, mobile_number
//        Response Code: 201
//        Response Message: User created!
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
