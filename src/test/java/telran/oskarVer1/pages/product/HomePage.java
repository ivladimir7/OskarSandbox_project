package telran.oskarVer1.pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import telran.oskarVer1.pages.BasePage;
import telran.oskarVer1.pages.user.LoginPage;
import telran.oskarVer1.pages.user.AccountPage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath= "//body/div[@id='top_page']/div[2]/div[1]/ul[1]/li[1]/a[1]")
    WebElement myAccount;

    public void MyAccount(WebDriver driver) {

        click(myAccount);
    }

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

    public LoginPage clickOnLoginButton() {
        click(loginLink);
        return new LoginPage(driver);
    }

    @FindBy(id = "logout_link")
    WebElement logOutLink;

    @FindBy(xpath = "//*[.=' Account']")
    WebElement accountLink;

    public HomePage verifyUserName() {
        Assert.assertTrue(accountLink.isDisplayed());
        Assert.assertTrue(logOutLink.isDisplayed());
        return this;
    }

    public HomePage logout() {
        click(logOutLink);
        return this;
    }


    public AccountPage clickOnAccountButton() {
        click(accountLink);
        return new AccountPage(driver);
    }
}

