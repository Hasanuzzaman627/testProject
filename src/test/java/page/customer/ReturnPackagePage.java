package page.customer;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import page.BasePage;
import page.component.ReturnButtonForOrderComponent;

import java.io.IOException;

public class ReturnPackagePage extends BasePage {

    private final ReturnButtonForOrderComponent returnButtonComponent;

    public ReturnPackagePage(Page page) {
        super(page);
        this.returnButtonComponent = new ReturnButtonForOrderComponent(page);
    }

    @Step("Click on the profile button")
    public ReturnPackagePage clickProfileButton() throws IOException {
        Tn_clickByLocator("clickOnProfileName", 0);
        return this;
    }

    @Step("Click on the Initiate Return tab")
    public ReturnPackagePage clickOnInitiateReturnTab() throws InterruptedException {
        Tn_clickByRole("button", "Initiate Return");
        return this;
    }

    @Step("Click on Track Return Tab")
    public ReturnPackagePage clickOnTrackReturnTab() throws InterruptedException {
        Tn_clickByRole("button", "Track Return");
        return this;
    }

    @Step("Click on the Return Reason dropdown and choose reason")
    public ReturnPackagePage clickOnReturnReasonDropdown() throws InterruptedException {
        Thread.sleep(2000);
        Tn_clickByLocator("clickReturnReasonDropdown",2);
        Tn_clickByLocator("selectReasonFromReturnDropDown",1);
        return this;
    }

    @Step("Click on the Return button for order {orderId}")
    public ReturnPackagePage clickOnReturnButton(String orderId) throws InterruptedException {
        returnButtonComponent.clickReturnButtonForOrder(orderId);
        return this;
    }

    @Step("Fill the 'Description' field")
    public ReturnPackagePage fillDescriptionField() throws InterruptedException {
        Tn_fillByPlaceholder("Description", "Automation Test");
        return this;
    }

    @Step("Upload a picture")
    public ReturnPackagePage uploadPicture() throws InterruptedException {
        Tn_uploadFileByLocator("uploadReturnReasonFile", "src/test/java/test/TestData/TestImage.png");
        return this;
    }

    @Step("Click on the 'Submit' button on the return request")
    public ReturnPackagePage clickOnSubmitButtOnReturnRequest() throws InterruptedException {
        Tn_clickByRole("button", "Submit");
        return this;
    }

    @Step("Click on the 'All Returns' tab")
    public ReturnPackagePage clickOnAllReturnTab() throws InterruptedException {
        Tn_clickByRole("button", "All Return");
        Thread.sleep(2000);
        return this;
    }

    @Step("Extract CR Code")
    public String extractCRCode() throws InterruptedException {
        String customerReturnCode = Tn_getAttribute("extractCrCode", "data-pr-tooltip",0 );
        System.out.println(customerReturnCode);
        return customerReturnCode;
    }
}
