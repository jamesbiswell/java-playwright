package org.luv2code.o10_framework_tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.luv2code.framework.base.BaseTest;
import org.luv2code.framework.extensions.LoggingExtension;
import org.luv2code.framework.pages.HomePage;
import org.luv2code.framework.pages.RegistrationPage;

@ExtendWith(LoggingExtension.class)
public class RegistrationTest extends BaseTest {
    @Test
    public void registrationFormTest() {

        HomePage homePage = new HomePage(page);
        RegistrationPage registrationPage = new RegistrationPage(page);

        // click on "Registration Form" link
        homePage.clickRegistrationLink();

        // check presence of "User Registration Form" heading
        registrationPage.verifyRegistrationFormHeading();
        waitInSeconds(3);

        // enter full name
        registrationPage.enterFullName("Jeeva Thakur");

        // enter password
        registrationPage.enterPassword("Test1234!");

        // enter email
        registrationPage.enterEmail("jeeva.thakur@example.com");

        // enter phone number
        registrationPage.enterPhone("0123456789");

        // enter date of birth
        registrationPage.enterBirthDate("19/05/2025");

        // enter address
        registrationPage.enterAddress("123 My Street, Himachal Pradesh, India");

        // select country from dropdown
        registrationPage.selectCountry("India");

        // choose gender
        registrationPage.clickFemaleGender();

        // click on accepts terms
        registrationPage.acceptTerms();

        // click on submit button
        registrationPage.clickSubmitButton();

        // verify details on registration success page
        registrationPage.verifyRegistrationSuccess();
        waitInSeconds(3);

    }
}
