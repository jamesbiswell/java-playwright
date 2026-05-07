package org.luv2code.framework.base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.luv2code.framework.constants.TestDataConstant;
import org.luv2code.framework.utils.ConfigUtil;
import org.luv2code.framework.utils.WaitTimeUtil;

import java.nio.file.Paths;
import java.util.List;

public class BaseTest {

    public Playwright playwright;
    public Page page;
    public Browser browser;
    public BrowserContext context;

    @BeforeEach
    public void setUp() {

        // Launch Chrome browser
        playwright = Playwright.create();
        if(ConfigUtil.getProperty("browser").equalsIgnoreCase("firefox")){
            browser = playwright.firefox().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setArgs(List.of("--start-maximized"))
            );
        } else {
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
//                        .setSlowMo(1000)
                            .setArgs(List.of("--start-maximized"))
            );
        }

        // Create context without viewport (true maximize effect)
//        page = browser.newContext(new Browser.NewContextOptions().setViewportSize(null)).newPage();

        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null)
                .setRecordVideoDir(Paths.get("target/videos"))
                .setRecordVideoSize(1280, 720)
        );
        page = context.newPage();
        page.setDefaultTimeout(WaitTimeUtil.MEDIUM_15.getMillis()); // 15 seconds

        // Navigate to luv2test site
        page.navigate(TestDataConstant.BASE_URL);
        System.out.println("Home Page Title: " + page.title());

    }

    // method to highlight element
    public static void highlightElement(Locator locator) {

        ElementHandle handle = locator.elementHandle();
        if(handle != null) {
            locator.page().evaluate("e => {" +
                    "e.style.border='3px solid green'; " +
                    "e.style.backgroundColor='yellow'; }", handle);
        }

    }

    // wait in seconds method
    public void waitInSeconds(long seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        browser.close();
        context.close();
        playwright.close();
    }

}
