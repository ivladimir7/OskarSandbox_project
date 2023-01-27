package com.telran.oscarVer1.test.user;

import com.telran.data.UserData;
import com.telran.oscarVer1.test.TestBase;
import com.telran.pages.product.HomePage;
import com.telran.pages.user.AccountPage;
import com.telran.pages.user.LoginAndRegistrationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).clickOnLoginButton();
    }

    @Test
    public void userRegistrationTest() {
        new LoginAndRegistrationPage(driver).userRegistr(UserData.REG_EMAIL, UserData.REG_Password, UserData.REG_Password_Confirm);
        new HomePage(driver).clickOnMyAccount();
        new AccountPage(driver).verifyUserName(UserData.EMAIL).deleteRegisterUser(UserData.REG_Password);
    }
}

