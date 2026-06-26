package API_Automation.Test;

import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected Playwright playwright;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
    }

    @AfterClass
    public void tearDown() {
        if (playwright != null) playwright.close();
    }
}
