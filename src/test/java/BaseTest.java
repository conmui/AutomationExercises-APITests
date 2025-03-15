import java.util.List;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BaseTest {
    final int OK_RESPONSE_STATUS_CODE = 200;
    final int NOT_ALLOWED_RESPONSE_CODE = 405;
    final String NOT_ALLOWED_MESSAGE = "This request method is not supported.";

    public void verifyResponseListExists(List<Map<String, Object>> list) {
        assertThat(list, is(notNullValue()));
        assertThat(list, not(empty()));
    }
}