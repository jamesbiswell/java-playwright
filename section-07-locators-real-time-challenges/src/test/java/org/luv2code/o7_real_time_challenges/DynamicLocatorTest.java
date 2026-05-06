package org.luv2code.o7_real_time_challenges;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class DynamicLocatorTest extends BaseTest {
    @Test
    public void dynamicLocatorTest() {

        // navigate to 'dynamic elements' page
        page.navigate("https://www.luv2test.com/#/dynamic-elements");

        // locate dynamic id button
//        Locator dynamicIdButton = page.locator("#btn_9uriakte");
        Locator dynamicIdButton = page.locator("//button[contains(@id,'btn_')]");
        highlightElement(dynamicIdButton);
        
        // fails intentionally to show that native click should be used - see NativeClickTest
        // <div class="opacity-0 absolute" aria-hidden="true" data-test="invisible-element">This element is always present but invisible</div>
        // <div class="space-y-2">
        // <button id="btn_hksmvd7o" class="px-4 py-2 bg-green-600 text-white rounded hover:bg-green-700"
        // data-test="dynamic-id-button">Dynamic ID Button</button>
        // <p class="text-sm text-gray-500 dark:text-gray-400">Button ID: <code>btn_hksmvd7o</code></p>
        // </div>
        
        dynamicIdButton.click();

        // verify dynamic content
        Locator dynamicContent = page.locator("//div[contains(text(),'Dynamic button clicked successfully!')]");
        System.out.println("Dynamic button clicked: " + dynamicContent.isHidden());

    }
}
