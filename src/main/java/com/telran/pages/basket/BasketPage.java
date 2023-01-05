package com.telran.pages.basket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.telran.pages.BasePage;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form[@class = 'basket_summary']/div[1]//h3")
    WebElement bookFirst;


    @FindBy(xpath = "//form[@class = 'basket_summary']/div[2]//h3")
    WebElement bookLast;

    @FindBy(css = ".basket-items:nth-child(6) .col-md-4 a")
    WebElement bookFirstLV;


    @FindBy(css = ".basket-items:nth-child(7) .col-md-4 a")
    WebElement bookLastLV;

    @FindBy(xpath = "//a[. = 'Proceed to checkout']")
    WebElement proceedToCheckoutBtn;

    @FindBy(id = "id_form-0-quantity")
    WebElement quantityProduct;

    @FindBy(xpath = "//button[. = 'Update']")
    WebElement updateQuantity;

    @FindBy(css = ".basket-items:nth-child(6) :nth-child(4)")
    WebElement priceForOne;

    @FindBy(css = ".basket-items:nth-child(6) :nth-child(5)")
    WebElement priceForAFew;

    @FindBy(css = ".total .price_color")
    WebElement priceTotal;


    public String getBookFirst() {

        return bookFirst.getText();
    }

    public String getBookLastLV() {

        return bookLastLV.getText();
    }

    public String getBookFirstLV() {

        return bookFirstLV.getText();
    }

    public String getBookLast() {

        return bookLast.getText();
    }

    public ShippingAddressPage proceedToCheckout() {
        click(proceedToCheckoutBtn);
        return new ShippingAddressPage(driver);
    }

    public BasketPage removeBook() {
        quantityProduct.clear();
        quantityProduct.sendKeys("0");
        updateQuantity.click();
        return this;
    }


    public double getPriseForOne() {
        double number1 = Double.parseDouble(priceForOne.getText().replace("£", ""));
        return number1;
    }

    public BasketPage enterQuantity(String qt) {
        type(quantityProduct,qt);
        click(updateQuantity);
        return  this;
    }

    public double getPriceForAFew() {
        double number2 = Double.parseDouble(priceForAFew.getText().replace("£", ""));
        return number2;
    }

    public double getPriceTotal() {
        double number3 = Double.parseDouble(priceForAFew.getText().replace("£", ""));
        return number3;
    }
}
