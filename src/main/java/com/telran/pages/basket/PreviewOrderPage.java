package com.telran.pages.basket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreviewOrderPage extends BasketPage {
    public PreviewOrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "place-order")
    WebElement placeOrder;

    public OrderConfirmationPage clickOnPlaceOrderButton() {
        clickWithJSExecutor(placeOrder, 500, 0);
        return new OrderConfirmationPage(driver);
    }
}
