package test.Customer;

import org.testng.annotations.Test;
import page.commonPage;
import page.customer.AddressPage;
import page.customer.ReviewPage;
import test.BaseTest;

import java.io.IOException;

import static utils.constant.customer;

public class ReviewTest extends BaseTest {

    @Test
    public void verifyToReviewSubmit() throws IOException, InterruptedException {

        OpenBrowserWithCredentials(customer);

        ReviewPage reviewSubmitPage = new ReviewPage(page);
        commonPage commonPage = new commonPage(page);
        AddressPage addressPage = new AddressPage(page);

        commonPage
                .maximizeWindow() // Maximize window here if desired
                .navigateTo(property("base_url"));

        addressPage
                .profile();

        reviewSubmitPage
                .clickOnMyOrders()
                .clickOnReviewButton()
                .writeShortReview()
                .clickOnUploadPhoto()
                .writeSellerReview()
                .writeDeliveryReview()
                .clickOnSubmitButton();


    }
}