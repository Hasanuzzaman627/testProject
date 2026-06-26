package page.customer;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.testng.Assert;
import page.BasePage;

import java.io.IOException;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.apache.batik.anim.timing.Trace.print;

public class SearchProductPage extends BasePage {

    public SearchProductPage(Page page) {
        super(page);
    }

    @Step("Search Product")
    public SearchProductPage searchProduct(String productName) throws IOException {
        Tn_fillByLocator("CustomerSearchProduct", productName);
        return this;
    }

    @Step("Click on Search Button")
    public SearchProductPage clickOnSearchBtn() throws InterruptedException {
        Tn_clickByRole("button", "Search",1);
        return this;
    }

    @Step("Wait for Url")
    public SearchProductPage waitForUrl(String url) throws InterruptedException {
        Tn_waitForURL(url);
        return this;
    }

    @Step("Verify Search Result")
    public void verifySearchResults(String productName) throws InterruptedException {

        Tn_containsText("CustomerSearchResults", productName, 0);

        for (int i = 1; i < 5; i++) {
            String text = Tn_getTextByLocator("CustomerSearchResults", i);
            Assert.assertTrue(text.toLowerCase().contains("mobile".toLowerCase()) ||
                            text.toLowerCase().contains("technonext".toLowerCase()) ||
                            text.toLowerCase().contains("automatic".toLowerCase()),
                    "Text does not contains any of those" +" "+ text );
        }
    }
}
