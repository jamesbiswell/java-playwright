package org.luv2code.o3_quick_start;

import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class FinalTest extends BaseTest {

    @Test
    public void runFinalTest() {

        // Click on Authentication link
        page.click("text=Authentication");

        // Verify Login heading is present
        boolean isHeadingPresent = page.locator("//h2[text()='Login']").isVisible();
        System.out.println("Is Login form heading present: " + isHeadingPresent);

    }

}
