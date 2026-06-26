package test;

import com.microsoft.playwright.BrowserContext;
import helpers.RetryAnalyzer;
import org.testng.annotations.Test;
import page.Logistics.LogisticsLoginPage;
import page.accounting.AccountingLoginPage;
import page.admin.AdminLoginPage;
import page.commonPage;
import page.customer.LoginPage;
import page.customer_support.CSLoginPage;
import page.inventory.InventoryLoginPage;
import page.seller_service.SellerLogin;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static utils.constant.*;

public class AllServiceUserLoginTest extends BaseTest {

    //Customer Service Login Test
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void verifyCustomerUserCanLoginWithValidCredentials() throws IOException, InterruptedException {

        OpenBrowserWithCredentials("");

        LoginPage loginPage = new LoginPage(page);
        commonPage commonPage = new commonPage(page);
        commonPage
                .maximizeWindow() // Maximize window here if desired
                .navigateTo(property("base_url") + "/auth/login");
        loginPage
                .fillEmailorMobile()
                .fillPassword()
                .clickOnSignInBtn();
        Thread.sleep(5000);

        Path AUTH_STATE_PATH = Paths.get("src/test/resources/authStates/customer.json");
        context.storageState(new BrowserContext.StorageStateOptions().setPath(AUTH_STATE_PATH));
        System.out.println("Customer Authentication state saved.");

    }

    //Admin Service Login Test
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void verifyAdminUserCanLoginWithValidCredentials() throws IOException, InterruptedException {

        OpenBrowserWithCredentials("");

        AdminLoginPage loginPage = new AdminLoginPage(page);
        commonPage commonPage = new commonPage(page);
        commonPage
                .maximizeWindow() // Maximize window here if desired
                .navigateTo(property("admin_base_url") + "/auth/login");
        loginPage
                .fillUserName()
                .fillPassword()
                .clickLoginBtn()
                .fillOTP();
        Thread.sleep(5000);

        loginPage.clickSubmitBtn().checkDashboardText();
        Path AUTH_STATE_PATH = Paths.get("src/test/resources/authStates/admin.json");
        context.storageState(new BrowserContext.StorageStateOptions().setPath(AUTH_STATE_PATH));
        System.out.println("Admin Authentication state saved.");
    }

    //CS Service Login Test
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void verifyCSUserCanLoginWithValidCredentials() throws IOException, InterruptedException {

        OpenBrowserWithCredentials("");

        CSLoginPage loginPage = new CSLoginPage(page);
        commonPage commonPage = new commonPage(page);
        commonPage
                .navigateTo(property("Cs_base_url") + "/auth/login");
        loginPage
                .filluserName()
                .fillPassword()
                .clickOnLogInBtn()
                .fillOTP();
        loginPage
                .clickOnverifyOtpBtn()
                .verifyCartUpDasgboardText();
        Thread.sleep(5000);

        Path AUTH_STATE_PATH = Paths.get("src/test/resources/authStates/customerSupport.json");
        context.storageState(new BrowserContext.StorageStateOptions().setPath(AUTH_STATE_PATH));
        System.out.println("🔒 Authentication state saved.");
    }

    //Seller Service Login Test
    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void verifySellerCanLoginWithValidCredentials() throws IOException, InterruptedException {

        OpenBrowserWithCredentials("");

        SellerLogin loginPage = new SellerLogin(page);
        commonPage commonPage = new commonPage(page);
        commonPage
                .maximizeWindow() // Maximize window here if desired
                .navigateTo(property("base_url_seller") + "/auth/sign-in");
        loginPage
                .fillSellerMobile()
                .fillSellerPassword()
                .clickOnLoginBtn();
        Thread.sleep(5000);

        Path AUTH_STATE_PATH = Paths.get("src/test/resources/authStates/seller.json");
        context.storageState(new BrowserContext.StorageStateOptions().setPath(AUTH_STATE_PATH));
        System.out.println("Seller Authentication state saved.");
    }

    //Inventory Service Login Test
    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void verifyInventoryUserCanLoginWithValidCredentials() throws IOException, InterruptedException {

        OpenBrowserWithCredentials("");

        InventoryLoginPage loginPage = new InventoryLoginPage(page);
        commonPage commonPage = new commonPage(page);
        commonPage
                .maximizeWindow() // Maximize window here if desired
                .navigateTo(property("inventory_base_url") + "/auth/login");
        loginPage
                .fillUserName()
                .fillPassword()
                .clickLoginBtn()
                .fillOTP();
        loginPage
                .clickSubmitBtn();
        Thread.sleep(10000);

        Path AUTH_STATE_PATH = Paths.get("src/test/resources/authStates/inventory.json");
        context.storageState(new BrowserContext.StorageStateOptions().setPath(AUTH_STATE_PATH));
        System.out.println("Inventory Authentication state saved.");
    }

    //Logistics Service Admin User Login Test
    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void verifyLogisticsUserCanLoginWithValidCredentials() throws IOException, InterruptedException {

        OpenBrowserWithCredentials("");

        LogisticsLoginPage loginPage = new LogisticsLoginPage(page);
        commonPage commonPage = new commonPage(page);
        commonPage
                .maximizeWindow() // Maximize window here if desired
                .navigateTo(property("base_url_logistics") + "/auth/login");
        loginPage
                .fillUserName("login_user_logistics")
                .fillPasswordLogisitics("login_password_logistics")
                .clickOnContinueBtn()
                .fillOTPLogistics();

        loginPage
                .clickOnVerifyOTPBtn();
        Thread.sleep(5000);

        Path AUTH_STATE_PATH = Paths.get("src/test/resources/authStates/logisticsAdmin.json");
        context.storageState(new BrowserContext.StorageStateOptions().setPath(AUTH_STATE_PATH));
        System.out.println("Logistics Admin Authentication state saved.");
    }

    //Logistics Service ShortCenter User Login Test
    @Test(priority = 7, retryAnalyzer = RetryAnalyzer.class)
    public void verifyLogisticsSortCenterUserCanLoginWithValidCredentials() throws IOException, InterruptedException {

        OpenBrowserWithCredentials("");

        LogisticsLoginPage loginPage = new LogisticsLoginPage(page);
        commonPage commonPage = new commonPage(page);
        commonPage
                .maximizeWindow() // Maximize window here if desired
                .navigateTo(property("base_url_logistics") + "/auth/login");
        loginPage
                .fillUserName("login_sort_user_logistics")
                .fillPasswordLogisitics("login_sort_password_logistics")
                .clickOnContinueBtn().fillOTPLogistics();

        loginPage
                .clickOnVerifyOTPBtn();
        Thread.sleep(5000);

        Path AUTH_STATE_PATH = Paths.get("src/test/resources/authStates/logisticsSortCenter.json");
        context.storageState(new BrowserContext.StorageStateOptions().setPath(AUTH_STATE_PATH));
        System.out.println("Logistics SortCenter Authentication state saved.");
    }

    //Accounting Service Login Test
    @Test(priority = 8, retryAnalyzer = RetryAnalyzer.class)
    public void verifyAccountingUserCanLoginWithValidCredentials() throws IOException, InterruptedException {
        OpenBrowserWithCredentials("");
        AccountingLoginPage loginPage = new AccountingLoginPage(page);
        commonPage commonPage = new commonPage(page);
        commonPage
                .maximizeWindow() // Maximize window here if desired
                .navigateTo(property("base_url_accounting") + "/auth/login");
        loginPage
                .fillUserName()
                .fillPassword()
                .clickLoginBtn()
                .fillOTP()
                .clickSubmitOTP();

        Path AUTH_STATE_PATH = Paths.get("src/test/resources/authStates/accounting.json");
        context.storageState(new BrowserContext.StorageStateOptions().setPath(AUTH_STATE_PATH));
        System.out.println("Accounting Authentication state saved.");
    }

      //demo
//    @Test(priority = 9)
//    public void LoginWithoutCredentials() throws IOException, InterruptedException {
//        OpenBrowserWithCredentials(seller);
//
//        commonPage commonPage = new commonPage(page);
//        commonPage
//                .maximizeWindow() // Maximize window here if desired
//                .navigateTo(property("base_url_seller") );
//        Thread.sleep(10000);
//
//    }
}
