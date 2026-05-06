package org.luv2code.o8_advance_features;

import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class DebuggingToolsTest extends BaseTest {
    @Test
    public void debuggingToolsTest() {

        // click on "Registration Form" link
        page.click("text=Registration Form");
        
        // pause the test execution and open Playwright Inspector
        // Playwright Inspector is a browser extension that allows you to debug Playwright scripts
        page.pause();

        // check presence of "User Registration Form" heading
        highlightElement(page.locator("//h1[text()='User Registration Form']"));
        

        // enter full name
        page.locator("#fullName").fill("Jeeva Thakur");
        

        // enter password
        page.locator("#password").fill("Test1234!");
        

        // enter email
        page.locator("input[name='email']").fill("jeeva.thakur@example.com");
        

        // enter phone number
        page.locator("input[type='number']").fill("0123456789");
        

        // enter date of birth
        page.locator("#birthDate").pressSequentially("19/05/2025");
        

        // enter address
        page.locator("#address").fill("123 My Street, Himachal Pradesh, India");
        

        // select country from dropdown
        page.selectOption("#country", "India");
        

        // choose gender
        page.locator("#gender-female").click();
        

        // click on accepts terms
        page.locator("#terms").click();
        

        // click on submit button
        page.click("//button[@type='submit']");
//        page.locator("//button[@type='submit']").click(); // both will work fine
        

        // verify details on registration success page
        highlightElement(page.locator("//td[text()='Full Name']/../td[text()='Jeeva Thakur']"));

    }
}
