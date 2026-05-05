package org.luv2code.o6_options_cookies_browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class SafariLaunchTest {
    @Test
    public void safariLaunchTest() {

        // launch safari/webkit
        Playwright playwright = Playwright.create();
        Browser browser = playwright.webkit()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.luv2test.com/#/");

        // wait for heading to appear
        page.waitForSelector("h1");
        System.out.println("Page Title: " + page.title());

        page.waitForTimeout(3000);

        page.close();
        browser.close();
        playwright.close();

    }
}
