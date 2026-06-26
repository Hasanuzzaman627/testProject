package API_Automation.Test;

import com.microsoft.playwright.APIResponse;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserTest extends BaseTest {

    @Test
    public void testGetUserAsCustomer() throws Exception {
        UserAPI customerApi = new UserAPI(playwright);
        APIResponse response = customerApi.getUser();

        assertEquals(response.status(), 200);
        System.out.println("Response: " + response.text());

        customerApi.dispose(); // Dispose role-specific context
    }
}
