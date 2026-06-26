package page.component;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

public class ReturnButtonPackageReceiveComponent {
    private final Page page;

    public ReturnButtonPackageReceiveComponent(Page page) {
        this.page = page;
    }

    public void selectReturnCode(String returnOrderCode) {
        Locator allReturnOrderGrid = page.locator(".p-selectable-row");

        allReturnOrderGrid.first().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED));

        int count = allReturnOrderGrid.count();
        System.out.println("Total return order grid: " + count);

        for (int i = 0; i < count; i++) {
            Locator block = allReturnOrderGrid.nth(i);
            Locator orderSpan = block.getByRole(AriaRole.CELL, new Locator.GetByRoleOptions().setName(returnOrderCode));

            if (orderSpan.count() > 0) {
                Locator returnBtn = block.locator(".p-checkbox-box.p-component").nth(0);
                if (returnBtn.isVisible()) {
                    returnBtn.click();
                    //System.out.println("Clicked return for order: " + orderId);
                } else {
                    System.out.println("Return button not visible for order: " + returnOrderCode);
                }
                return;
            }
        }
        //System.out.println("Order not found: #" + orderId);
    }
}
