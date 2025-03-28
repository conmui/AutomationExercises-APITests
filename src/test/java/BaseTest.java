import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BaseTest {
    final int OK_RESPONSE_STATUS_CODE = 200;
    final String OK_RESPONSE_USER_EXISTS_MESSAGE = "User exists!";
    final String OK_RESPONSE_ACCOUNT_DELETED = "Account deleted!";
    final String OK_RESPONSE_ACCOUNT_UPDATED = "User updated!";
    final int CREATED_CODE = 201;
    final String CREATED_MESSAGE = "User created!";
    final int BAD_REQUEST_CODE = 400;
    final String BAD_REQUEST_MESSAGE_SEARCH = "Bad request, search_product parameter is missing in POST request.";
    final String BAD_REQUEST_MESSAGE_LOGIN = "Bad request, email or password parameter is missing in POST request.";
    final int NOT_FOUND_CODE = 404;
    final String NOT_FOUND_MESSAGE = "User not found!";
    final int NOT_ALLOWED_RESPONSE_CODE = 405;
    final String NOT_ALLOWED_MESSAGE = "This request method is not supported.";

    public void verifyResponseListExists(List<Map<String, Object>> list) {
        assertThat(list, is(notNullValue()));
        assertThat(list, not(empty()));
    }

    public Map<String, Object> createUserMap(String name, String email, String password, String title, String birthDate, String birthMonth, String birthYear, String firstName, String lastName, String company, String address1, String address2, String country, String zipcode, String state, String city, String mobileNumber) {
        Map<String, Object> newUser = new HashMap<>();

        newUser.put("name", name);
        newUser.put("email", email);
        newUser.put("password", password);
        newUser.put("title", title);
        newUser.put("birth_date", birthDate);
        newUser.put("birth_month", birthMonth);
        newUser.put("birth_year", birthYear);
        newUser.put("firstname", firstName);
        newUser.put("lastname", lastName);
        newUser.put("company", company);
        newUser.put("address1", address1);
        newUser.put("address2", address2);
        newUser.put("country", country);
        newUser.put("zipcode", zipcode);
        newUser.put("state", state);
        newUser.put("city", city);
        newUser.put("mobile_number", mobileNumber);

        return newUser;
    }
}