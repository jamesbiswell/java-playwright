package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class ShadowDomHandlingTest extends BaseTest {
    @Test
    public void shadowDomHandlingTest() {

        // navigate to shadow dom page
        page.navigate("https://www.luv2test.com/#/shadow-dom");

        // click on "Click Me!" button inside shadow dom
        Locator clickMeButton = page.locator("div[data-test=\"shadow-host\"]")
                .locator("button.shadow-button");
        clickMeButton.click();
        System.out.println(clickMeButton.textContent() + " :: Clicked Successfully");

        // ACCESS NESTED shadow DOM
        var nestedShadowTitle = page.locator("div[data-test=\"shadow-host\"]")
                .locator("#nested-shadow-host")
                .locator(".nested-content > h3");

//        highlightElement(nestedShadowTitle);
        nestedShadowTitle.highlight();

        // handle iframe inside nested shadow dom
        var iframe = page.locator("div[data-test=\"shadow-host\"]")
                .locator("#nested-shadow-host")
                .locator("#nested-iframe");

        highlightElement(iframe);

        // switch into iframe using frame locator
        var iframeShadowHost = page.frameLocator("div[data-test='shadow-host'] #nested-shadow-host #nested-iframe")
                .locator("#iframe-shadow-host");
        iframeShadowHost.highlight();

        // shadow dom inside iframe -> click dark mode toggle button
        page.frameLocator("div[data-test='shadow-host'] #nested-shadow-host #nested-iframe")
                .locator("#iframe-shadow-host")
                .locator("#dark-mode-toggle")
                .click();

        // regular dom
        highlightElement(page.locator("//h3[text()='Regular DOM Content']"));

        System.out.println("SUCCESS");

    }
}
