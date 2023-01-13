package com.telran.oskarLastVersion.tests.basket;


import com.telran.oskarLastVersion.tests.TestBase1;
import com.telran.pages.BasePage;
import com.telran.pages.basket.BasketPage;
import com.telran.pages.product.AllProductPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class PriseAndQuantityTest extends TestBase1 {


    @Test
    public void quantityTest() {
        new AllProductPage(driver).addItemToBasket(1).clickOnTheViewBasketLV();
        double price = new BasketPage(driver).getPriseForOne();
        new BasketPage(driver).enterQuantity("3");
        new BasePage(driver).pause(1000);
        double priceForAFew = new BasketPage(driver).getPriceForAFew();
        System.out.println(priceForAFew);
        Assert.assertEquals(priceForAFew, price * 3);

    }

    @Test
    public void compareTotalPriseTest() {
        new AllProductPage(driver).addItemToBasket(1).clickOnTheViewBasketLV();
        double price = new BasketPage(driver).getPriseForOne();
        System.out.println(price);
        new BasketPage(driver).enterQuantity("2");
        new BasePage(driver).pause(1000);
        double priceForAFew = new BasketPage(driver).getPriceForAFew();
        System.out.println(priceForAFew);
        double priceTotal = new BasketPage(driver).getPriceTotal();
        System.out.println(priceTotal);
        Assert.assertEquals(priceForAFew, price * 2);
        Assert.assertEquals(priceForAFew, priceTotal);
    }

    @AfterMethod
    public void tierDown() {
        new BasketPage(driver).removeBook();
    }
}
