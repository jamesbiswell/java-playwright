package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.MouseButton;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class MouseActionsBasicTest extends BaseTest {
    @Test
    public void mouseActionsBasicTest() {

        // navigate to ab-testing page
        page.navigate("https://www.luv2test.com/#/ab-testing");

        // move to element -> Toggle Theme
        Locator toggleThemeButton = page.locator("//button[@aria-label=\"Toggle theme\"]");
        toggleThemeButton.hover();

        // basic click()
        toggleThemeButton.click();
        waitInSeconds(2);

        // click on specific element
        page.locator("#variant-button-a").click();
        waitInSeconds(2);

        // perform double click
        Locator variantB = page.locator("#variant-button-b");
        variantB.dblclick();
        waitInSeconds(2);

        // click and hold, then release
        variantB.hover();
        page.mouse().down(); // click and hold
        page.mouse().up(); // release
        waitInSeconds(2);

        // navigate to context menu page
        page.navigate("https://www.luv2test.com/#/context-menu");
        waitInSeconds(2);

        // move to "Practice Image Upload" element
        Locator imageUploadOption = page.locator("//li[text()='Practice Image Upload']");
        imageUploadOption.hover();

        // right click / context click
        imageUploadOption.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
        waitInSeconds(2);

        // click on "context menu edit" button
        page.locator("//button[@data-test=\"context-menu-edit\"]").click();
        waitInSeconds(2);

    }
}
