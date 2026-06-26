package page.component;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class ReturnButtonForOrderComponent {
    private final Page page;

    public ReturnButtonForOrderComponent(Page page) {
        this.page = page;
    }

    public void clickReturnButtonForOrder(String orderId) {
        Locator allOrderBlocks = page.locator(".w-full.rounded-none.border.border-borderColor");

        allOrderBlocks.first().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED));

        int count = allOrderBlocks.count();
        System.out.println("Total order blocks: " + count);

        for (int i = 0; i < count; i++) {
            Locator block = allOrderBlocks.nth(i);
            Locator orderSpan = block.locator("span", new Locator.LocatorOptions().setHasText("#" + orderId));

            if (orderSpan.count() > 0) {
                Locator returnBtn = block.locator("a:has-text('Return')").nth(0);
                if (returnBtn.isVisible()) {
                    returnBtn.click();
                    //System.out.println("Clicked return for order: " + orderId);
                } else {
                    System.out.println("Return button not visible for order: " + orderId);
                }
                return;
            }
        }
        //System.out.println("Order not found: #" + orderId);
    }
}
