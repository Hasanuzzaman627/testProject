package test.Customer;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import page.commonPage;
import page.customer.AddToCartPage;
import page.customer.CustomerProfileMenuPage;
import page.customer.PlaceOrderPage;
import page.customer.SearchProductPage;
import test.BaseTest;

import java.io.IOException;

import static utils.constant.customer;

public class RetailProductBuyNowTest extends BaseTest {

    @Test
    public void verifyUserCanPlaceOrderUsingBuyNowThroughCOD(ITestContext context) throws IOException, InterruptedException {

        OpenBrowserWithCredentials(customer);

        SearchProductPage searchbar = new SearchProductPage(page);
        AddToCartPage addToCartPage = new AddToCartPage(page);
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(page);
        CustomerProfileMenuPage customerProfileMenuPage = new CustomerProfileMenuPage(page);
        commonPage commonPage = new commonPage(page);

        String orderNo;

        commonPage
                .navigateTo(property("base_url"));
        searchbar
                .searchProduct("[Automation_Retail]Xbox 360 Controller")
                .clickOnSearchBtn();
        Thread.sleep(1000);
        addToCartPage
                .clickOnProductBtn();
        Thread.sleep(1000);
        placeOrderPage
                .clickOnBuyNowBtn()
                .clickOnAgreementCheckbox();
        Thread.sleep(2000);
        placeOrderPage
                .clickOnPlaceOrderBtn();
        Thread.sleep(2000);

        placeOrderPage
                .clickOnConfirmOrder()
                .getCongratulationsText();
        customerProfileMenuPage
                .clickOnMyOrders();

        orderNo = customerProfileMenuPage.getOrderNo();
        System.out.println("Order No: " + orderNo);
        context.getCurrentXmlTest().addParameter("orderNo", orderNo);
        Thread.sleep(1000);

    }
}
