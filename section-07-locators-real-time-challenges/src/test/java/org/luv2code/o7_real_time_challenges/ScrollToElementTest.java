package org.luv2code.o7_real_time_challenges;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class ScrollToElementTest extends BaseTest {
    @Test
    public void scrollToElementTest() {

        // locate about link
        Locator aboutLink = page.locator("//h3[text()='About']");
        highlightElement(aboutLink);
        waitInSeconds(2);

        // scroll to element
        aboutLink.scrollIntoViewIfNeeded();
        waitInSeconds(2);

        // click on about link
        aboutLink.click();
        waitInSeconds(2);

        Locator aboutHeading = page.locator("//h1[text()='Luv2Code Team and Automation Practice Site']");
        waitInSeconds(1);

        // scroll to heading
        aboutHeading.scrollIntoViewIfNeeded();
        highlightElement(aboutHeading);
        waitInSeconds(2);

    }
}
