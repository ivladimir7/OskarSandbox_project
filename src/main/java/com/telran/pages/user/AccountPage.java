package com.telran.pages.user;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//tbody/tr[2]/td[1]")
    WebElement emailNameValue;

    @FindBy(xpath = "//*[.='Edit profile']")
    WebElement editProfileBtn;

    @FindBy(id = "id_first_name")
    WebElement firstNameField;

    @FindBy(id = "id_last_name")
    WebElement lastNameField;

    @FindBy(xpath = "//button[.='Save']")
    WebElement saveBtn;

    @FindBy(xpath = "//td[contains(text(), 'Adam Noi')]")
    WebElement userName;

    @FindBy(xpath = "//li[@class = 'nav-item'][3]")
    WebElement addressBookLink;

    @FindBy(css = ".alertinner.wicon")
    WebElement confirmationMsg;

    @FindBy(xpath = "//a[contains(text(),'Order History')]")
    WebElement orderHistory;

    @FindBy(id = "delete_profile")
    WebElement deleteProfile;

    @FindBy(xpath = "//input[@id='id_password']")
    WebElement fieldPassword;

    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    WebElement deleteConfirm;

    @FindBy(css = ".btn.btn-primary")
    WebElement addNewAddressBtn;


    @FindBy(css = ".alertinner.wicon")
    WebElement confirmationMessage;

    @FindBy(id = "id_line1")
    WebElement addressField;

    @FindBy(id = "id_line4")
    WebElement cityField;

    @FindBy(id = "id_postcode")
    WebElement postCodeField;

    @FindBy(id = "id_country")
    WebElement countryName;

    @FindBy(xpath = "//*[contains(text(),'Oops! We found some errors')]")
    WebElement errorMsg;


    @FindBy(xpath = "//div[@class = 'btn-group']/a")
    WebElement editBtn;


    public String getConfirmMessage() {

        return confirmationMsg.getText();
    }

    public String getUserName() {

        return userName.getText();
    }
    public AccountPage clickOnAddressBookLink() {
        click(addressBookLink);
        return this;
    }

    public AccountPage inputUserName(String Name, String lastName) {
        click(editProfileBtn);
        type(firstNameField, Name);
        type(lastNameField, lastName);
        click(saveBtn);
        return this;
    }

    public AccountPage DeleteNewUser() {
        click(deleteProfile);
        return this;
    }

    public AccountPage fillInPasswordField(String password) {
        type(fieldPassword, password);
        return this;
    }

    public AccountPage ClickOnConfirmDelete() {
        click(deleteConfirm);
        return this;
    }

    public AccountPage deleteRegisterUser(String password) {
        DeleteNewUser();
        fillInPasswordField(password);
        ClickOnConfirmDelete();
        return this;

    }

    public void clickOnOrderHistory() {

        clickWithAction(orderHistory);
    }

    public AccountPage AddressFormFillWithValidData(String firstName, String lastName,
                                                    String firstLineOfAddress, String city, String postCode) {
        click(addNewAddressBtn);
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(addressField, firstLineOfAddress);
        type(cityField, city);
        typeWithJSExecutor(postCodeField, postCode, 600, 0);
        return this;
    }

    public boolean isConfirmMessagePresent() {
        try {
            return confirmationMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public AccountPage verifyUserName(String EMAIL) {
        if (emailNameValue.getText().equalsIgnoreCase(EMAIL)) {
            System.out.println("Correct user name: " + emailNameValue.getText());
        } else {
            System.out.println("Incorrect user name: " + emailNameValue.getText());
        }
        return this;
    }

    public AccountPage editAllRequiredFields(String editFirstName, String editLastName,
                                             String editFirstLineOfAddress, String editCity,
                                             String editPostCode) {
        type(firstNameField, editFirstName);
        type(lastNameField, editLastName);
        type(addressField, editFirstLineOfAddress);
        type(cityField, editCity);
        typeWithJSExecutor(postCodeField, editPostCode, 600, 0);
        return this;
    }

    public AccountPage clickOnSaveBtn() {
        click(saveBtn);
        return this;
    }

    public AccountPage selectCountry(String text) {
        clickWithJSExecutor(countryName, 500, 0);
        Select select = new Select(countryName);
        select.selectByVisibleText(text);
        return this;
    }

    public String isConfirmMessageText() {
        return confirmationMessage.getText();
    }


    public AccountPage clickOnEditBtn() {
        click(editBtn);
        return this;
    }

    public boolean isErrorMessagePresent() {
        return errorMsg.isDisplayed();
    }
}


