package telran.oskarVer1.pages.basket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import telran.oskarVer1.pages.BasePage;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form[@class = 'basket_summary']/div[1]//h3")
    WebElement bookFirst;

    @FindBy(xpath = "//form[@class = 'basket_summary']/div[2]//h3")
    WebElement bookLast;

    public String getBookFirst() {
        return bookFirst.getText();
    }

    public String getBookLast() {
        return bookLast.getText();
    }

    @FindBy(xpath = "//a[. = 'Proceed to checkout']")
    WebElement proceedToCheckoutBtn;

    public ShippingAddressPage proceedToCheckout() {
        click(proceedToCheckoutBtn);
        return new ShippingAddressPage(driver);
    }

    @FindBy(id = "id_form-0-quantity")
    WebElement quantityProduct;

    @FindBy(xpath = "//button[. = 'Update']")
    WebElement updateQuantity;

    public BasketPage removeBook() {
        quantityProduct.clear();
        quantityProduct.sendKeys("0");
        updateQuantity.click();
        return this;
    }
}
