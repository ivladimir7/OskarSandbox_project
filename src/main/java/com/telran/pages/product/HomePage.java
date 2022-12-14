package com.telran.pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.telran.pages.BasePage;
import com.telran.pages.user.AccountPage;
import com.telran.pages.user.LoginAndRegistrationPage;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//*[.=' Account']")
    WebElement myAccount;

    @FindBy(xpath = "//body/nav[@id='top_page']/div[1]/div[1]/ul[1]/li[1]/a[1]/i[1]")
    WebElement myAccountLastVer;

    @FindBy(xpath = "//*[@name = 'language']")
    WebElement language;

    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement goBtn;

    public HomePage selectLanguage(String text) {
        click(language);
        Select select = new Select(language);
        select.selectByVisibleText(text);
        click(goBtn);
        return this;
    }

    @FindBy(id = "login_link")
    WebElement loginLink;

    public LoginAndRegistrationPage clickOnLoginButton() {
        click(loginLink);
        return new LoginAndRegistrationPage(driver);
    }

    @FindBy(id = "logout_link")
    WebElement logOutLink;


    public HomePage verifyUserName() {
        Assert.assertTrue(myAccount.isDisplayed());
        Assert.assertTrue(logOutLink.isDisplayed());
        return this;
    }

    public void MyAccount(WebDriver driver) {

        click(myAccount);
    }

    public void MyAccountLastVe(WebDriver driver) {

        click(myAccount);
    }

    public HomePage logOut() {
        click(logOutLink);
        return this;
    }


    public AccountPage clickOnAccountButton() {
        click(myAccountLastVer);
        return new AccountPage(driver);
    }

}


