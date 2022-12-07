package telran.oskarVer1.test.user;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import telran.oskarVer1.data.UserData;
import telran.oskarVer1.pages.user.AccountPage;
import telran.oskarVer1.pages.product.HomePage;
import telran.oskarVer1.pages.user.LoginPage;
import telran.oskarVer1.test.TestBase;

public class AccountTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectLanguage("British English");
        new HomePage(driver).clickOnLoginButton();
        new LoginPage(driver).login(UserData.EMAIL,UserData.PASSWORD);;
        new HomePage(driver).clickOnAccountButton();
    }

    @Test
    public void editUserData() {
        new AccountPage(driver).inputUserName(UserData.Name,UserData.lastName);;
        Assert.assertTrue(new AccountPage(driver).getConfirmMessage().contains("Profile updated"));
        Assert.assertTrue(new AccountPage(driver).getUserName().contains("Adam Noi"));

    }

}