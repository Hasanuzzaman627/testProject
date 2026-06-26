package test.Customer;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import page.commonPage;
import page.customer.*;
import test.BaseTest;

import java.io.IOException;

import static utils.constant.customer;

public class PlaceOrderTest extends BaseTest {

    @Test
    public void verifyUserCanAddToCartProductAndPlaceOrder(ITestContext context) throws IOException, InterruptedException {

        OpenBrowserWithCredentials(customer);

        SearchProductPage searchbar = new SearchProductPage(page);
        AddToCartPage addToCartPage = new AddToCartPage(page);
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(page);
        CustomerProfileMenuPage customerProfileMenuPage = new CustomerProfileMenuPage(page);
        commonPage commonPage = new commonPage(page);

        String orderNo;

        commonPage
                .maximizeWindow() // Maximize window here if desired
                .navigateTo(property("base_url"));

        searchbar
                .searchProduct("Mobile for TechnoNext automation")
                .clickOnSearchBtn()
                .waitForUrl("**/search?keyword=Mobile+for+TechnoNext+automation**");

        addToCartPage
                .clickOnProductBtn()
                .clickOnAddToCartBtn()
                .clickOnCartIcon()
                .selectProductFromCart()
                .clickOnCheckoutBtn();
Thread.sleep(2000);
        placeOrderPage
                .clickOnPlaceOrderBtn()
                .clickOnCodBtn()
                .clickOnConfirmOrder()
                .getCongratulationsText();
        Thread.sleep(3000);

        customerProfileMenuPage
                .clickOnProfileName();
        Thread.sleep(3000);
        customerProfileMenuPage
                .clickOnMyOrders();

        orderNo= customerProfileMenuPage.getOrderNo();
        System.out.println("Order No: "+orderNo);
        context.getCurrentXmlTest().addParameter("orderNo", orderNo);
//        String getOrderNo= context.getCurrentXmlTest().getParameter("orderNo");

    }

    @Test
    public void verifyUserCanPlaceOrderThroughBuyNowBtn(ITestContext context) throws IOException, InterruptedException {

        OpenBrowserWithCredentials(customer);

        SearchProductPage searchbar = new SearchProductPage(page);
        AddToCartPage addToCartPage = new AddToCartPage(page);
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(page);
        CustomerProfileMenuPage customerProfileMenuPage = new CustomerProfileMenuPage(page);
        commonPage commonPage = new commonPage(page);

        String orderNo;

        commonPage
                .maximizeWindow() // Maximize window here if desired
                .navigateTo(property("base_url"));

        searchbar
                .searchProduct("Mobile for TechnoNext automation")
                .clickOnSearchBtn();
        Thread.sleep(1000);
        addToCartPage
                .clickOnProductBtn();
        placeOrderPage
                .clickOnBuyNowBtn();
                //.clickOnAgreementCheckbox();
        Thread.sleep(3000);
        placeOrderPage
                .clickOnPlaceOrderBtn()
                .clickOnCodBtn()
                .clickOnConfirmOrder()
                .getCongratulationsText();
        Thread.sleep(3000);
        customerProfileMenuPage
                .clickOnProfileName();
        Thread.sleep(3000);
        customerProfileMenuPage
                .clickOnMyOrders();

        orderNo= customerProfileMenuPage.getOrderNo();
        System.out.println("Order No: "+orderNo);
        context.getCurrentXmlTest().addParameter("orderNo", orderNo);
//        String getOrderNo= context.getCurrentXmlTest().getParameter("orderNo");

    }
}
