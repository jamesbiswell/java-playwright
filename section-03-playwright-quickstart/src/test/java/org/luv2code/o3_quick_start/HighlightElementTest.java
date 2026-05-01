package org.luv2code.o3_quick_start;

import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class HighlightElementTest extends BaseTest {

    @Test
    public void highlightElementTest() {

        highlightElement(page.locator("xpath=//h1[text()='Luv2Code Automation Practice (Web and Mobile Web)']"));
        highlightElement(page.locator("xpath=//h3[text()='Authentication']"));
        System.out.println("Success");

    }

}
