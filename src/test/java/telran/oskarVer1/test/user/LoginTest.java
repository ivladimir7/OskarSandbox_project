package telran.oskarVer1.test.user;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import telran.oskarVer1.data.UserData;
import telran.oskarVer1.pages.user.AccountPage;
import telran.oskarVer1.pages.product.HomePage;
import telran.oskarVer1.pages.user.LoginPage;
import telran.oskarVer1.test.TestBase;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectLanguage("British English");
        new HomePage(driver).clickOnLoginButton();

    }

    @Test
    public void LoginPositiveTest() {
        new LoginPage(driver).login(UserData.EMAIL,UserData.PASSWORD);
        new HomePage(driver).MyAccount(driver);
        new AccountPage(driver).verifyUserName(UserData.EMAIL);
    }


    @AfterMethod
    public void logOut() {
        new HomePage(driver).logout(); }
}
