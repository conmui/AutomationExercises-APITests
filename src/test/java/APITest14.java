import java.util.HashMap;
import java.util.Map;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class APITest14 extends BaseTest {
    @Test
    public void test() {
        BaseService baseService = new BaseService();
        Response response = baseService.sendGetRequestWithQuery("/getUserDetailByEmail", "email", "charliekelly@email.com");
        Map<String, Object> responseUser = baseService.getResponseData(response, "user");
        Map<String, Object> expectedUser = createExpectedUserDetails(responseUser.get("id"), "dayman", "charliekelly@email.com", "Mr", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "California", "Los Angeles", "90013");

        assertThat(response.getStatusCode(), equalTo(OK_RESPONSE_STATUS_CODE));
        assertThat(baseService.getResponseCode(response), equalTo(OK_RESPONSE_STATUS_CODE));
        assertThat(responseUser, equalTo(expectedUser));
    }

    public Map<String, Object> createExpectedUserDetails(Object userId, String name, String email, String title, String birthDay, String birthMonth, String birthYear, String firstName, String lastName, String company, String address1, String address2, String country, String state, String city, String zipcode) {
        Map<String, Object> user = new HashMap<>();
        user.put("id", userId);
        user.put("name", name);
        user.put("email", email);
        user.put("title", title);
        user.put("birth_day", birthDay);
        user.put("birth_month", birthMonth);
        user.put("birth_year", birthYear);
        user.put("first_name", firstName);
        user.put("last_name", lastName);
        user.put("company", company);
        user.put("address1", address1);
        user.put("address2", address2);
        user.put("country", country);
        user.put("state", state);
        user.put("city", city);
        user.put("zipcode", zipcode);

        return user;
    }
}
