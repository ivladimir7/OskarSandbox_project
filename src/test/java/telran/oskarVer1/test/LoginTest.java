package telran.oskarVer1.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import telran.oskarVer1.data.UserData;
import telran.oskarVer1.pages.AccountPage;
import telran.oskarVer1.pages.Homepage;
import telran.oskarVer1.pages.LoginPage;

public class LoginTest extends TestBase {

    @Test
    public void LoginPositiveTest() {
        new LoginPage(driver).login(UserData.EMAIL,UserData.PASSWORD);
        new Homepage(driver).MyAccount(driver);
        new AccountPage(driver).verifyUserName(UserData.EMAIL);
    }
}
//    }
//    @AfterMethod
//    public void logOut() {
//        new AccountPage(driver).logout();
//    }
//}
