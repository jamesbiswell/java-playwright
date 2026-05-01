package org.luv2code.o3_quick_start;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class FirstPlaywrightTest {

    public static void main (String[] args) {

        // Launch Chrome browser
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setArgs(List.of("--start-maximized"))
        );

        // Create context without viewport (true maximize effect)
        Page page = browser.newContext(new Browser.NewContextOptions().setViewportSize(null)).newPage();

        // Navigate to luv2test site
        page.navigate("https://www.luv2test.com/");
        System.out.println("Home page Title: " + page.title());

        // Click on Authentication link
        page.click("text=Authentication");

        // Verify Login heading is present
        boolean isHeadingPresent = page.locator("//h2[text()='Login']").isVisible();
        System.out.println("Is Login form heading present: " + isHeadingPresent);

        // Close the browser
        browser.close();
        playwright.close();
        
    }

}
