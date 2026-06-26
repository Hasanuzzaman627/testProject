package factory;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Proxy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static test.BaseTest.property;

public class BrowserFactory {
    private Playwright playwright;
    private Browser browser;
    private Properties properties;

    public Browser initializeBrowser(String browserName, String headless) throws IllegalArgumentException, IOException {
        boolean isHeadless = Boolean.parseBoolean(headless);
        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                if (property("proxy").equals("true")) {
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                            .setHeadless(isHeadless)
                            .setSlowMo(Double.parseDouble(property("slow_mo")))
                            .setProxy(new Proxy(property("proxy_url"))));
                } else {
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                            .setHeadless(isHeadless)
                            .setSlowMo(Double.parseDouble(property("slow_mo"))));
                }
                break;
            case "chrome":
                if (property("proxy").equals("true")) {
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                            .setChannel("chrome")
                            .setHeadless(isHeadless)
                            .setSlowMo(Double.parseDouble(property("slow_mo")))
                            .setProxy(new Proxy(property("proxy_url"))));
                } else {
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                            .setChannel("chrome")
                            .setHeadless(isHeadless)
                            .setSlowMo(Double.parseDouble(property("slow_mo"))));
                }
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));
                break;
            default:
                throw new IllegalArgumentException("Please provide a valid browser name (chrome, firefox, webkit or chromium).");
        }

        return browser;
    }

    public Properties initializeConfigProperties() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String configUrl = classLoader.getResource("config/config.properties").getPath();
            FileInputStream fileInputStream = new FileInputStream(configUrl);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
