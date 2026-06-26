package page;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.qameta.allure.Allure;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static page.getLocators.getLocator;

/**
 * BasePage class provides common methods for interacting with web elements using Playwright.
 */
public class BasePage {
    Page page;

    /**
     * Constructor to initialize the page object.
     *
     * @param page The Playwright Page object.
     */
    public BasePage(Page page) {

        this.page = page;
    }

    // Method to update the page reference dynamically
    public void updatePage(Page newPage) {
        this.page = newPage;
    }

    /**
     * Retrieves locator information from a given locator name.
     *
     * @param locatorName The name of the locator.
     * @return A HashMap containing locator details such as type, locator, pages, and description.
     */
    public HashMap<String, String> locatorMap(String locatorName) {
        HashMap<String, String> locatorValue = new HashMap<>();
        String type = getLocator(locatorName, "type");
        String locator = getLocator(locatorName, "locator").replace("\u00A0", " ");
        String pages = getLocator(locatorName, "page").replace("\u00A0", " ");
        String description = getLocator(locatorName, "Description").replace("\u00A0", " ");
        locatorValue.put("type", type);
        locatorValue.put("locator", locator);
        locatorValue.put("pages", pages);
        locatorValue.put("description", description);
        return locatorValue;
    }

    /**
     * Checks if the element is enabled.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     * @return True if the element is enabled, otherwise false.
     */
    public boolean Tn_isEnabled(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        return Allure.step("Checking if " + locatorName + " is enabled on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                assertThat(locator.nth(index[0])).isEnabled();
            } else {
                assertThat(locator).isEnabled();
            }
            return true;
        });
    }

    /**
     * Checks if the element is visible.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     * @return True if the element is visible, otherwise false.
     */
    public boolean Tn_isElementVisible(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        return Allure.step("Checking if " + locatorName + " is visible on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                assertThat(locator.nth(index[0])).isVisible();
            } else {
                assertThat(locator).isVisible();
            }
            return true;
        });
    }

    /**
     * Checks if the element is checked.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     * @return True if the element is checked, otherwise false.
     */
    public boolean Tn_isChecked(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        return Allure.step("Checking if " + locatorName + " is isChecked() on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                assertThat(locator.nth(index[0])).isChecked();
            } else {
                assertThat(locator).isChecked();
            }
            return true;
        });
    }

    /**
     * Checks if the element is disabled.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     * @return True if the element is disabled, otherwise false.
     */
    public boolean Tn_isDisabled(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        return Allure.step("Checking if " + locatorName + " is isDisabled() on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                assertThat(locator.nth(index[0])).isDisabled();
            } else {
                assertThat(locator).isDisabled();
            }
            return true;
        });
    }

    /**
     * Checks if the element is editable.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     * @return True if the element is editable, otherwise false.
     */
    public boolean Tn_isEditable(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        return Allure.step("Checking if " + locatorName + " is isEditable() on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                assertThat(locator.nth(index[0])).isEditable();
            } else {
                assertThat(locator).isEditable();
            }
            return true;
        });
    }

    /**
     * Checks if the element is hidden.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     * @return True if the element is hidden, otherwise false.
     */
    public boolean Tn_isHidden(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        return Allure.step("Checking if " + locatorName + " is isHidden() on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                assertThat(locator.nth(index[0])).isHidden();
            } else {
                assertThat(locator).isHidden();
            }
            return true;
        });
    }

    /**
     * Checks if the element is in the viewport.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     * @return True if the element is in the viewport, otherwise false.
     */
    public boolean Tn_isInViewport(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        return Allure.step("Checking if " + locatorName + " is isHidden() on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                assertThat(locator.nth(index[0])).isInViewport();
            } else {
                assertThat(locator).isInViewport();
            }
            return true;
        });
    }

    /**
     * Checks if the element is visible.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     * @return True if the element is visible, otherwise false.
     */
    public boolean Tn_isVisible(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        return Allure.step("Checking if " + locatorName + " is isVisible() on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                assertThat(locator.nth(index[0])).isVisible();
            } else {
                assertThat(locator).isVisible();
            }
            return true;
        });
    }

    /**
     * Checks if the element contains the specified text.
     *
     * @param locatorName The name of the locator.
     * @param text        The text to check.
     * @param index       Optional index for nth element.
     */
    public void Tn_containsText(String locatorName, String text, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Checking if " + locatorName + " contains text " + text + " on the page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                assertThat(locator.nth(index[0])).containsText(text);
            } else {
                assertThat(locator).containsText(text);
            }
        });
    }

    /**
     * Checks if the element has the specified attribute with the given value.
     *
     * @param locatorName The name of the locator.
     * @param attribute   The attribute to check.
     * @param value       The value of the attribute.
     * @param index       Optional index for nth element.
     */
    public void Tn_hasAttribute(String locatorName, String attribute, String value, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Checking if " + locatorName + " has attribute " + attribute + " with value " + value + " on the page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                assertThat(locator.nth(index[0])).hasAttribute(attribute, value);
            } else {
                assertThat(locator).hasAttribute(attribute, value);
            }
        });
    }

    /**
     * Clicks on the element located by the given locator name.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     */
    public void Tn_clickByLocator(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Click on the page " + locatorValue.get("pages") + " and performing click on " + locatorName + "(" + locatorValue.get("locator") + ")", () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                locator.nth(index[0]).click();
            } else {
                locator.click();
            }
        });
    }

    public void Tn_clickByLocatorWithText(String locatorName, String text, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);

        Allure.step("Click on the page " + locatorValue.get("pages") + " and performing click on " + locatorName +
                " with text \"" + text + "\" using locator: " + locatorValue.get("locator"), () -> {

            Page.LocatorOptions options = new Page.LocatorOptions().setHasText(text);
            Locator locator = page.locator(locatorValue.get("locator"), options);

            if (index.length > 0) {
                locator.nth(index[0]).click();
            } else {
                locator.click();
            }
        });
    }

    /**
     * Clicks on the element with the specified text.
     *
     * @param yourtext The text of the locator.
     * @param index    Optional index for nth element.
     */
    public void Tn_clickByText(String yourtext, Integer... index) {
        Allure.step("Clicking on element with text: " + yourtext, () -> {
            if (index.length > 0) {
                page.getByText(yourtext).nth(index[0]).click();
            } else {
                page.getByText(yourtext).click();
            }
        });
    }

    /**
     * Clicks on the element with the specified label.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     */
    public void Tn_clickByLabel(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Clicking on label: " + locatorValue.get("locator"), () -> {
            if (index.length > 0) {
                page.getByLabel(locatorValue.get("locator")).nth(index[0]).click();
            } else {
                page.getByLabel(locatorValue.get("locator")).click();
            }
        });
    }

    /**
     * Fills the element located by the given locator name with the specified value.
     *
     * @param locatorName The name of the locator.
     * @param value       The value to fill.
     * @param index       Optional index for nth element.
     */
    public void Tn_fillByLocator(String locatorName, String value, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Filling text in " + locatorName + "(" + locatorValue.get("locator") + ") on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                locator.nth(index[0]).fill(value);
                locator.nth(index[0]).dispatchEvent("input");
            } else {
                locator.fill(value);
                locator.dispatchEvent("input");
            }

        });
    }
    public void Tn_pressByLocator(String locatorName, String value, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Filling text in " + locatorName + "(" + locatorValue.get("locator") + ") on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                locator.nth(index[0]).press(value);
                locator.nth(index[0]).dispatchEvent("input");
            } else {
                locator.press(value);
                locator.dispatchEvent("input");
            }

        });
    }

    /**
     * Fills the element located by the given placeholder with the specified value.
     *
     * @param placeholder The placeholder text of the element.
     * @param value       The value to fill.
     * @param index       Optional index for nth element.
     */
    public void Tn_fillByPlaceholder(String placeholder, String value, Integer... index) {
        Allure.step("Filling text in element with placeholder " + placeholder, () -> {
            Locator locator = page.getByPlaceholder(placeholder);
            if (index.length > 0) {
                locator.nth(index[0]).fill(value);
                locator.nth(index[0]).dispatchEvent("input");
            } else {
                locator.fill(value);
                locator.dispatchEvent("input");
            }
        });
    }

    /**
     * Selects an option from a dropdown by label.
     *
     * @param locatorName The name of the locator.
     * @param value       The value to select.
     */
    public void Tn_selectByLabel(String locatorName, String value) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Selecting " + value + " from dropdown with label " + locatorValue.get("locator"), () -> {
            page.getByLabel(locatorValue.get("locator")).selectOption(value);
        });
    }

    /**
     * Selects multiple options from a dropdown by label.
     *
     * @param locatorName The name of the locator.
     * @param values      The values to select.
     */
    public void Tn_selectByLabelMultiple(String locatorName, String[] values) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Selecting multiple values from dropdown with label " + locatorValue.get("locator"), () -> {
            page.getByLabel(locatorValue.get("locator")).selectOption(values);
        });
    }

    /**
     * Selects Drop down options from a dropdown by text.
     *
     * @param text The name of the value.
     */
    public void Tn_selectDropDownByText(String text, Integer... index) {
        Allure.step("Selecting  " + text + " from dropdownList", () -> {
            if (index.length > 0) {
                page.getByText(text, new Page.GetByTextOptions().setExact(true)).nth(index[0]).click();
            } else {
                page.getByText(text, new Page.GetByTextOptions().setExact(true)).click();
            }
        });
    }

    public void Tn_clickEnterButton() {
        Allure.step("Clicking Enter Button", () -> {
            page.keyboard().press("Enter");
        });
    }

    public String Tn_GetAuthorizationCode() {
        List<Request> requests = new ArrayList<>();
        page.context().onRequest(request -> {
            if (request.url().endsWith("/flight/api/v1/RePrice")) {
                requests.add(request);
            }
        });
        for (Request request : requests) {
            return request.headers().get("authorization");
        }
        return null;

    }

    public void Tn_clickBylabel(String labelName, Integer... index) {

        Allure.step("Clicking on label: " + labelName, () -> {
            if (index.length > 0) {
                page.getByLabel(labelName).nth(index[0]).click();
            } else {
                page.getByLabel(labelName).click();
            }
        });
    }

    public void Tn_clickByTestId(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Click on the page " + locatorValue.get("pages") + " and performing click on " + locatorName + "(" + locatorValue.get("locator") + ")", () -> {
            Locator locator = page.locator("[data-testid='" + locatorValue.get("locator") + "']");
            if (index.length > 0) {
                locator.nth(index[0]).click();
            } else {
                locator.click();
            }
        });
    }

    public void Tn_clickByDataQAId(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Click on the page " + locatorValue.get("pages") + " and performing click on " + locatorName + "(" + locatorValue.get("locator") + ")", () -> {
            Locator locator = page.locator("[data-qa='" + locatorValue.get("locator") + "']");
            if (index.length > 0) {
                locator.nth(index[0]).click();
            } else {
                locator.click();
            }
        });
    }

    /**
     * it will return the count of the element
     *
     * @param locatorName name of The element which is multiple.
     */
    public int Tn_CountNumberOfLocator(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        int count = page.locator(locatorValue.get("locator")).count();
        Allure.step(locatorValue.get("pages") + " and " + locatorName + "(" + locatorValue.get("locator") + ")", () -> {

        });
        return count;
    }

    /**
     * Clicks on the element located by the given role and role name.
     *
     * @param role name of The element.
     * @param name set name of the role.
     */
    public void Tn_clickByRole(String role, String name, Integer... index) {
        Allure.step("Clicking on element with role: " + role + " and name: " + name, () -> {
            if (index.length > 0) {
                page.getByRole(AriaRole.valueOf(role.toUpperCase()), new Page.GetByRoleOptions().setName(name)).nth(index[0]).click();
            } else {
                page.getByRole(AriaRole.valueOf(role.toUpperCase()), new Page.GetByRoleOptions().setName(name)).click();
            }
        });
    }

    /**
     * Clicks on the element located by the given placeholder.
     *
     * @param placeholder The placeholder text of the element.
     * @param index       Optional index for nth element.
     */
    public void Tn_clickByPlaceholder(String placeholder, Integer... index) {
        Allure.step("Clicking on element with placeholder: " + placeholder, () -> {
            Locator locator = page.getByPlaceholder(placeholder);
            if (index.length > 0) {
                locator.nth(index[0]).click();
            } else {
                locator.click();
            }
        });
    }

    /**
     * Checks if the element is focused.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     * @return True if the element is focused, otherwise false.
     */
    public boolean Tn_isFocused(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        return Allure.step("Checking if " + locatorName + " is focused on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                assertThat(locator.nth(index[0])).isFocused();
            } else {
                assertThat(locator).isFocused();
            }
            return true;
        });
    }

    /**
     * Retrieves the text content of the element.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     * @return The text content of the element.
     */
    public String Tn_getText(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        return Allure.step("Getting text of " + locatorName + " on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                return locator.nth(index[0]).innerText();
            } else {
                return locator.innerText();
            }
        });
    }

    /**
     * Retrieves the value of a specified attribute of the element.
     *
     * @param locatorName The name of the locator.
     * @param attribute   The attribute to retrieve.
     * @param index       Optional index for nth element.
     * @return The value of the specified attribute.
     */
    public String Tn_getAttribute(String locatorName, String attribute, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        return Allure.step("Getting attribute " + attribute + " of " + locatorName + " on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                return locator.nth(index[0]).getAttribute(attribute);
            } else {
                return locator.getAttribute(attribute);
            }
        });
    }

    /**
     * Waits for the element to be present and visible.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     */
    public void Tn_waitForElement(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Waiting for " + locatorName + " to be visible on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                locator.nth(index[0]).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
            } else {
                locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
            }
        });
    }

    /**
     * Scrolls the page to bring the element into view.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     */
    public void Tn_scrollToElement(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Scrolling to " + locatorName + " on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                locator.nth(index[0]).scrollIntoViewIfNeeded();
            } else {
                locator.scrollIntoViewIfNeeded();
            }
        });
    }

    /**
     * Hovers over the element.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     */
    public void Tn_hoverOverElement(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Hovering over " + locatorName + " on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                locator.nth(index[0]).hover();
            } else {
                locator.hover();
            }
        });
    }

    /**
     * Double-clicks on the element.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     */
    public void Tn_doubleClick(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Double-clicking on " + locatorName + " on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                locator.nth(index[0]).dblclick();
            } else {
                locator.dblclick();
            }
        });
    }

    /**
     * Right-clicks on the element.
     *
     * @param locatorName The name of the locator.
     * @param index       Optional index for nth element.
     */
    public void Tn_rightClick(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Right-clicking on " + locatorName + " on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (index.length > 0) {
                locator.nth(index[0]).click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
            } else {
                locator.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
            }
        });
    }

    /**
     * Drags the element and drops it at a specified target.
     *
     * @param sourceLocatorName The name of the source locator.
     * @param targetLocatorName The name of the target locator.
     * @param index             Optional index for nth element.
     */
    public void Tn_dragAndDrop(String sourceLocatorName, String targetLocatorName, Integer... index) {
        HashMap<String, String> sourceLocatorValue = locatorMap(sourceLocatorName);
        HashMap<String, String> targetLocatorValue = locatorMap(targetLocatorName);
        Allure.step("Dragging " + sourceLocatorName + " and dropping it on " + targetLocatorName + " on page " + sourceLocatorValue.get("pages"), () -> {
            Locator sourceLocator = page.locator(sourceLocatorValue.get("locator"));
            Locator targetLocator = page.locator(targetLocatorValue.get("locator"));
            if (index.length > 0) {
                sourceLocator.nth(index[0]).dragTo(targetLocator);
            } else {
                sourceLocator.dragTo(targetLocator);
            }
        });
    }

    /**
     * Fills the element located by the given role with the specified value.
     *
     * @param role  The role of the element.
     * @param name  The name of the element.
     * @param value The value to fill.
     * @param index Optional index for nth element.
     */
    public void Tn_fillByRole(String role, String name, String value, Integer... index) {
        Allure.step("Filling text in element with role " + role + " and name " + name, () -> {
            Locator locator = page.getByRole(AriaRole.valueOf(role.toUpperCase()), new Page.GetByRoleOptions().setName(name));
            if (index.length > 0) {
                locator.nth(index[0]).fill(value);
                locator.nth(index[0]).dispatchEvent("input");
            } else {
                locator.fill(value);
                locator.dispatchEvent("input");
            }
        });
    }

    /**
     * Retrieves the text content of the element located by the given placeholder.
     *
     * @param locatorName The locatorName text of the element.
     * @param index       Optional index for nth element.
     * @return The text content of the element.
     */
    public String Tn_getTextByLocator(String locatorName, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        return Allure.step("Getting text of " + locatorName + " on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            String text;
            if (index.length > 0) {
                text = locator.nth(index[0]).innerText();
            } else {
                text = locator.innerText();
            }
            Allure.addAttachment("Found Text : ", text);
            return text;
        });
    }

    /**
     * Retrieves the text content of the element located by the given placeholder.
     *
     * @param placeholder The placeholder text of the element.
     * @param index       Optional index for nth element.
     * @return The text content of the element.
     */
    public String Tn_getTextByPlaceholder(String placeholder, Integer... index) {
        return Allure.step("Getting text of element with placeholder " + placeholder, () -> {
            Locator locator = page.getByPlaceholder(placeholder);
            String text;
            if (index.length > 0) {
                text = locator.nth(index[0]).innerText();
            } else {
                text = locator.innerText();
            }
            Allure.addAttachment("Found Text : ", text);
            return text;
        });
    }

    /**
     * Retrieves the text content of the element located by the given label.
     *
     * @param label The label text of the element.
     * @param index Optional index for nth element.
     * @return The text content of the element.
     */
    public String Tn_getTextByLabel(String label, Integer... index) {
        return Allure.step("Getting text of element with label " + label, () -> {
            Locator locator = page.getByLabel(label);
            String text;
            if (index.length > 0) {
                text = locator.nth(index[0]).innerText();
            } else {
                text = locator.innerText();
            }
            Allure.addAttachment("Found Text : ", text);
            return text;
        });
    }

    /**
     * Retrieves the text content of the element located by the given role and name.
     *
     * @param role  The role of the element.
     * @param name  The name of the element.
     * @param index Optional index for nth element.
     * @return The text content of the element.
     */
    public String Tn_getTextByRole(String role, String name, Integer... index) {
        return Allure.step("Getting text of element with role " + role + " and name " + name, () -> {
            Locator locator = page.getByRole(AriaRole.valueOf(role.toUpperCase()), new Page.GetByRoleOptions().setName(name));
            String text;
            if (index.length > 0) {
                text = locator.nth(index[0]).innerText();
            } else {
                text = locator.innerText();
            }
            Allure.addAttachment("Found Text : ", text);
            return text;
        });
    }

    /**
     * Retrieves the text content of the element located by the given text.
     *
     * @param text  The text of the element.
     * @param index Optional index for nth element.
     * @return The text content of the element.
     */
    public String Tn_getTextByText(String text, Integer... index) {
        return Allure.step("Getting text of element with text " + text, () -> {
            Locator locator = page.getByText(text, new Page.GetByTextOptions().setExact(true));
            String content;
            if (index.length > 0) {
                content = locator.nth(index[0]).innerText();
            } else {
                content = locator.innerText();
            }
            Allure.addAttachment("Found Text : ", content);
            return content;
        });

    }

    public void Tn_selectDropDownByTextPartialMatch(String text, Integer... index) {
        Allure.step("Selecting  " + text + " from dropdownList", () -> {
            if (index.length > 0) {
                page.getByText(text, new Page.GetByTextOptions().setExact(false)).nth(index[0]).click();
            } else {
                page.getByText(text, new Page.GetByTextOptions().setExact(false)).click();
            }
        });
    }

    public void Tn_uploadFileByLocator(String locatorName, String value, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Filling text in " + locatorName + "(" + locatorValue.get("locator") + ") on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            if (locator.getAttribute("type").equals("file")) {
                if (index.length > 0) {
                    locator.nth(index[0]).setInputFiles(Paths.get(value));
                } else {
                    locator.setInputFiles(Paths.get(value));
                }
            } else {
                if (index.length > 0) {
                    locator.nth(index[0]).fill(value);
                    locator.nth(index[0]).dispatchEvent("input");
                } else {
                    locator.fill(value);
                    locator.dispatchEvent("input");
                }
            }
        });
    }

    public void Tn_waitForVisibility(String locatorName, int timeoutMs, Integer... index) {
        HashMap<String, String> locatorValue = locatorMap(locatorName);
        Allure.step("Waiting for visibility of " + locatorName + " (" + locatorValue.get("locator") + ") on page " + locatorValue.get("pages"), () -> {
            Locator locator = page.locator(locatorValue.get("locator"));
            Locator.WaitForOptions options = new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(timeoutMs);

            if (index.length > 0) {
                locator.nth(index[0]).waitFor(options);
            } else {
                locator.first().waitFor(options);
            }
        });
    }

    public void Tn_waitForURL(String expectedUrl) {
        Allure.step("Waiting for URL to be: " + expectedUrl, () -> {
            page.waitForURL(expectedUrl);
        });
    }
}
