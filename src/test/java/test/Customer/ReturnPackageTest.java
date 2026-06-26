package test.Customer;

import org.testng.annotations.Test;
import page.commonPage;
import page.customer.CustomerProfileMenuPage;
import page.customer.ReturnPackagePage;
import test.BaseTest;

import java.io.IOException;

import static page.enums.CustomerProfileMenuEnum.MY_RETURNS;
import static utils.constant.customer;

public class ReturnPackageTest extends BaseTest {

    @Test()
    public void VerifyThatUserCanInitiateReturnRequestFromTheCustomerPanel() throws InterruptedException, IOException {

        OpenBrowserWithCredentials(customer);

        ReturnPackagePage returnPackagePage = new ReturnPackagePage(page);
        CustomerProfileMenuPage customerProfileMenuPage = new CustomerProfileMenuPage(page);

        commonPage commonPage = new commonPage(page);

        commonPage
                .maximizeWindow() // Maximize window here if desired
                .navigateTo(property("base_url"));

        returnPackagePage
                .clickProfileButton();

        customerProfileMenuPage
                .clickCustomerMenu(String.valueOf(MY_RETURNS));

        returnPackagePage
                .clickOnInitiateReturnTab()
                .clickOnReturnButton("25042779609427")
                .clickOnReturnReasonDropdown()
                .fillDescriptionField()
                .uploadPicture();
        Thread.sleep(2000);

        returnPackagePage
                .clickOnSubmitButtOnReturnRequest()
                .clickOnAllReturnTab()
                .clickOnTrackReturnTab();
        Thread.sleep(2000);
        returnPackagePage.extractCRCode();
    }
}
