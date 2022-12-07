package telran.oskarVer1.pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import telran.oskarVer1.pages.BasePage;

public class AllProductPage extends BasePage {
    public AllProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ol[@class = 'row']/li[1]//button")
    WebElement addBookToBasketFirst;

    @FindBy(xpath = "//ol[@class = 'row']/li[17]//button")
    WebElement addBookToBasketLast;


    public AllProductPage selectTheProduct() {
        click(addBookToBasketFirst);
        clickWithJSExecutor(addBookToBasketLast,0,500);
        return new AllProductPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'All products')]")
    WebElement selectAllProduct;

    public AllProductPage clickOnTheAllProduct() {
        clickWithAction(selectAllProduct);
        return new AllProductPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'View basket')]")
    WebElement viewBasket;

    public AllProductPage clickOnTheViewBasket(){
        clickWithAction(viewBasket);
        return new AllProductPage(driver);
    }
}
