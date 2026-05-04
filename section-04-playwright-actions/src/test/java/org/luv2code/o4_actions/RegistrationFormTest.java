package org.luv2code.o4_actions;

import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class RegistrationFormTest extends BaseTest {
    @Test
    public void registrationFormTest() {

        // click on "Registration Form" link
        page.click("text=Registration Form");
        waitInSeconds(1);

        // check presence of "User Registration Form" heading
        highlightElement(page.locator("//h1[text()='User Registration Form']"));
        waitInSeconds(1);

        // enter full name
        page.locator("#fullName").fill("Jeeva Thakur");
        waitInSeconds(1);

        // enter password
        page.locator("#password").fill("Test1234!");
        waitInSeconds(1);

        // enter email
        page.locator("input[name='email']").fill("jeeva.thakur@example.com");
        waitInSeconds(1);

        // enter phone number
        page.locator("input[type='number']").fill("0123456789");
        waitInSeconds(1);

        // enter date of birth
        page.locator("#birthDate").pressSequentially("19/05/2025");
        waitInSeconds(1);

        // enter address
        page.locator("#address").fill("123 My Street, Himachal Pradesh, India");
        waitInSeconds(1);

        // select country from dropdown
        page.selectOption("#country", "India");
        waitInSeconds(1);

        // choose gender
        page.locator("#gender-female").click();
        waitInSeconds(1);

        // click on accepts terms
        page.locator("#terms").click();
        waitInSeconds(1);

        // click on submit button
        page.click("//button[@type='submit']");
//        page.locator("//button[@type='submit']").click(); // both will work fine
        waitInSeconds(1);

        // verify details on registration success page
        highlightElement(page.locator("//td[text()='Full Name']/../td[text()='Jeeva Thakur']"));
        waitInSeconds(4);

    }
}
