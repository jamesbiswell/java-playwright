package org.luv2code.o7_real_time_challenges;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.PlaywrightException;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class RetryLogicTest extends BaseTest {
    @Test
    public void retryLogicTest() {

        // locate Authentication link
        Locator authenticationLink = page.locator("//h3[text()='Authentication']");

        // refresh the page
        page.reload();

        // playwright locator is live, so this works directly without retry
        authenticationLink.click();

        // retry logic (rarely needed in playwright)
        int attempts = 0;
        while (attempts < 3) {
            try {
                authenticationLink.click();
                break; // success
            } catch (PlaywrightException exc) {
                System.out.println("Playwright exception caught. Retrying... " + (attempts + 1));
                // relocate the element if needed
                authenticationLink = page.locator("//h3[text()='Authentication']");
            }
            attempts++;
        }

        if (attempts == 3) {
            System.out.println("failed to click after retries");
        }

        waitInSeconds(2);

    }
}
