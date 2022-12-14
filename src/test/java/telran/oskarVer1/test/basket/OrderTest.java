package telran.oskarVer1.test.basket;

import com.telran.data.AddressData;
import com.telran.data.UserData;
import com.telran.pages.basket.*;
import com.telran.pages.product.AllProductPage;
import com.telran.pages.product.HomePage;
import com.telran.pages.user.LoginAndRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import telran.oskarVer1.test.TestBase;

public class OrderTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectLanguage("British English");
        new HomePage(driver).clickOnLoginButton();
        new LoginAndRegistrationPage(driver).login(UserData.EMAIL,UserData.PASSWORD);;

    }
    @Test
    public void addTheProduct() {
        new AllProductPage(driver).clickOnTheAllProduct().selectTheProduct().clickOnTheViewBasket();
        new BasketPage(driver).proceedToCheckout();
        new ShippingAddressPage(driver).NewAddressFormField(AddressData.FIRST_NAME, AddressData.LAST_NAME,
                AddressData.FIRST_LINE_OF_ADDRESS, AddressData.CITY, AddressData.ZIP_CODE);
        new ShippingAddressPage(driver).selectCountry("Germany").clickOnContinueButton();
        new PaymentPage(driver).clickOnContinue();
        new PreviewOrderPage(driver).clickOnPlaceOrderButton();
        Assert.assertTrue(new OrderConfirmationPage(driver).OrderNumber().contains("confirmation"));
    }
}



