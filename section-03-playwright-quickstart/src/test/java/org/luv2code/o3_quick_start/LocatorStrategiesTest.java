package org.luv2code.o3_quick_start;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class LocatorStrategiesTest extends BaseTest {

    @Test
    public void locatorStrategiesTest() {

        page.navigate("https://www.luv2test.com/#/registration-form");

        // locate by Role-based
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Full Name"));

        // locate by app test IDs
        page.getByTestId("password");

        // locate by Label & Placeholder
        page.getByLabel("Address");
//        page.getByPlaceholder("placeholder");

        // locate by Text locator
        page.getByText("Email:");
//        page.getByAltText("King image");

        // locate by Title locator
        page.getByTitle("Luv2Code Automation");

        // locate by CSS Selector
        page.locator("input[type='Number']");

        // locate by XPath
        page.locator("xpath=//input[@id='gender-female']");
        
        // locate by Nth locator (index based)
        page.locator("input[type='radio']").nth(1);

    }

}
