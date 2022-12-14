package telran.oskarLastVersion.tests;

import com.telran.data.UserData;
import com.telran.pages.product.HomePage;
import com.telran.pages.user.AccountPage;
import com.telran.pages.user.LoginAndRegistrationPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginTest extends TestBase1 {
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectLanguage("British English");
        new HomePage(driver).clickOnLoginButton();

    }

    @Test
    public void LoginPositiveTest() {
        new LoginAndRegistrationPage(driver).login(UserData.EMAIL,UserData.PASSWORDNEWACC);
        new HomePage(driver).MyAccount(driver);
        new AccountPage(driver).verifyUserName(UserData.EMAIL);
    }


    @AfterMethod
    public void logOut() {
        new HomePage(driver).logOut(); }
}


