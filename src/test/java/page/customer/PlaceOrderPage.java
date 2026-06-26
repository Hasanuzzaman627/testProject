package page.customer;

import com.microsoft.playwright.Page;
import page.BasePage;

public class PlaceOrderPage extends BasePage {
    /**
     * Constructor to initialize the page object.
     *
     * @param page The Playwright Page object.
     */
    public PlaceOrderPage(Page page) {
        super(page);
    }

    public PlaceOrderPage clickOnBuyNowBtn() {
        Tn_clickByLocator("clickOnBuyNowButton", 0);
        return this;
    }

    public PlaceOrderPage selectCustomerDeliveryAddress(int address) {
        Tn_clickByLocator("customerDeliveryAddressSelect", address);
        return this;
    }

    public PlaceOrderPage clickOnAgreementCheckbox() {
        Tn_clickByLocator("clickOnAgreementCheckbox");
        return this;
    }

    public PlaceOrderPage clickOnPlaceOrderBtn() {
        Tn_clickByLabel("clickOnPlaceOrderButton");
        return this;
    }

    public PlaceOrderPage clickOnCodBtn() {
        Tn_clickByLocatorWithText("clickOnCodButton", "Cash on Delivery");
        return this;
    }

    public PlaceOrderPage clickOnConfirmOrder() {
        Tn_clickByLabel("clickOnConfirmOrderButton");
        return this;
    }

    public PlaceOrderPage getCongratulationsText() {
        Tn_containsText("getCongratulationsText", "Order Confirmation Call Alert!", 0);
        return this;
    }
}
