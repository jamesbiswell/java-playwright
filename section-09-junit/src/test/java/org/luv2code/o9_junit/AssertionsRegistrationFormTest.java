package org.luv2code.o9_junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class AssertionsRegistrationFormTest extends BaseTest {
    @Test
    public void assertionsRegistrationFormTest() {

        String expectedName = "John Doe";
        String expectedEmail = "John.Doe@example.com";
        String expectedPhone = "0987654321";

        // click on "Registration Form" link
        page.click("text=Registration Form");
        

        // check presence of "User Registration Form" heading
        highlightElement(page.locator("//h1[text()='User Registration Form']"));
        

        // enter full name
        page.locator("#fullName").fill(expectedName);
        

        // enter password
        page.locator("#password").fill("Test1234!");
        

        // enter email
        page.locator("input[name='email']").fill(expectedEmail);
        

        // enter phone number
        page.locator("input[type='number']").fill(expectedPhone);
        

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


        // verify details on registration success page
        page.locator("//td[text()='Full Name']/../td[text()='John Doe']");

        // validate registration success page using Assertions
        String actualName = page.locator("//td[text()='Full Name']/../td[2]").innerText();
        Assertions.assertEquals(expectedName, actualName);
        String actualEmail = page.locator("//td[text()='Email']/../td[2]").innerText();
        Assertions.assertEquals(expectedEmail, actualEmail);
        String actualPhone = page.locator("//td[text()='Phone']/../td[2]").innerText();
        Assertions.assertEquals(expectedPhone, actualPhone);

        waitInSeconds(3);
        
    }
}
