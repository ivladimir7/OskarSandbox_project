package com.telran.oscarLastVersion.tests.user;

import com.telran.data.AddressData;
import com.telran.data.UserData;
import com.telran.oscarLastVersion.tests.TestBase1;
import com.telran.pages.product.HomePage;
import com.telran.pages.user.AccountPage;
import com.telran.pages.user.LoginAndRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressBookTest extends TestBase1 {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectLanguage("British English");
        new HomePage(driver).clickOnLoginButton();
        new LoginAndRegistrationPage(driver).login(UserData.EMAIL, UserData.PASSWORDNewACC);
        new HomePage(driver).clickOnAccountButton();
        new AccountPage(driver).clickOnAddressBookLink();
    }

    @Test
    public void addNewAddressPositiveTest() {
        new AccountPage(driver).AddressFormFillWithValidData(AddressData.FIRST_NAME1,
                AddressData.LAST_NAME1, AddressData.FIRST_LINE_OF_ADDRESS1,
                AddressData.CITY1, AddressData.ZIP_CODE1);
        new AccountPage(driver).selectCountry("Germany").clickOnSaveBtn();
        Assert.assertTrue(new AccountPage(driver).isConfirmMessagePresent());
    }


    @Test
    public void editAddressPositiveTest() {
        new AccountPage(driver).AddressFormFillWithValidData(AddressData.FIRST_NAME1,
                AddressData.LAST_NAME1, AddressData.FIRST_LINE_OF_ADDRESS1,
                AddressData.CITY1, AddressData.ZIP_CODE1);
        new AccountPage(driver).selectCountry("Germany").clickOnSaveBtn();
        new AccountPage(driver).clickOnEditBtn().editAllRequiredFields(AddressData.FIRST_NAME1,
                AddressData.LAST_NAME1, AddressData.FIRST_LINE_OF_ADDRESS1,
                AddressData.CITY1, AddressData.ZIP_CODE1).clickOnSaveBtn();
        Assert.assertTrue(new AccountPage(driver).isConfirmMessageText().contains
                ("Address '" + AddressData.FIRST_NAME1 + " " + AddressData.LAST_NAME1 +
                        ", " + AddressData.FIRST_LINE_OF_ADDRESS1 + ", " +
                        AddressData.CITY1 + ", " + AddressData.ZIP_CODE1 + ", Germany' updated"));
    }

    @Test
    public void addTheSameAddressNegativeTest() {
        new AccountPage(driver).AddressFormFillWithValidData(AddressData.FIRST_NAME1,
                AddressData.LAST_NAME1, AddressData.FIRST_LINE_OF_ADDRESS1,
                AddressData.CITY1, AddressData.ZIP_CODE1);
        new AccountPage(driver).selectCountry("Germany").clickOnSaveBtn();
        new AccountPage(driver).AddressFormFillWithValidData(AddressData.FIRST_NAME1,
                AddressData.LAST_NAME1, AddressData.FIRST_LINE_OF_ADDRESS1,
                AddressData.CITY1, AddressData.ZIP_CODE1);
        new AccountPage(driver).selectCountry("Germany").clickOnSaveBtn();
        Assert.assertTrue(new AccountPage(driver).isErrorMessagePresent());
    }

    @AfterMethod
    public void tierDown() {
        new HomePage(driver).logOut();
    }
}

