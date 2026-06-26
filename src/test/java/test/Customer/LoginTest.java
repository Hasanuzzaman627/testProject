package test.Customer;

import org.testng.annotations.Test;
import page.commonPage;
import page.customer.LoginPage;
import test.BaseTest;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test
    public void verifyUserCanLoginWithValidCredentials() throws IOException, InterruptedException {

        OpenBrowserWithCredentials("");

        LoginPage loginPage = new LoginPage(page);
        commonPage commonPage = new commonPage(page);
        commonPage
                .maximizeWindow() // Maximize window here if desired
                .navigateTo(property("base_url") + "/login");
        loginPage
                .fillEmailorMobile()
                .fillPassword()
                .clickOnSignInBtn();
    }
}
