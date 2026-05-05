package org.luv2code.o5_wait_mechanisms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.Position;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class ExplicitWaitTest extends BaseTest {
    @Test
    public void explicitWaitTest() {

        // navigate to dynamic element page
        page.navigate("https://www.luv2test.com/#/dynamic-elements");

        // locate the dynamic tip and highlight the same
        Locator dynamicLocator =
                page.locator("//li[text()='Tip: Use keyboard shortcuts to improve productivity']");
        highlightElement(dynamicLocator);
        waitInSeconds(2);

        // slider element
        Locator slider = page.locator("//input[@data-test=\"load-time-slider\"]");
        slider.click(new Locator.ClickOptions()
                .setPosition(new Position(
                        (slider.boundingBox().width) * 0.5,
                        slider.boundingBox().height / 2
                )));

        // explicit wait in playwright
        Locator didYouKnow = page.locator("//li[text()='Did you know? You can undo closed tabs with Ctrl+Shift+T']");
        didYouKnow.waitFor(new Locator.WaitForOptions().setTimeout(20000));
        highlightElement(didYouKnow);
        waitInSeconds(2);

        // wait for selector
        page.waitForSelector("//li[text()='Did you know? You can undo closed tabs with Ctrl+Shift+T']",
                new Page.WaitForSelectorOptions().setTimeout(20000));

        highlightElement(didYouKnow);
        waitInSeconds(2);
        
    }
}
