package com.telran.oscarLastVersion.tests.basket;

import com.telran.data.UserData;
import com.telran.pages.basket.OrderHistoryPage;
import com.telran.pages.product.HomePage;
import com.telran.pages.user.AccountPage;
import com.telran.pages.user.LoginAndRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.telran.oscarLastVersion.tests.TestBase1;

public class OrderHistoryTests extends TestBase1 {
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginButton();
        new LoginAndRegistrationPage(driver).login(UserData.EmailLogin, UserData.PasswordLogin);

    }

    @Test
    public void CheckOrderHistory() {
        new HomePage(driver).clickOnMyAccountLastVe();
        new AccountPage(driver).clickOnOrderHistory();
        new OrderHistoryPage(driver).OrderNumberFind(String.valueOf(100001)).clickOnTheFilterResults();
        Assert.assertTrue(new OrderHistoryPage(driver).OrderAssertNumber().contains("Order "));
    }
    @AfterMethod(enabled = true)
    public void TierDown() {
        new HomePage(driver).clickOnMyAccountLastVe();
        new AccountPage(driver).deleteRegisterUser(UserData.PasswordLogin);
    }

}


