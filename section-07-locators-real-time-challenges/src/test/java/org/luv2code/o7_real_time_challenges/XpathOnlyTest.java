package org.luv2code.o7_real_time_challenges;

import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class XpathOnlyTest extends BaseTest {
    @Test
    public void xpathOnlyTest() {

        // navigate to Registration Form page
        page.navigate("https://www.luv2test.com/#/registration-form");

        // 1. Navigate Up the DOM (Parent Axis)
        page.locator("//input[@id='fullName']/parent::div/../label");

        // 2. Navigate to Ancestors (grandparents, etc.)
        page.locator("//input[@id='fullName']/ancestor::form");

        // 3. Select Based on Text Content
        page.locator("//button[text()='Submit']");
        page.locator("//button[contains(text(),'Sub')]");
        page.locator("//button[contains(.,'Sub')]");

        // 4. Complex Logical Conditions (and, or)
        page.locator("//input[@type='radio' and @id='gender-male']");
        page.locator("//input[@type='radio' or @id='gender-male']");

        // 5. Position-Based Indexing
        highlightElement(page.locator("(//input[@type='radio'])[2]"));

        // 6. Advanced Functions (substring, normalize-space)
        page.locator("//input[substring(@name, string-length(@name) - string-length('Name') + 1) = 'Name']");
        page.locator("//label[normalize-space(text()='Full Name:')]");

        // 7. Axes Navigation preceding-sibling, following, descendant, self ...
        page.locator("//label[preceding-sibling::label]");
        page.locator("//input[@id='email']/following::button[1]");
        page.locator("//input[ancestor::form]");
        page.locator("//input[ancestor-or-self::form]");
        page.locator("//input[parent::div]");
        page.locator("//form[child::div]");
        page.locator("//label[following-sibling::label]");
        page.locator("//label/following::input");
        page.locator("//input/preceding::label");
        page.locator("//input/self::input");
        waitInSeconds(3);

    }
}
