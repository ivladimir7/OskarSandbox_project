package com.telran.oskarVer1.test.product;

import com.telran.data.UserData;
import com.telran.oskarVer1.test.TestBase;
import com.telran.pages.basket.BasketPage;
import com.telran.pages.product.AllProductPage;
import com.telran.pages.product.HomePage;
import com.telran.pages.user.LoginAndRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).clickOnLoginButton();
        new LoginAndRegistrationPage(driver).login(UserData.EMAIL, UserData.PASSWORD);
    }

    @Test
    public void addToBasketTest() {
        new AllProductPage(driver).clickOnTheAllProduct().selectTheProduct().clickOnTheViewBasket();
        Assert.assertTrue(new BasketPage(driver).getBookFirst().contains("The shellcoder's handbook"));
        Assert.assertTrue(new BasketPage(driver).getBookLast().contains("Metasploit"));
    }

    @AfterMethod
    public void tierDown(){
        new BasketPage(driver).removeBook();
        new BasketPage(driver).removeBook();
    }
}