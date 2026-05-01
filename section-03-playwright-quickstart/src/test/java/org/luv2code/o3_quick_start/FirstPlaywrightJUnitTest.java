package org.luv2code.o3_quick_start;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FirstPlaywrightJUnitTest {

    Playwright playwright;
    Page page;
    Browser browser;

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
        page = browser.newContext(new Browser.NewContextOptions().setViewportSize(null)).newPage();

        // Navigate to luv2test site
        page.navigate("https://www.luv2test.com/");
        System.out.println("Home page Title: " + page.title());

    }

    @Test
    public void firstPlaywrightJUnitTest() {

        // Click on Authentication link
        page.click("text=Authentication");

        // Verify Login heading is present
        boolean isHeadingPresent = page.locator("//h2[text()='Login']").isVisible();
        System.out.println("Is Login form heading present: " + isHeadingPresent);

    }

    @AfterEach
    public void tearDown() {

        // Close the browser
        browser.close();
        playwright.close();

    }

}
