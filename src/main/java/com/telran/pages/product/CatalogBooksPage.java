package com.telran.pages.product;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogBooksPage extends BasePage {
    public CatalogBooksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='col-sm-6 product_main']/h1")
    WebElement bookTitle;

    @FindBy(xpath = "//div[@class='col-sm-6 product_main']/h1")
    WebElement photoHandBook;

    @FindBy(css = "#product_description > h2")
    WebElement ProductDescription;

    @FindBy(css = ".sub-header:nth-child(4) > h2 2")
    WebElement ProductInformation;

    @FindBy(css = "tr:nth-child(1) > td")
    WebElement ProductUPC;

    @FindBy(css = "tr:nth-child(2) > td")
    WebElement ProductType;

    @FindBy(css = "tr:nth-child(4) > td")
    WebElement ProductPrise;

    @FindBy(css = "tr:nth-child(6) > td")
    WebElement ProductAvailability;

    @FindBy(css = ".sub-header:nth-child(4) > h2")
    WebElement RecentlyViewed;

    @FindBy(css = "small:nth-child(1) > a")
    WebElement permalink;

    @FindBy(id = "write_review")
    WebElement writeReviewBtn;

    @FindBy(id = "id_title")
    WebElement TitleReview;

    @FindBy(id = "id_body")
    WebElement BodyReview;

    @FindBy(id = "id_Name")
    WebElement NameReview;

    @FindBy(id = "id_Email")
    WebElement EmailReview;

    @FindBy(css = ".Three > .fas:nth-child(4)")
    WebElement Score;

    @FindBy(css = ".btn:nth-child(8)")
    WebElement SaveBtn;


    public boolean isBookTitlePresent() {
        return bookTitle.isDisplayed();
    }

    public boolean isPhotoPresent() {
        return photoHandBook.isDisplayed();
    }

    public boolean isDescriptionPresent() {
        return ProductDescription.isDisplayed();
    }

    public boolean isProductInformationPresent() {
        return ProductInformation.isDisplayed();
    }

    public boolean isUPSPresent() {
        return ProductUPC.isDisplayed();

    }

    public boolean isProductTypePresent() {
        return ProductType.isDisplayed();
    }

    public boolean isPrisePresent() {
        return ProductPrise.isDisplayed();
    }

    public boolean isAvailabilityPresent() {
        return ProductAvailability.isDisplayed();
    }

    public boolean isUserRecentlyViewedPresent() {
        return RecentlyViewed.isDisplayed();
    }

    public void clickOnReviewPermalink() {
        click(writeReviewBtn);
    }

    public void ClickOnWriteAReviewBtn() {
        click(permalink);
    }

    public void fieldReview(String titleReview, String bodyReview,
                            String nameReview, String email) {
        type(TitleReview, titleReview);
        type(BodyReview, bodyReview);
        type(NameReview, nameReview);
        type(EmailReview, email);
        clickWithJSExecutor(Score, 0, 300);
    }

    public void ClickOnSaveBtn() {
        click(SaveBtn);
    }
}