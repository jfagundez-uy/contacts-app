package org.automation.UI.pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MainContactsPage {

    @FindBy(xpath = "//button[@id='add-contact']")
    private WebElement addContactButton;

    @FindBy(xpath = "//tr[@class=\"contactTableBodyRow\"]/td[4]")
    private WebElement contactRowEmail;
}
