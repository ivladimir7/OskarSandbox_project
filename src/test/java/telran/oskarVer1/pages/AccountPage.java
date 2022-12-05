package telran.oskarVer1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//tbody/tr[2]/td[1]")
    WebElement emailNameValue;

    public AccountPage verifyUserName(String EMAIL) {
            if (emailNameValue.getText().equalsIgnoreCase(EMAIL)) {
                System.out.println("Correct user name: " + emailNameValue.getText());
            } else {
                System.out.println("Incorrect user name: " + emailNameValue.getText());
            }
            return this;
        }
    }
