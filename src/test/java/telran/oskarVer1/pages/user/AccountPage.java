package telran.oskarVer1.pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import telran.oskarVer1.pages.BasePage;

public class AccountPage extends BasePage {
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

    @FindBy(xpath = "//*[.='Edit profile']")
    WebElement editProfileBtn;

    @FindBy(id = "id_first_name")
    WebElement firstNameField;

    @FindBy(id = "id_last_name")
    WebElement lastNameField;

    @FindBy(xpath = "//button[.='Save']")
    WebElement saveBtn;

    public AccountPage inputUserName(String Name, String lastName) {
        click(editProfileBtn);
        type(firstNameField, Name);
        type(lastNameField, lastName);
        click(saveBtn);
        return this;
    }
    @FindBy(css = ".alertinner.wicon")
    WebElement confirmationMsg;

    public String getConfirmMessage() {
        return confirmationMsg.getText();
    }

    @FindBy(xpath = "//td[contains(text(), 'Adam Noi')]")
    WebElement userName;

    public String getUserName() {
        return userName.getText();
    }

    @FindBy(xpath = "//a[contains(text(),'Order History')]")
    WebElement OrderHistory;

    public void clickOnOrderHistory() {
        clickWithAction(OrderHistory);
    }
}

