package org.luv2code.o5_wait_machanisms;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class AutoWaitTest extends BaseTest {
    @Test
    public void autoWaitTest() {

        // open dynamic element page
        page.navigate("https://www.luv2test.com/#/dynamic-elements");

        // Set Timeout (page-level)
        page.setDefaultTimeout(2000); // 2 seconds

        // set navigation timeout
        page.setDefaultNavigationTimeout(3000); // 3 seconds

        // playwright automatically waits for elements to appear, be visible and stable
        Locator dynamicLocator =
                page.locator("//li[text()='Tip: Use keyboard shortcuts to improve productivity']");
        highlightElement(dynamicLocator);
        waitInSeconds(2);

        // auto-wait ensures these calls wait until element is ready
        System.out.println(dynamicLocator.isVisible());
        System.out.println(dynamicLocator.textContent());

    }
}
