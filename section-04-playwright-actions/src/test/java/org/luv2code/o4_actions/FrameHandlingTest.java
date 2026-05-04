package org.luv2code.o4_actions;

import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class FrameHandlingTest extends BaseTest {
    @Test
    public void framesHandlingTest() {

        // navigate to iFrames page
        page.navigate("https://www.luv2test.com/#/iframes");

        // locate input field and fill name (Note this will fail because text field is inside iframe)
//        page.locator("#input-name").fill("Chad Darby");

        // locate input fields under "Single Iframe" and perform fill operations
        var iframe1 = page.frameLocator("#iframe1");
        iframe1.locator("#input-name").fill("Chad Darby");
        iframe1.locator("#input-password").fill("Password@123");

        // SWITCH TO IFRAME 2 then inner iframe
        var iframe2 = page.frameLocator("#iframe2");
        iframe2.frameLocator("iframe").locator("#inner-input-name").fill("Nitesh Bhardwaj");
        iframe2.frameLocator("iframe").locator("#inner-input-password").fill("Pass@321");

        // get text from parent iframe (outer frame)
        String outerFrameDescription = iframe2.locator(
                "//p[text()='This iframe contains a nested inner iframe.']")
                .innerText();
        System.out.println("Outer frame description: " + outerFrameDescription);

        // back to main page
        String pageDescription = page.locator(
                        "//p[contains(text(),'Practice working with iframes,')]")
                .innerText();
        System.out.println("Page description: " + pageDescription);

        System.out.println("SUCCESS");

    }
}
