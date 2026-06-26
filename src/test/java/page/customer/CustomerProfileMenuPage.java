package page.customer;

import com.microsoft.playwright.Page;
import page.BasePage;
import java.io.IOException;

import static page.enums.CustomerProfileMenuEnum.*;
public class CustomerProfileMenuPage extends BasePage {
    /**
     * Constructor to initialize the page object.
     *
     * @param page The Playwright Page object.
     */
    public CustomerProfileMenuPage(Page page) {
        super(page);
    }

    static int totalItems;

    public CustomerProfileMenuPage clickOnProfileName() throws IOException {
        Tn_clickByLocator("clickOnProfileName", 0);
        return this;
    }

    public CustomerProfileMenuPage clickOnMyOrders() throws InterruptedException{
        totalItems = Tn_CountNumberOfLocator("customerProfileMenu");

        for (int i = 0; i < totalItems; i++) {
            String text = Tn_getTextByLocator("customerProfileMenu", i);
            if (text.contains(MY_ORDERS)) {
                Tn_clickByLocator("customerProfileMenu", i);
                break;
            }
        }
        return this;
    }

    public CustomerProfileMenuPage clickCustomerMenu(String menuName) throws InterruptedException{
        Tn_clickByRole("link",menuName);
        return this;
    }

    public String getOrderNo(){
            String orderNo=Tn_getText("orderNoCopy", 0);
            String orderNoWithoutHash = (orderNo.length() > 1) ? orderNo.substring(1) : "";
            return orderNoWithoutHash;
    }

}
