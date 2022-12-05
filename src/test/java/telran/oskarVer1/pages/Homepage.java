package telran.oskarVer1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage {
    public Homepage (WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath= "//body/div[@id='top_page']/div[2]/div[1]/ul[1]/li[1]/a[1]")
    WebElement myAccount;

    public void MyAccount(WebDriver driver) {

        click(myAccount);
    }
}
