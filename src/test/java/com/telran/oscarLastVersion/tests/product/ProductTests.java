package com.telran.oscarLastVersion.tests.product;

import com.telran.oscarLastVersion.tests.TestBase1;
import com.telran.pages.product.AllProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends TestBase1 {


    @Test
    public void compareTitleItemNameTest(){
        String itemName = new AllProductPage(driver).getItemName(1);
        System.out.println(itemName);
        new AllProductPage(driver).clickOnItemName(1);
        String itemName2 = new AllProductPage(driver).getItemName1();
        System.out.println(itemName2);
        new AllProductPage(driver).addToBasketBook().clickOnTheViewBasketLV();
        String itemName3 = new AllProductPage(driver).getItemName2();
        System.out.println(itemName3);
        Assert.assertTrue(itemName.contains("handbook") && itemName2.contains("handbook") && itemName3.contains("handbook"));

    }
}
