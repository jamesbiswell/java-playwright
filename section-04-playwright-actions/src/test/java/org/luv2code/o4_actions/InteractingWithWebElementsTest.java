package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class InteractingWithWebElementsTest extends BaseTest {
    @Test
    public void interactingWithWebElementsTest() {
        // click on 'Registration form' link
        page.locator("[data-test='nav-registration-form']").click();

        // verify page heading
        page.locator("//h1[text()='User Registration Form']").isVisible();

        waitInSeconds(1);

        // send full name to "Full Name" text field
        page.locator("#fullName").fill("Jeeva Thakur");

        // send password to "Password" field
        Locator passwordField = page.locator("[name='password']");
        passwordField.fill("Jee");

        waitInSeconds(1);

        // submit the Registration form
        passwordField.press("Enter");

        waitInSeconds(2);

        // clear the "Password" field
        passwordField.clear();

        // send valid password to "Password" field
        passwordField.type("password!");

        // submit the Registration form
        passwordField.press("Enter");

        waitInSeconds(2);

        System.out.println("Success");
    }
}
