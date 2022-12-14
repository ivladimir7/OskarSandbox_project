package com.telran.pages.basket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.telran.pages.BasePage;

public class ShippingAddressPage extends BasePage {
    public ShippingAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_first_name")
    WebElement firstNameField;

    @FindBy(id = "id_last_name")
    WebElement lastNameField;

    @FindBy(id = "id_line1")
    WebElement addressField;

    @FindBy(id = "id_line4")
    WebElement cityField;

    @FindBy(id = "id_postcode")
    WebElement zipCodeField;

    @FindBy(xpath = "//*[.='Continue']")
    WebElement continueBtn;

    @FindBy(id = "id_country")
    WebElement countryName;

    @FindBy(xpath = "//*[.='Continue']")
    WebElement continueButton;

    public ShippingAddressPage NewAddressFormField(String firstName, String lastName,
                                                   String address, String city, String zipCode) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(addressField, address);
        type(cityField, city);
        type(zipCodeField, zipCode);
        clickWithJSExecutor(continueBtn, 500, 0);
        return this;
    }


    public ShippingAddressPage selectCountry(String text) {
        clickWithJSExecutor(countryName, 500, 0);
        Select select = new Select(countryName);
        countryName.sendKeys(text);

        return this;
    }

    public ShippingAddressPage clickOnContinueButton() {

        clickWithJSExecutor(continueButton, 500, 0);
        return this;
    }
}



