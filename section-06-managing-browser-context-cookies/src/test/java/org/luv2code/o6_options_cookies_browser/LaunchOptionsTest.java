package org.luv2code.o6_options_cookies_browser;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LaunchOptionsTest {
    @Test
    public void launchOptionTest() {

        // set up the playwright
        Playwright playwright = Playwright.create();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(false).setArgs(Arrays.asList(new String[]{
                "--start-maximized",            // maximized browser window
                "--ignore-certificate-errors",  // accept bad SSL
                "--allow-insecure-localhost",   // allow localhost SSL issues
                "--headless=new",               // for headless
                "--window-size=1024,1366",      // launch browser in fix size
                "--disable-extensions",         // disable extensions
                "--disable-popup-blocking",     // disable popups
                "--disable-notification",       // disable notifications
        }));

        Browser browser = playwright.chromium().launch(launchOptions);

        // create context (acts like incognito if you want isolated session)
        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(null)          // reliable maximize
                        .setIgnoreHTTPSErrors(true)     // same as --ignore-certificate-errors
        );

        Page page = context.newPage();
        page.waitForTimeout(2000);
        page.navigate("https://expired.badssl.com/");
        page.waitForTimeout(3000);

        page.navigate("https://www.luv2test.com/#/");
        page.waitForTimeout(3000);

    }
}
