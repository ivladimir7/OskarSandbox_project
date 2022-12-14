package com.telran.pages.basket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.telran.pages.BasePage;

public class OrderHistoryPage extends BasePage {
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath= "//input[@id='id_order_number']")
    WebElement orderNumber;

    @FindBy(xpath= "//button[contains(text(),'Filter results')]")
    WebElement filterResults;

    @FindBy(xpath = "//h1[contains(text(),'')]")
    WebElement OrderAssertNumber;

    public OrderHistoryPage OrderNumberFind(String text) {
        type(orderNumber,text);
        return this;
    }
    public void clickOnTheFilterResults(){
        click(filterResults);
    }

    public String OrderAssertNumber() {
        return  OrderAssertNumber.getText();

    }

}
