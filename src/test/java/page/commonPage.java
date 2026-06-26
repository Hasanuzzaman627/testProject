package page;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class commonPage extends BasePage {
    /**
     * Constructor to initialize the page object.
     *
     * @param page The Playwright Page object.
     */
    public commonPage(Page page) {
        super(page);
    }

    public commonPage navigateTo(String url) {
        page.navigate(url);
        return this;
    }

    public commonPage maximizeWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        page.setViewportSize(width, height);
        return this;
    }

    }