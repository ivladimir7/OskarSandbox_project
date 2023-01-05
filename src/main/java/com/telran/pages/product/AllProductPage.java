package com.telran.pages.product;

import com.telran.pages.basket.BasketPage;
import com.telran.pages.user.LoginAndRegistrationPage;
import org.openqa.selenium.By;
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

    @FindBy(id = "login_link")
    WebElement loginLink;

    @FindBy(css = "li > a[href*=fiction_3]")
    WebElement fictionLink;

    @FindBy(css = "li > a[href*=clothing_1]")
    WebElement clothingLink;

    @FindBy(css = "li > a[href*=non-fiction_5]")
    WebElement nonfictionLink;

    @FindBy(css = "a[href*=computers-in-literature]")
    WebElement compInLitLink;

    @FindBy(css = "a[href*=essential-programming]")
    WebElement programmingLink;

    @FindBy(css = "a[href*=hacking]")
    WebElement hackingLink;

    @FindBy(css = ".page-header")
    WebElement pageTitle;

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

    @FindBy(css = "h1")
    WebElement productTitle;

    @FindBy(id = "add_to_basket_form")
    WebElement addToBasketBtn;

    @FindBy(css = "h3 a")
    WebElement itemTitle;


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

    public BasketPage clickOnTheViewBasket() {
        clickWithAction(viewBasket);
        return new BasketPage(driver);
    }

    public BasketPage clickOnTheViewBasketLV() {
        clickWithAction(viewBasketLV);
        return new BasketPage(driver);
    }

    public String getConfirmMessage() {
        return addToBasketConfirmMsg.getText();
    }

    public CatalogBooksPage SelectFirstBookTitle() {
        click(firstBookTitle);
        return new CatalogBooksPage(driver);
    }

    public AllProductPage addItemToBasket(int number) {
        driver.findElement(By.cssSelector(".col-sm-6:nth-child(" + number + ") .btn")).click();
        return this;
    }

    public String getItemName(int number) {
        return driver.findElement(By.cssSelector(".col-sm-6:nth-child(" + number + ") h3 a")).getText();
    }

    public void clickOnItemName(int number) {
        driver.findElement(By.cssSelector(".col-sm-6:nth-child(" + number + ") h3 a")).click();
    }

    public String getItemName1() {
        return productTitle.getText();
    }

    public AllProductPage addToBasketBook() {
        click(addToBasketBtn);
        return this;

    }

    public AllProductPage clickOnClothingLink() {
        click(clothingLink);
        return this;
    }


    public AllProductPage clickOnFictionLink() {
        click(fictionLink);
        return this;
    }


    public AllProductPage clickOnNonFictionLink() {
        click(nonfictionLink);
        return this;
    }


    public AllProductPage clickOnComputersInLiteratureLink() {
        click(compInLitLink);
        return this;
    }


    public AllProductPage clickOnEssentialProgrammingLink() {
        click(programmingLink);
        return this;
    }


    public AllProductPage clickOnHackingLink() {
        click(hackingLink);
        return this;
    }

    public LoginAndRegistrationPage clickOnLoginButton() {
        click(loginLink);
        return new LoginAndRegistrationPage(driver);
    }

    public String getItemName2() {
        return itemTitle.getText();
    }

    public void clickOnBooksLink() {
    }

    public String getPageTitleText() {
        return pageTitle.getText();
    }
}
