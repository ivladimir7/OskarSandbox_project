package telran.oskarLastVersion.tests.User;

import com.telran.data.UserData;
import com.telran.pages.user.AccountPage;
import com.telran.pages.user.LoginAndRegistrationPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.telran.utils.DataProviders;
import org.testng.annotations.Test;
import com.telran.pages.product.HomePage;
import telran.oskarLastVersion.tests.TestBase1;


public class RegistrationPositiveTest extends TestBase1 {
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectLanguage("British English");
        new HomePage(driver).clickOnLoginButton();

    }

    @Test
    public void registerPositiveTest() {
        new LoginAndRegistrationPage(driver).register(UserData.REG_EMAIL, UserData.REG_Password, UserData.REG_Password_Confirm);
        new HomePage(driver).clickOnMyAccountLastVe();
        new AccountPage(driver).verifyUserName(UserData.EMAIL).deleteRegisterUser(UserData.REG_Password);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registeredNewUserFromCSV")
    public void RegistrationPositiveTestWithDataProvider(String email, String password, String confirmPassword) {
        new LoginAndRegistrationPage(driver).register(email, password, confirmPassword);
        new HomePage(driver).clickOnMyAccount();
        new AccountPage(driver).verifyUserName(UserData.EMAIL).deleteRegisterUser(UserData.REG_Password);
        ;

    }
}

