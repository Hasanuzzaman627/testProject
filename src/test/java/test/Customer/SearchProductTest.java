package test.Customer;

import org.testng.annotations.Test;
import page.commonPage;
import page.customer.SearchProductPage;
import test.BaseTest;

import java.io.IOException;

import static utils.constant.customer;

public class SearchProductTest extends BaseTest {

    @Test
    public void verifyUserCanSearchProduct() throws InterruptedException, IOException {

        OpenBrowserWithCredentials(customer);

        SearchProductPage searchbar = new SearchProductPage(page);
        commonPage commonPage = new commonPage(page);
        commonPage
                .maximizeWindow() // Maximize window here if desired
                .navigateTo(property("base_url") + " ");

        searchbar
                .searchProduct("Mobile for TechnoNext automation")
                .clickOnSearchBtn()
                .verifySearchResults("Mobile for TechnoNext automation");
    }
}
