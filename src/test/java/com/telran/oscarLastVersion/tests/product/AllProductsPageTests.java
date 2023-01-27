package com.telran.oscarLastVersion.tests.product;

import com.telran.data.UserData;
import com.telran.oscarLastVersion.tests.TestBase1;
import com.telran.pages.basket.BasketPage;
import com.telran.pages.product.AllProductPage;
import com.telran.pages.product.HomePage;
import com.telran.pages.user.LoginAndRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllProductsPageTests extends TestBase1 {
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginButton();
        new LoginAndRegistrationPage(driver).login(UserData.EMAIL, UserData.PASSWORDNewACC);
    }

    @Test
    public void addToBasketConfirmMessageTest() {
        new AllProductPage(driver).addToBasket();
        Assert.assertTrue(new AllProductPage(driver).getConfirmMessage().contains("has been added to your basket"));

    }

    @Test
    public void addToBasketTestBook() {
        new AllProductPage(driver).addToBasket().clickOnTheViewBasketLV();
        Assert.assertTrue(new BasketPage(driver).getBookFirstLV().contains("The shellcoder's handbook"));
        Assert.assertTrue(new BasketPage(driver).getBookLastLV().contains("Metasploit"));
        new BasketPage(driver).removeBook();
        new BasketPage(driver).removeBook();
    }

    @AfterMethod
    public void logOut() {
        new HomePage(driver).logOut(); }
    }
