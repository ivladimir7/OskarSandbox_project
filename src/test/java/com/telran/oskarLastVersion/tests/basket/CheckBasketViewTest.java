package com.telran.oskarLastVersion.tests.basket;

import com.telran.oskarLastVersion.tests.TestBase1;
import com.telran.pages.basket.BasketPage;
import com.telran.pages.basket.ShippingAddressPage;
import com.telran.pages.product.AllProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBasketViewTest extends TestBase1 {

    @Test
    public void proceedToCheckoutBtnForNonLoggedUserTest() {
        new AllProductPage(driver).clickOnTheAllProductLV().selectTheProductLV().clickOnTheViewBasketLV();
        new BasketPage(driver).proceedToCheckout();
        Assert.assertTrue(new ShippingAddressPage(driver).getPageTitle().contains("Who are you?"));
    }

}

