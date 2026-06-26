package page.customer;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import page.BasePage;

import java.io.IOException;

public class AddressPage extends BasePage {

    /**
     * Constructor to initialize the page object.
     *
     * @param page The Playwright Page object.
     */


    public AddressPage(Page page) {
        super(page);
    }


    public AddressPage profile() throws IOException {
        Tn_clickByLocator("clickOnProfileName", 0);
        return this;
    }

    public AddressPage clickOnAddress() throws IOException {
        Tn_clickByText("Addresses");
        return this;
    }

    public AddressPage clickOnAddAddressButton() throws IOException {
        Tn_clickByRole("Button", "+ Add Address");
        return this;
    }

    @Step("fill Name On Add Address")
    public AddressPage fillNameOnAddAddress() throws IOException {
        Tn_fillByLocator("addAddressUserName", ("Sanzida Afrin"));
        return this;
    }

    @Step("fill Mobile Number")
    public AddressPage fillMobileNumber() throws IOException {
        Tn_fillByLocator("addAddressUserPhone", ("01780036790"));
        return this;
    }

    public AddressPage clickOnSelectDistrictField() throws IOException {
        Tn_clickByText("Select District", 1);
        return this;

    }

    @Step("fill Select District")
    public AddressPage fillSelectDistrict() throws IOException {
        Tn_fillByLocator("fillLocation", ("Dhaka South"));
        return this;
    }

    @Step("click On District Drop Down Data")
    public AddressPage clickOnDistrictDropDown() throws IOException {
        Tn_clickByLocator("districtSelect");
        return this;
    }

    public AddressPage clickOnSelectCityField() throws IOException {
        Tn_clickByText("Select City", 1);
        return this;

    }

    @Step("fill Select City")
    public AddressPage fillSelectCity() throws IOException {
        Tn_fillByLocator("fillLocation", ("Azimpur"));
        return this;
    }

    @Step("click On City Drop Down Data")
    public AddressPage clickOnCityDropDownData() throws IOException {
        Tn_clickByLocator("citySelect");
        return this;
    }

    public AddressPage clickOnSelectAreaField() throws IOException {
        Tn_clickByText("Select Area", 1);
        return this;

    }

    @Step("fill Select Area")
    public AddressPage fillSelectArea() throws IOException {
        Tn_fillByLocator("fillLocation", ("Azimpur Bus Stand"));
        return this;
    }

    @Step("click On Area Drop Down Data")
    public AddressPage clickOnAreaDropDownData() throws IOException {
        Tn_clickByLocator("areaSelect");
        return this;
    }

    @Step("fill Address On Detailed Address")
    public AddressPage fillAddressOnDetailedAddress() throws IOException {
        Tn_fillByLocator("addAddressInputAddress", ("234/B-Riven Villa"));
        return this;
    }

    public AddressPage clickOnEffectiveDelivery() throws IOException {
        Tn_clickByLocator("addAddressEffectiveDelivery", 1);
        return this;
    }

    @Step("click On Default Delivery")
    public AddressPage clickOnDefaultDelivery() throws IOException {
        Tn_clickByText("Default Delivery address");
        return this;
    }

    public AddressPage clickOnSaveButton() throws IOException {
        Tn_clickByRole("Button", "Save");
        return this;

    }

    public void getSuccessToastText() throws IOException {
        Tn_containsText("getSuccessToastText", "Address successfully added", 0);
    }
}