package telran.oskarVer1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id ="login_link")
    WebElement LoginOrRegister;

    @FindBy(id= "id_login-username")
    WebElement Email_address;

    @FindBy(id= "id_login-password")
    WebElement Password;

    @FindBy(xpath= "//button[contains(text(),'Log In')]")
    WebElement LoginSubmit;

    public AccountPage login(String email,String password) {
        click(LoginOrRegister);
        type(Email_address,email);
        type(Password,password);
        clickWithAction(LoginSubmit);
        return new AccountPage(driver);
    }
    public LoginPage loginNegative(WebDriver driver,String email,String password) {
        click(LoginOrRegister);
        type(Email_address,email);
        type(Password,password);
        clickWithAction(LoginSubmit);
        return this;
    }
}