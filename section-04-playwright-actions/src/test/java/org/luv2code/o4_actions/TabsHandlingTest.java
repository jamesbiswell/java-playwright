package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class TabsHandlingTest extends BaseTest {
    @Test
    public void tabsHandlingTest() {
        page.navigate("https://www.luv2test.com/#/tabs-windows");
        // store original page or tab
        Page originalPage = page;
        System.out.println("Original Tab URL: " + originalPage.url());

        // click on "Open Home Page (New Tab)"
        Locator newTabButton = page.locator("//button[@data-test=\"open-home-tab\"]");
        highlightElement(newTabButton);
        waitInSeconds(2);

        // wait for new tab to open and get the page object
        
        //lambda expression
        Page newTab = context.waitForPage(() -> {
            newTabButton.click();
        });
        
        //method reference equivalent
        // Page newTab = context.waitForPage(newTabButton::click);
        
        // ensure new tab is fully loaded
        newTab.waitForLoadState();

        // we are in the new tab
        System.out.println("Title of new tab: " + newTab.title());

        // Verify heading in the new tab
        Locator heading = newTab.locator("//h1[text()='Luv2Code Automation Practice (Web and Mobile Web)']");
        highlightElement(heading);
        waitInSeconds(2);

        // switch back to original tab
        originalPage.bringToFront();
        System.out.println("Back to original tab: " + originalPage.title());

        // continue working on original page/tab
        originalPage.locator("//button[@data-test=\"check-all-button\"]").click();
        waitInSeconds(2);

    }
}
