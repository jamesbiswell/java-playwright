package org.luv2code.o8_advance_features;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;
import org.junit.jupiter.api.Test;

public class GeolocationAndDeviceTest {
    @Test
    public void geolocationAndDeviceTest() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        // set geolocation
        Geolocation geolocation = new Geolocation(37.7749, -122.4194);

        // create browser context with device emulation, geolocation
        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(390, 844)
                        .setDeviceScaleFactor(3)
                        .setIsMobile(true)
                        .setGeolocation(geolocation)
        );

        Page page = context.newPage();

        // navigate to luv2test site
        page.navigate("https://www.luv2test.com/");
        page.locator("//h3[text()='Authentication']").click();

        System.out.println("Login for heading: "
                + page.locator("//h2[text()='Login']").isVisible());

        page.waitForTimeout(3000);

    }
}
