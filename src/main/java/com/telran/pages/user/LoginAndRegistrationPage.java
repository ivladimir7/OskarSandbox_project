package com.telran.pages.user;


import com.telran.pages.BasePage;
import com.telran.pages.product.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginAndRegistrationPage extends BasePage {
    public LoginAndRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login_link")
    WebElement LoginOrRegister;

    @FindBy(id = "id_login-username")
    WebElement Email_address;

    @FindBy(id = "id_login-password")
    WebElement Password;

    @FindBy(xpath = "//button[contains(text(),'Log In')]")
    WebElement LoginSubmit;

    @FindBy(id = "id_registration-email")
    WebElement RegEmail_address;

    @FindBy(id = "id_registration-password1")
    WebElement REGPassword;

    @FindBy(id = "id_registration-password2")
    WebElement ConfirmPassword;

    @FindBy(xpath = "//button[.='Register']")
    WebElement regBtn;

    @FindBy(xpath = "//*[@value='Register']")
    WebElement RegisterSubmit;


    @FindBy(css = ".alert.alert-danger")
    WebElement getErrorMsg;

    @FindBy(css = "#login_link")
    WebElement getLoginOrRegister;

    @FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/span[1]")
    WebElement getWarningMessage;



    public AccountPage login(String email, String password) {
        click(LoginOrRegister);
        type(Email_address, email);
        type(Password, password);
        clickWithAction(LoginSubmit);
        return new AccountPage(driver);
    }

    public LoginAndRegistrationPage loginNegative(WebDriver driver, String email, String password) {
        click(LoginOrRegister);
        type(Email_address, email);
        type(Password, password);
        clickWithAction(LoginSubmit);
        return this;
    }
    public HomePage userRegistr(String email, String password, String confirmPassword) {
        int i = (int) (System.currentTimeMillis()) / 10000;
        type(RegEmail_address, i + email);
        type(REGPassword, password);
        type(ConfirmPassword, confirmPassword);
        click(regBtn);
        return new HomePage(driver);
    }


    public LoginAndRegistrationPage register(String email, String password, String confirmPassword) {
        int i = (int) (System.currentTimeMillis()) / 10000;
        type(RegEmail_address, i + email);
        type(REGPassword, password);
        type(ConfirmPassword, confirmPassword);
        click(RegisterSubmit);
        return this;
    }
    public LoginAndRegistrationPage registerTestUser(String email, String password) {
        type(RegEmail_address, email);
        type(REGPassword, password);
        type(ConfirmPassword, password);
        click(RegisterSubmit);
        return this;
    }


    public String getWarningMessage() {
        return getWarningMessage.getText();
    }

    public String getErrorMsg() {
        System.out.println(getErrorMsg.getText());
        return getErrorMsg.getText();
    }
}