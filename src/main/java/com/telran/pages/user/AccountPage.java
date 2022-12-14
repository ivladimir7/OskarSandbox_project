package com.telran.pages.user;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(css = ".alertinner.wicon")
    WebElement confirmationMsg;

    @FindBy(xpath = "//a[contains(text(),'Order History')]")
    WebElement OrderHistory;



    public String getConfirmMessage() {

        return confirmationMsg.getText();
    }

    public String getUserName() {

        return userName.getText();
    }


    public AccountPage inputUserName(String Name, String lastName) {
        click(editProfileBtn);
        type(firstNameField, Name);
        type(lastNameField, lastName);
        click(saveBtn);
        return this;
    }

    public void clickOnOrderHistory() {

        clickWithAction(OrderHistory);
    }
    public AccountPage verifyUserName(String EMAIL) {
        if (emailNameValue.getText().equalsIgnoreCase(EMAIL)) {
            System.out.println("Correct user name: " + emailNameValue.getText());
        } else {
            System.out.println("Incorrect user name: " + emailNameValue.getText());
        }
        return this;
    }
}

