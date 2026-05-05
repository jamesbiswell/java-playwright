package org.luv2code.o6_options_cookies_browser;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.Cookie;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CookiesTest {
    @Test
    public void cookiesTest() {

        // open first browser & get cookies
        Playwright playwright = Playwright.create();
        BrowserContext context1 = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext();

        Page page1 = context1.newPage();
        page1.navigate("https://www.luv2test.com/#/");

        // click on toggle theme button
        page1.waitForTimeout(2000);
        page1.click("button[data-test=\"theme-toggle\"]");
        page1.waitForTimeout(2000);

        // get all cookies from context
        List<Cookie> cookies = context1.cookies();
        for(Cookie cookie : cookies) {
            System.out.println("Saved cookies: " + cookie.name + " = " + cookie.value);
        }
        for(Cookie cookie : cookies) {
            System.out.println("Domain: " + cookie.domain);
            System.out.println("Path: " + cookie.path);
            System.out.println("HTTPOnly: " + cookie.httpOnly);
            System.out.println("Secure: " + cookie.secure);
        }

        // close the context
        context1.close();

        // open new browser and reuse cookies
        BrowserContext context2 = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext();

        Page page2 = context2.newPage();
        page2.navigate("https://www.luv2test.com/#/");

        // add cookies to new session
        context2.addCookies(cookies);
        page2.waitForTimeout(2000);

        // refresh the page to apply cookies
        page2.reload();
        System.out.println("Cookies restored in new session");
        page2.waitForTimeout(2000);

        // delete cookies
        context2.clearCookies(
                new BrowserContext.ClearCookiesOptions()
                        .setName("theme")
                        .setDomain("www.luv2test.com")
                        .setPath("/")
        );

        context2.clearCookies(); // to delete all cookies
        page2.waitForTimeout(2000);
        page2.reload();
        page2.waitForTimeout(2000);
        System.out.println("Cookies Deleted!!!");

        context2.close();

    }
}
