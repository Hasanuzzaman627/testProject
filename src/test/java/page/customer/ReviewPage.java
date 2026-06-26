package page.customer;

import com.microsoft.playwright.Page;
import page.BasePage;

import java.io.IOException;

public class ReviewPage extends BasePage {

    /**
     * Constructor to initialize the page object.
     *
     * @param page The Playwright Page object.
     */


    public ReviewPage(Page page)
    {
        super(page);
    }

    public ReviewPage clickOnMyOrders() throws IOException {
        Tn_clickByText("My Reviews", 0);
        return this;
    }

    public ReviewPage clickOnReviewButton() throws IOException {
        Tn_clickByLocator("clickOnReviewBtn",0);
        return this;
    }

    public ReviewPage writeShortReview() throws IOException
    {
        Tn_fillByLocator("writeShortReview" ,("Nice Product"));
        return this;
    }

    public ReviewPage clickOnUploadPhoto() throws IOException
    {
        Tn_uploadFileByLocator("uploadReviewPhoto", "src/test/java/test/TestData/TestImage.png");
        return this;
    }

    public ReviewPage writeSellerReview() throws IOException
    {
        Tn_fillByLocator("writeSellerReview" ,("Seller behaviour is quite good."));
        return this;
    }

    public ReviewPage writeDeliveryReview() throws IOException
    {
        Tn_fillByLocator("writeDeliveryReview" ,("Product is good."));
        return this;
    }

    public ReviewPage clickOnSubmitButton() throws IOException {
        Tn_clickByRole("Button", "Submit");
        return this;

    }


}
