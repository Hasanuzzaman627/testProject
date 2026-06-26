package page.customer;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import page.BasePage;

import java.io.IOException;

import static test.BaseTest.property;

public class LoginPage extends BasePage {
    /**
     * Constructor to initialize the page object.
     *
     * @param page The Playwright Page object.
     */
    public LoginPage(Page page) {
        super(page);
    }

    @Step("fill Email or Mobile")
    public LoginPage fillEmailorMobile() throws IOException {
        Tn_fillByLocator("emailOrMobile", property("login_mobile"));
        return this;
    }

    @Step("fill Password")
    public LoginPage fillPassword() throws IOException {
        Tn_fillByLocator("password", property("login_password"));
        return this;
    }

    public void clickOnSignInBtn() throws InterruptedException {
        Tn_clickByText("to Access the Best Deals and Products in Bangladesh!");
        Tn_clickByRole("button", "Sign In");
        Tn_waitForElement("getHelpAndSupportLocator", 0);
        Tn_containsText("getHelpAndSupportLocator", "Hasan", 0);
    }
}
