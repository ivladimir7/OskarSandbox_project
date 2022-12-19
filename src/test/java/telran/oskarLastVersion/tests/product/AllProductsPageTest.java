package telran.oskarLastVersion.tests.product;

import com.telran.data.UserData;
import com.telran.pages.basket.BasketPage;
import com.telran.pages.product.AllProductPage;
import com.telran.pages.product.HomePage;
import com.telran.pages.user.AccountPage;
import com.telran.pages.user.LoginAndRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import telran.oskarLastVersion.tests.TestBase1;

public class AllProductsPageTest extends TestBase1 {
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectLanguage("British English");
        new HomePage(driver).clickOnLoginButton();
        new LoginAndRegistrationPage(driver).login(UserData.EMAIL, UserData.PASSWORDNewACC);
    }

    @Test
    public void addToBasketConfirmMessageTest() {
        new AllProductPage(driver).addToBasket();
        Assert.assertTrue(new AllProductPage(driver).getConfirmMessage().contains("has been added to your basket"));
    }

    @Test
    public void addToBasketTestBook() {
        new AllProductPage(driver).addToBasket();
        new AllProductPage(driver).clickOnTheViewBasketLV();
        Assert.assertTrue(new BasketPage(driver).getBookFirstLV().contains("The shellcoder's handbook"));
        Assert.assertTrue(new BasketPage(driver).getBookLastLV().contains("Metasploit"));
    }

    @AfterMethod
    public void logOut() {
        new HomePage(driver).logOut(); }
}
