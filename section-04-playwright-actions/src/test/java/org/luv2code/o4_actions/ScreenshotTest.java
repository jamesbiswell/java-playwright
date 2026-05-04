package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

import java.nio.file.Paths;

public class ScreenshotTest extends BaseTest {
    @Test
    public void screenshotTest() {

        // take home page screenshot
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("target/screenshots/homepage.png")));

        // element screenshot
        Locator mainHeading = page.locator("//h1[text()='Luv2Code Automation Practice (Web and Mobile Web)']");
        mainHeading.screenshot(new Locator.ScreenshotOptions()
                .setPath(Paths.get("target/screenshots/mainHeading.png")));

        System.out.println("Screenshot saved at: target/screenshots location");

    }
}
