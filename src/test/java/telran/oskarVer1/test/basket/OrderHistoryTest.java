package telran.oskarVer1.test.basket;

import com.telran.data.UserData;
import com.telran.pages.basket.OrderHistoryPage;
import com.telran.pages.product.HomePage;
import com.telran.pages.user.AccountPage;
import com.telran.pages.user.LoginAndRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import telran.oskarVer1.test.TestBase;

public class OrderHistoryTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectLanguage("British English");
        new HomePage(driver).clickOnLoginButton();
        new LoginAndRegistrationPage(driver).login(UserData.EMAIL, UserData.PASSWORD);
        ;

    }

    @Test
    public void CheckOrderHistory() {
        new HomePage(driver).MyAccount(driver);
        new AccountPage(driver).clickOnOrderHistory();
        new OrderHistoryPage(driver).OrderNumberFind(String.valueOf(627270)).clickOnTheFilterResults();
        Assert.assertTrue(new OrderHistoryPage(driver).OrderAssertNumber().contains("Order #627270"));
    }
}
