package page.customer;

import com.microsoft.playwright.Page;
import page.BasePage;

public class AddToCartPage extends BasePage {
    /**
     * Constructor to initialize the page object.
     *
     * @param page The Playwright Page object.
     */
    public AddToCartPage(Page page) {
        super(page);
    }

    public AddToCartPage clickOnProductBtn(){
        Tn_clickByLocator("clickOnProduct", 0);
        return this;
    }

    public AddToCartPage clickOnAddToCartBtn(){
        Tn_clickByLocator("clickOnAddToCart", 1);
        return this;
    }

    public AddToCartPage clickOnCartIcon(){
        Tn_clickByLocator("clickOnCartIcon", 0);
        return this;
    }

    public AddToCartPage selectProductFromCart(){
        Tn_clickByLocator("selectProductFromCart",0);
        return this;
    }

    public AddToCartPage clickOnCheckoutBtn(){
        Tn_clickByLocator("clickOnCheckoutButton");
        return this;
    }

}
