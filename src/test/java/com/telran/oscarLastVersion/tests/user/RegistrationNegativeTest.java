package com.telran.oscarLastVersion.tests.user;

import com.telran.data.UserData;
import com.telran.oscarLastVersion.tests.TestBase1;
import com.telran.pages.product.HomePage;
import com.telran.pages.user.LoginAndRegistrationPage;
import com.telran.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationNegativeTest extends TestBase1 {
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectLanguage("British English");
        new HomePage(driver).clickOnLoginButton();

    }

    @Test
    public void registrationNegativeWIthInvalidPassword() {
        new LoginAndRegistrationPage(driver).register(UserData.EMAIL1, UserData.REG_INVPassword, UserData.REG_INVPassword_Confirm);
        Assert.assertTrue(new LoginAndRegistrationPage(driver).getErrorMsg().contains("Oops! We found some errors"));
    }
    @Test
    public void registrationNegativeWithAlreadyExistUser() {
        new LoginAndRegistrationPage(driver).register(UserData.EMAIL, UserData.REG_Password, UserData.REG_Password_Confirm);
        Assert.assertTrue(new LoginAndRegistrationPage(driver).getWarningMessage().contains("A user with that email address already exists"));
    }


    @Test(dataProviderClass = DataProviders.class, dataProvider = "registeredNewUserWIthInvalidPasswordFromCSV")
    public void RegistrationNegativeTestWithInvalidPasswordWithDataProvider(String email, String password, String confirmPassword) {
        new LoginAndRegistrationPage(driver).register(email, password, confirmPassword);
        Assert.assertTrue(new LoginAndRegistrationPage(driver).getErrorMsg().contains("Oops! We found some errors"));


    }
    @Test(dataProviderClass = DataProviders.class, dataProvider = "registeredNewUserWIthInvalidPasswordFromCSV")
    public void RegistrationNegativeTestWithInvalidEmailWithDataProvider(String email, String password, String confirmPassword) {
        new LoginAndRegistrationPage(driver).register(email, password, confirmPassword);
        Assert.assertTrue(new LoginAndRegistrationPage(driver).getErrorMsg().contains("Oops! We found some errors"));
    }

    @AfterMethod(enabled = false)
    public void tierDown() {
        new HomePage(driver).logOut();
    }
}


