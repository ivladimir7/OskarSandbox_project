package com.telran.pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.telran.pages.BasePage;

public class AllProductPage extends BasePage {
    public AllProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ol[@class = 'row']/li[1]//button")
    WebElement addBookToBasketFirst;

    @FindBy(xpath = "//ol[@class = 'row']/li[17]//button")
    WebElement addBookToBasketLast;

    @FindBy(xpath = "//a[contains(text(),'All products')]")
    WebElement selectAllProduct;

    @FindBy(xpath = "//a[contains(text(),'View basket')]")
    WebElement viewBasket;

    public AllProductPage selectTheProduct() {
        click(addBookToBasketFirst);
        clickWithJSExecutor(addBookToBasketLast,0,500);
        return new AllProductPage(driver);
    }

    public AllProductPage clickOnTheAllProduct() {
        clickWithAction(selectAllProduct);
        return new AllProductPage(driver);
    }

    public AllProductPage clickOnTheViewBasket(){
        clickWithAction(viewBasket);
        return new AllProductPage(driver);
    }
}
