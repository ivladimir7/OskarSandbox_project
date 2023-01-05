package com.telran.oskarVer1.test.user;

import com.telran.data.UserData;
import com.telran.pages.product.HomePage;
import com.telran.pages.user.AccountPage;
import com.telran.pages.user.LoginAndRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.telran.oskarVer1.test.TestBase;

public class AccountTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectLanguage("British English");
        new HomePage(driver).clickOnLoginButton();
        new LoginAndRegistrationPage(driver).login(UserData.EMAIL,UserData.PASSWORD);;
        new HomePage(driver).clickOnAccountButton();
    }

    @Test
    public void editUserData() {
        new AccountPage(driver).inputUserName(UserData.Name,UserData.lastName);;
        Assert.assertTrue(new AccountPage(driver).getConfirmMessage().contains("Profile updated"));
        Assert.assertTrue(new AccountPage(driver).getUserName().contains("Adam Noi"));

    }

}