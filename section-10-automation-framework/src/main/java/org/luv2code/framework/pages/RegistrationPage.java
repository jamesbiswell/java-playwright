package org.luv2code.framework.pages;

import com.microsoft.playwright.Page;

public class RegistrationPage extends BasePage {

    public RegistrationPage(Page page) {
        super(page);
    }

    // locators
    private final String registrationFormHeading = "//h1[text()='User Registration Form']";
    private final String fullNameField = "#fullName";
    private final String passwordField = "#password";
    private final String emailField = "input[name='email']";
    private final String phoneField = "input[type='number']";
    private final String birthDateField = "#birthDate";
    private final String addressTextArea = "#address";
    private final String countryDropdown = "#country";
    private final String femaleGender = "#gender-female";
    private final String acceptTerms = "#terms";
    private final String submitButton = "//button[@type='submit']";
    private final String successNameCell = "//td[text()='Full Name']/../td[text()='Jeeva Thakur']";

    // actions
    public void verifyRegistrationFormHeading() {
        shouldBeDisplayed(registrationFormHeading);
    }

    public void enterFullName(String text) {
        type(fullNameField, text);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void enterEmail(String email) {
        type(emailField, email);
    }

    public void enterPhone(String phone) {
        type(phoneField, phone);
    }

    public void enterBirthDate(String date) {
        page.locator(birthDateField).pressSequentially(date);
    }

    public void enterAddress(String address) {
        type(addressTextArea, address);
    }

    public void selectCountry(String countryName) {
        page.selectOption(countryDropdown, countryName);
    }

    public void clickFemaleGender() {
        click(femaleGender);
    }

    public void acceptTerms() {
        click(acceptTerms);
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    public void verifyRegistrationSuccess() {
        shouldBeDisplayed(successNameCell);
    }
}
