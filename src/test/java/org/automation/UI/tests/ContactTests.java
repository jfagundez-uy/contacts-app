package org.automation.UI.tests;

import org.automation.API.ContactService;
import org.automation.API.Utils;
import org.automation.UI.pageObjects.LoginPage;
import org.automation.UI.pageObjects.MainContactsPage;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.PageFactory;

public class ContactTests extends PageBase {

    private String contactId;
    Utils utils = new Utils();

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws InterruptedException {
        JSONObject user = utils.readPayloadFromJson("credentials.json");
        String username = user.getString("email");
        String password = user.getString("password");

        ContactService.login(username, password);
        contactId = ContactService.createContact("contactData.json", ContactService.getBearerToken());
        setUpDriver();

        LoginPage loginPage = PageFactory.initElements(getDriver(), LoginPage.class);
        loginPage.login(username, password);
        driver.get("https://thinking-tester-contact-list.herokuapp.com/contactList");

    }

    @Test(description = "Create contact test", groups = "Smoke")
    public void createContactTest() throws InterruptedException {
        MainContactsPage mainContactsPage = PageFactory.initElements(getDriver(), MainContactsPage.class);
        waitForPageElement(mainContactsPage.getContactRowEmail(), 2);
        String contactEmail = mainContactsPage.getContactRowEmail().getText();
        JSONObject contact = utils.readPayloadFromJson("contactData.json");

        Assert.assertEquals(contact.getString("email"), contactEmail, "The contact email does not match!");
    }

    @Test(description = "Update contact test", groups = "Smoke")
    public void updateContactTest() throws InterruptedException {
        ContactService.updateContact("updatedContact.json", ContactService.getBearerToken(), contactId);
        getDriver().navigate().refresh();
        MainContactsPage mainContactsPage = PageFactory.initElements(getDriver(), MainContactsPage.class);
        waitForPageElement(mainContactsPage.getContactRowEmail(), 2);
        JSONObject contact = utils.readPayloadFromJson("updatedContact.json");

        Assert.assertEquals(contact.getString("email"), mainContactsPage.getContactRowEmail().getText(), "The contact email was not updated correctly!");
    }

    @Test(description = "Delete contact test", groups = "Smoke")
    public void deleteContactTest() throws InterruptedException {
        ContactService.deleteContact(ContactService.getBearerToken(), contactId);
        getDriver().navigate().refresh();
        MainContactsPage mainContactsPage = PageFactory.initElements(getDriver(), MainContactsPage.class);

        Assert.assertFalse(isElementPresent(mainContactsPage.getContactRowEmail()), "The contact was not deleted!");
        Assert.assertEquals(ContactService.getContact(ContactService.getBearerToken(), contactId).getStatusCode(), 404, "The contact still exists in API!");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        if (contactId != null) {
            ContactService.deleteContact(ContactService.getBearerToken(), contactId);
        }

        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
