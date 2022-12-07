package telran.oskarVer1.pages.basket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import telran.oskarVer1.pages.BasePage;

public class OrderConfirmationPage extends BasePage {
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = " //h1[contains(text(),' ')]")
    WebElement OrderNumber;

    public String  OrderNumber() {
        return  OrderNumber.getText();
    }
}
