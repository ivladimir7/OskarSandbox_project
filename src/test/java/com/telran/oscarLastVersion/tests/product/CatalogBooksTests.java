package com.telran.oscarLastVersion.tests.product;

import com.telran.data.ReviewData;
import com.telran.data.UserData;
import com.telran.oscarLastVersion.tests.TestBase1;
import com.telran.pages.product.AllProductPage;
import com.telran.pages.product.CatalogBooksPage;
import com.telran.pages.product.HomePage;
import com.telran.pages.user.LoginAndRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CatalogBooksTests extends TestBase1 {
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginButton();
        new LoginAndRegistrationPage(driver).login(UserData.EMAIL, UserData.PASSWORDNewACC);
        new AllProductPage(driver).SelectFirstBookTitle();
    }
    @Test
    public void TitlePresentTest() {
        Assert.assertTrue(new CatalogBooksPage(driver).isBookTitlePresent());
    }
    @Test
    public void PhotoPresentTest() {
        Assert.assertTrue(new CatalogBooksPage(driver).isPhotoPresent());
    }
    @Test
    public void DescriptionPresentTest() {
        Assert.assertTrue(new CatalogBooksPage(driver).isDescriptionPresent());
    }
    @Test
    public void ProductInformationPresentTest() {
        Assert.assertTrue(new CatalogBooksPage(driver).isProductInformationPresent());
    }
    @Test
    public void UPSPresentTest() {
        Assert.assertTrue(new CatalogBooksPage(driver).isUPSPresent());
    }
    @Test
    public void ProductTypePresentTest() {
        Assert.assertTrue(new CatalogBooksPage(driver).isProductTypePresent());
    }
    @Test
    public void PrisePresentTest() {
        Assert.assertTrue(new CatalogBooksPage(driver).isPrisePresent());
    }
    @Test
    public void AvailabilityPresentTest() {
        Assert.assertTrue(new CatalogBooksPage(driver).isAvailabilityPresent());
    }
    @Test
    public void UserRecentlyViewedPresentTest() {
        Assert.assertTrue(new CatalogBooksPage(driver).isUserRecentlyViewedPresent());
    }

    @Test
    public void ReviewTest() {
        new CatalogBooksPage(driver).clickOnReviewPermalink();
        new CatalogBooksPage(driver).ClickOnWriteAReviewBtn();
        new CatalogBooksPage(driver).fieldReview(ReviewData.TitleReview,ReviewData.BodyReview,ReviewData.NameReview, ReviewData.EMAIL);
        new CatalogBooksPage(driver).ClickOnSaveBtn();
    }


    @AfterMethod
    public void logOut() {
        new HomePage(driver).logOut(); }
    }

