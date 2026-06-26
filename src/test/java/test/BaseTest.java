package test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import factory.BrowserFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.testng.ITestResult;
import org.testng.annotations.*;
import page.BasePage;

import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

import static helpers.download.Locators;
import static utils.constant.apiConfigFilePath;
import static utils.constant.configFilePath;

public class BaseTest {

    private final BrowserFactory browserFactory = new BrowserFactory();
    public Page page;
    private String browserName = "chrome";
    private String headless = "false";
    protected BrowserContext context;
    protected BasePage basePage;

    @BeforeTest
    public static void setUpAll() throws IOException, InterruptedException, GeneralSecurityException {
        Locators();
    }

    @BeforeMethod
    @Parameters({"browserName", "headless"})
    public void setUp(@Optional("chrome") String browserName, @Optional("false") String headless) throws IOException {
        this.browserName = browserName;
        this.headless = headless;
    }

    public void OpenBrowserWithCredentials(String storageStatePath) throws IOException {
        Path authStatePath = Paths.get(storageStatePath);
        boolean useStoredState = Files.exists(authStatePath);

        Browser browser = browserFactory.initializeBrowser(browserName, headless);  // 👉 Just get the Browser

        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("videos/"))
                .setIgnoreHTTPSErrors(true);

        if (property("proxy").equals("true")) {
            contextOptions.setProxy(property("proxy_url"));
        }

        if (useStoredState && !storageStatePath.isEmpty()) {
            contextOptions.setStorageStatePath(authStatePath);
        }

        context = browser.newContext(contextOptions);  // 👉 Now create only one context
        page = context.newPage();                      // 👉 And only one page
        page.setDefaultTimeout(30000);
        basePage = new BasePage(page);
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String formattedDateTime = formatter.format(currentDateTime);

        String resultName = result.getName() + "_chrome_" + formattedDateTime;
        Path screenshotPath = Paths.get("./target/screenshots/" + resultName + ".png");

        page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));
        attachScreenshotToAllureReport(resultName, screenshotPath);

        Path videoPath = null;
        if (page.video() != null) {
            videoPath = page.video().path();
            System.out.println("Video path: " + videoPath);
            attachVideo(resultName, videoPath);
        }
        context.close();
        page.context().browser().close();
    }

    @Attachment(value = "Test Recording", type = "video/webm", fileExtension = ".webm")
    public void attachVideo(String resultName, Path screenshotPath) throws IOException {
        Allure.addAttachment(resultName, new ByteArrayInputStream(Files.readAllBytes(screenshotPath)));
    }

    @Attachment(type = "image/png")
    private void attachScreenshotToAllureReport(String resultName, Path screenshotPath) throws IOException {
        Allure.addAttachment(resultName, new ByteArrayInputStream(Files.readAllBytes(screenshotPath)));
    }

    public static String property(String value) throws IOException {
        FileReader reader = new FileReader(configFilePath);
        Properties prop = new Properties();
        prop.load(reader);
        return prop.getProperty(value);
    }

    public static String apiProperty(String value) throws IOException {
        FileReader reader = new FileReader(apiConfigFilePath);
        Properties prop = new Properties();
        prop.load(reader);
        return prop.getProperty(value);
    }

    protected void switchToLatestPage() {
        List<Page> pages = context.pages();
        Page newPage = pages.get(pages.size() - 1);
        this.page = newPage;
        basePage.updatePage(newPage);
        System.out.println("✅ Switched to latest page: " + newPage.url());
    }

    public Page switchToNewPage(int pageNumber) {
        List<Page> pages = context.pages();
        Page newPage = null;
        if (pageNumber < pages.size()) {
            newPage = pages.get(pageNumber);
            this.page = newPage;
            basePage.updatePage(newPage);
            System.out.println("✅ Switched to new page: " + newPage.url());
        } else {
            System.out.println("⚠️ Invalid page number. Total open pages: " + pages.size());
        }
        return newPage;
    }

    public String getRequestHeaderAuthorization() throws IOException, InterruptedException {
        AtomicReference<String> authorizationToken = new AtomicReference<>();
        page.onRequest(request -> {
            System.out.println("Request URL: " + request.url());
            request.headers().forEach((key, value) -> {
                if (key.toLowerCase().contains("authorization")) {
                    System.out.println(key + ": " + value);
                    authorizationToken.set(value);
                }
            });
        });
        return authorizationToken.get();
    }

    public String getResponseByRequestUrl(String ApiEndPoint) throws IOException, InterruptedException {
        AtomicReference<String> response = new AtomicReference<>();
        page.onRequestFinished(request -> {
            if (request.url().contains(ApiEndPoint)) {
                String responseBody = request.response().text();
                response.set(responseBody);
            }
        });
        return response.get();
    }
}