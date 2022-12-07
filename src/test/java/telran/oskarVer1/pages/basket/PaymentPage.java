package telran.oskarVer1.pages.basket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import telran.oskarVer1.pages.BasePage;

public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[.='Continue']")
    WebElement continueButton;

    public PaymentPage clickOnContinue() {
        clickWithJSExecutor(continueButton, 500, 0);
        return this;
    }

}