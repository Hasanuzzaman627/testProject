package page;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class demoPage extends BasePage {
    public demoPage(Page page) {
        super(page);
    }

    public demoPage navigateTo(String url) {
        page.navigate(url);

        return this;
    }


    @Step("Select airport from {where} with code {AirportCode}")
    public demoPage selectAirport(String where,String AirportCode) throws InterruptedException {
        Tn_clickByLocator(where);
        Tn_fillByLocator(where, AirportCode);
        Tn_selectDropDownByText(AirportCode);
        return this;
    }
    @Step("click on search button")
    public demoPage clickOnSearchButton() {
        Tn_clickByLocator("flight search button");
        return this;
    }
}
