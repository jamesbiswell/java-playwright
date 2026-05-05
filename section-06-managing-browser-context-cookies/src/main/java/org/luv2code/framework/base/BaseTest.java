package org.luv2code.framework.base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setArgs(List.of("--start-maximized"))
        );

        // Create context without viewport (true maximize effect)
//        page = browser.newContext(new Browser.NewContextOptions().setViewportSize(null)).newPage();

        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = context.newPage();
        page.setDefaultTimeout(15000); // 15 seconds

        // Navigate to luv2test site
        page.navigate("https://www.luv2test.com/");
        System.out.println("Home page Title: " + page.title());

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
        playwright.close();

    }

}
