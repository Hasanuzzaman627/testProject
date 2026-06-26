package test.Customer;

import org.testng.annotations.Test;
import page.commonPage;
import page.customer.AddressPage;
import test.BaseTest;

import java.io.IOException;

import static utils.constant.customer;

public class AddressTest extends BaseTest {

    @Test
    public void verifyToAddAddress() throws IOException, InterruptedException {

        OpenBrowserWithCredentials(customer);

        AddressPage addaddressPage = new AddressPage(page);
        commonPage commonPage = new commonPage(page);
        commonPage
                .maximizeWindow() // Maximize window here if desired
                .navigateTo(property("base_url"));
        //this.page.waitForLoadState(LoadState.LOAD);
        addaddressPage
                .profile()
                .clickOnAddress()
                .clickOnAddAddressButton()
                .fillNameOnAddAddress()
                .fillMobileNumber()
                .clickOnSelectDistrictField()
                .fillSelectDistrict()
                .clickOnDistrictDropDown()
                .clickOnSelectCityField()
                .fillSelectCity()
                .clickOnCityDropDownData()
                .clickOnSelectAreaField()
                .fillSelectArea()
                .clickOnAreaDropDownData()
                .fillAddressOnDetailedAddress()
                .clickOnEffectiveDelivery()
                .clickOnSaveButton()
                .getSuccessToastText();
    }
}
