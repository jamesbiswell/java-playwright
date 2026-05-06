package org.luv2code.o7_real_time_challenges;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class XpathTest extends BaseTest {
    @Test
    public void xpathTest() {

        // navigate to our User Registration Form
        page.navigate("https://luv2test.com/#/registration-form");

        // 1. XPath By Tag Name
        page.locator("//input");

        // 2. XPath By ID
        Locator nameField = page.locator("//*[@id='fullName']");
        nameField.fill("Nitesh");

        // 3. XPath By Class Name
        page.locator("//*[contains(@class,'w-32')]");

        // 4. XPath By Attribute
        highlightElement(page.locator("//*[@type='password']"));
        
        // ^^ Using the * wildcard to match any element, which is not
        // recommended due to performance and specificity reasons.
        // Instead, use more specific selectors like
        // tag name or class name when possible.

        // 5. XPath Tag + Class
        page.locator("//input[@class='accent-blue-500']");

        // 6. XPath Tag + ID
        page.locator("//input[@id='profilePicture']");

        // 7. XPath Tag + Attribute
        page.locator("//input[@type=\"file\"]");

        // 8. XPath Multiple Attributes
        page.locator("//input[@type='radio'][@id='gender-female']");

        // 9. XPath Starts With
        page.locator("//input[starts-with(@name, 'full')]");

        // 10. XPath Ends With
        page.locator("//input[substring(@name, string-length(@name) - string-length('Name') + 1) = 'Name']");

        // 11. XPath Contains
        page.locator("//input[contains(@name, 'Num')]");

        // 12. XPath Direct Child
        page.locator("//div/h1");

        // 13. XPath Descendant
        page.locator("//div/p");

        // 14. XPath Immediate Sibling
        page.locator("//label/following-sibling::label[1]");

        // 15. XPath General Sibling
        page.locator("//button/following-sibling::div");

        // 16. XPath Not Selector
        page.locator("//button[not(@type='submit')]");

        // 17. XPath nth-child (second child)
        page.locator("//ul/li[2]");

        // 18. XPath first-child
        page.locator("//ul/li[1]");

        // 19. XPath last-child
        page.locator("//ul/li[last()]");
        waitInSeconds(2);

    }
}
