package com.telran.pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.telran.pages.BasePage;

import java.util.Collection;

public class AllProductPage extends BasePage {
    public AllProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ol[@class = 'row']/li[1]//button")
    WebElement addBookToBasketFirst;

    @FindBy(css = ".col-sm-6:nth-child(1) .btn")
    WebElement addBookToBasketLVFirst;

    @FindBy(css = ".col-sm-6:nth-child(17) .btn")
    WebElement addBookToBasketLVDown;

    @FindBy(xpath = "//ol[@class = 'row']/li[17]//button")
    WebElement addBookToBasketLast;


    @FindBy(xpath = "//a[contains(text(),'All products')]")
    WebElement selectAllProduct;

    @FindBy(id = "navbarDropdown")
    WebElement clickOnNavBtn;

    @FindBy(xpath = "//a[contains(text(),'View basket')]")
    WebElement viewBasket;

    @FindBy(xpath = "//button[contains(.,'View basket')]")
    WebElement viewBasketLV;

    @FindBy(xpath = "//div[@id= 'messages']/div[1]")
    WebElement addToBasketConfirmMsg;

    @FindBy(css = ".col-sm-6:nth-child(1) .mt-3 > a")
    WebElement firstBookTitle;

    public AllProductPage selectTheProduct() {
        click(addBookToBasketFirst);
        clickWithJSExecutor(addBookToBasketLast, 0, 500);
        return new AllProductPage(driver);
    }

    public AllProductPage addToBasket() {
        click(addBookToBasketLVFirst);
        clickWithJSExecutor(addBookToBasketLVDown, 0, 500);
        return this;
    }

    public AllProductPage selectTheProductLV() {
        click(addBookToBasketLVFirst);
        clickWithJSExecutor(addBookToBasketLVDown, 0, 500);
        return new AllProductPage(driver);
    }

    public AllProductPage clickOnTheAllProduct() {
        clickWithAction(selectAllProduct);
        return new AllProductPage(driver);
    }

    public AllProductPage clickOnTheAllProductLV() {
        click(clickOnNavBtn);
        clickWithAction(selectAllProduct);
        return new AllProductPage(driver);
    }

    public AllProductPage clickOnTheViewBasket() {
        clickWithAction(viewBasket);
        return new AllProductPage(driver);
    }

    public AllProductPage clickOnTheViewBasketLV() {
        clickWithAction(viewBasketLV);
        return new AllProductPage(driver);
    }

    public String getConfirmMessage() {
        return addToBasketConfirmMsg.getText();
    }

    public CatalogBooksPage SelectFirstBookTitle() {
        click(firstBookTitle);
        return new CatalogBooksPage(driver);
    }
}
