package org.automation.UI.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;


    public void login(String email, String password) throws InterruptedException {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
    }
}
