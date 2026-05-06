package org.luv2code.o7_real_time_challenges;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class CssSelectorTest extends BaseTest {
    @Test
    public void cssSelectorTest() {

        // navigate to our User Registration Form
        page.navigate("https://luv2test.com/#/registration-form");

        // 1. Css Selector by Tag Name
        Locator allInputTags = page.locator("input");
        highlightElement(allInputTags.first());

//        int total = allInputTags.count();
//        for (int i = 0; i < total; i++) {
//            Locator single = allInputTags.nth(i);
//            highlightElement(single);
//        }

        // 2. Css Selector By ID
        Locator fullNameTextField = page.locator("#fullName");
        highlightElement(fullNameTextField);

        // 3. Css Selector By Class Name
        Locator allLabels = page.locator(".w-32.text-right.font-medium");
        highlightElement(allLabels.first());

        // 4. Css Selector By Attributes
        Locator passwordField = page.locator("[type='password']");
        highlightElement(passwordField);

        // 5. Css Selector Tag + Class
        Locator acceptTermsCheckbox = page.locator("input.accent-blue-500");
        highlightElement(acceptTermsCheckbox);

        // 6. Css Selector Tag + ID
        Locator chooseFileField = page.locator("input#profilePicture");
        highlightElement(chooseFileField);

        // 7. Css Selector Tag + Attribute
        Locator chooseFileField2 = page.locator("input[type='file']");
        highlightElement(chooseFileField2);

        // 8. Css Selector Multiple Attributes
        Locator maleGenderRadioButton = page.locator("input[type='radio'][id='gender-male']");
        highlightElement(maleGenderRadioButton);

        // 9. Css Selector Starts With (^)
        Locator fullNameTextField2 = page.locator("input[name^='full']");
        highlightElement(fullNameTextField2);

        // 10. Css Selector Ends With ($)
        Locator fullNameTextField3 = page.locator("input[name$='Name']");
        highlightElement(fullNameTextField3);

        // 11. Css Selector Contains (*)
        Locator phoneNumberTextField = page.locator("input[name*='Num']");
        highlightElement(phoneNumberTextField);

        // 12. Css Selector Direct Child (>)
        Locator pageHeading = page.locator("div > h1");
        highlightElement(pageHeading);

        // 13. Css Selector Descendant (space)
        Locator pageDescription = page.locator("div p");
        highlightElement(pageDescription);

        // 14. Css Selector Immediate sibling (+)
        Locator femaleGenderRadioButton = page.locator("label + label");
        highlightElement(femaleGenderRadioButton);

        // 15. Css Selector General Sibling (~)
        Locator generalSibling = page.locator("button ~ div").first();
        highlightElement(generalSibling);

        // 16. Css Selector Not selector
        Locator notSubmitButton = page.locator("button:not([type='submit'])").first();
        highlightElement(notSubmitButton);

        // 17. Css Selector nth-child
        Locator nthChildSideNavLinks = page.locator("ul li:nth-child(2)").first();
        highlightElement(nthChildSideNavLinks);

        // 18. Css Selector first-child
        Locator firstChildSideNavLinks = page.locator("ul li:first-child").first();
        highlightElement(firstChildSideNavLinks);

        // 19. Css Selector last-child
        Locator lastChildSideNavLinks = page.locator("ul li:last-child").first();
        highlightElement(lastChildSideNavLinks);
        waitInSeconds(3);

    }
}
