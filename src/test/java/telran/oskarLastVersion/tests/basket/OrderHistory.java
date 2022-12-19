package telran.oskarLastVersion.tests.basket;

import com.telran.data.UserData;
import com.telran.pages.basket.OrderHistoryPage;
import com.telran.pages.product.HomePage;
import com.telran.pages.user.AccountPage;
import com.telran.pages.user.LoginAndRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import telran.oskarLastVersion.tests.TestBase1;

public class OrderHistory extends TestBase1 {
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectLanguage("British English");
        new HomePage(driver).clickOnLoginButton();
        new LoginAndRegistrationPage(driver).login(UserData.EMAIL, UserData.PASSWORDNewACC);

    }

    @Test
    public void CheckOrderHistory() {
        new HomePage(driver).clickOnMyAccountLastVe();
        new AccountPage(driver).clickOnOrderHistory();
        new OrderHistoryPage(driver).OrderNumberFind(String.valueOf(100001)).clickOnTheFilterResults();
        Assert.assertTrue(new OrderHistoryPage(driver).OrderAssertNumber().contains("Order #100001"));
    }
    @AfterMethod
    public void logOut() {
        new HomePage(driver).logOut(); }
}


