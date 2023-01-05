package com.telran.pages.product;

import org.openqa.selenium.By;
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

    @FindBy(css = ".nav-link.mt-2.mt-lg-0")
    WebElement myAccountLastVer;

    @FindBy(xpath = "//*[@name = 'language']")
    WebElement language;

    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement goBtn;

    @FindBy(id = "login_link")
    WebElement loginLink;

    @FindBy(id = "logout_link")
    WebElement logOutLink;

    public HomePage selectLanguage(String text) {
        click(language);
        Select select = new Select(language);
        select.selectByVisibleText(text);
        click(goBtn);
        return this;
    }


    public LoginAndRegistrationPage clickOnLoginButton() {
        click(loginLink);
        return new LoginAndRegistrationPage(driver);
    }


    public HomePage verifyUserName() {
        Assert.assertTrue(myAccount.isDisplayed());
        Assert.assertTrue(logOutLink.isDisplayed());
        return this;
    }

    public AccountPage clickOnMyAccount() {

        click(myAccount);
        return new AccountPage(driver);
    }

    public AccountPage clickOnMyAccountLastVe() {
        click(myAccountLastVer);
        return new AccountPage(driver);
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


