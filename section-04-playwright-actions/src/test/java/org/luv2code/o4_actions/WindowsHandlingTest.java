package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class WindowsHandlingTest extends BaseTest {
    @Test
    public void windowsHandlingTest() {

        // navigate to tabs-windows page
        page.navigate("https://www.luv2test.com/#/tabs-windows");

        // store the current page (original window)
        Page originalPage = page;
        System.out.println("Original windows URL: " + originalPage.url());

        // click on 'Open Home Page (New Window) button'
        Locator newWindowButton = page.locator("//button[@data-test=\"open-home-window\"]");

        // wait for new page (Window) to open
        Page newWindow = context.waitForPage(() -> {
            newWindowButton.click();
        });
        newWindow.waitForLoadState();

        // verify new window title and heading
        System.out.println("Title of new window: " + newWindow.title());
        Locator heading = newWindow.locator("//h1[text()='Luv2Code Automation Practice (Web and Mobile Web)']");
        highlightElement(heading);
        waitInSeconds(2);

        // switch back to original window
        originalPage.bringToFront();
        waitInSeconds(2);

        // click on check-all button
        originalPage.locator("//button[@data-test=\"check-all-button\"]").click();
        waitInSeconds(2);

    }
}
