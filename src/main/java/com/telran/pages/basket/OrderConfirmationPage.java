package com.telran.pages.basket;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage {
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = " //h1[contains(text(),' ')]")
    WebElement OrderNumber;

    public String  OrderNumber() {
        return  OrderNumber.getText();
    }
}
