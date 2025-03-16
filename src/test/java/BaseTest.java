import java.util.List;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BaseTest {
    final int OK_RESPONSE_STATUS_CODE = 200;
    final int BAD_REQUEST_CODE = 400;
    final String BAD_REQUEST_MESSAGE = "Bad request, search_product parameter is missing in POST request.";
    final int NOT_ALLOWED_RESPONSE_CODE = 405;
    final String NOT_ALLOWED_MESSAGE = "This request method is not supported.";

    public void verifyResponseListExists(List<Map<String, Object>> list) {
        assertThat(list, is(notNullValue()));
        assertThat(list, not(empty()));
    }
}