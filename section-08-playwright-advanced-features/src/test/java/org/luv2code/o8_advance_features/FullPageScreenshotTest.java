package org.luv2code.o8_advance_features;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FullPageScreenshotTest extends BaseTest {
    @Test
    public void fullPageScreenshotTest() {

        // full page screenshot
        Path screenshotPath = Paths.get("target/fullPageScreenshot/homepage.png");

        page.screenshot(new Page.ScreenshotOptions()
                .setPath(screenshotPath)
                .setFullPage(true)
        );

        // print confirmation
        System.out.println("Screenshot saved at: " + screenshotPath.toAbsolutePath());

    }
}
