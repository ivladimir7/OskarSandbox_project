package telran.oskarLastVersion.tests.product;

import com.telran.data.ReviewData;
import com.telran.data.UserData;
import com.telran.pages.product.AllProductPage;
import com.telran.pages.product.CatalogBooksPage;
import com.telran.pages.product.HomePage;
import com.telran.pages.user.LoginAndRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import telran.oskarLastVersion.tests.TestBase1;

public class CatalogBooksTest extends TestBase1 {
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectLanguage("British English");
        new HomePage(driver).clickOnLoginButton();
        new LoginAndRegistrationPage(driver).login(UserData.EMAIL, UserData.PASSWORDNewACC);
        new AllProductPage(driver).SelectFirstBookTitle();
    }
    @Test
    public void UiTest() {
        Assert.assertTrue(new CatalogBooksPage(driver).isBookTitlePresent());
        Assert.assertTrue(new CatalogBooksPage(driver).isPhotoPresent());
        Assert.assertTrue(new CatalogBooksPage(driver).isDescriptionPresent());
        Assert.assertTrue(new CatalogBooksPage(driver).isProductInformationPresent());
        Assert.assertTrue(new CatalogBooksPage(driver).isUPSPresent());
        Assert.assertTrue(new CatalogBooksPage(driver).isProductTypePresent());
        Assert.assertTrue(new CatalogBooksPage(driver).isPrisePresent());
        Assert.assertTrue(new CatalogBooksPage(driver).isAvailabilityPresent());
        Assert.assertTrue(new CatalogBooksPage(driver).isUserRecentlyViewedPresent());
    }

    @Test
    public void ReviewTest() {
        new CatalogBooksPage(driver).clickOnReviewPermalink();
        new CatalogBooksPage(driver).ClickOnWriteAReviewBtn();
        new CatalogBooksPage(driver).fieldReview(ReviewData.TitleReview,ReviewData.BodyReview,ReviewData.NameReview, ReviewData.EMAIL);
        new CatalogBooksPage(driver).ClickOnSaveBtn();
    }


    @AfterMethod
    public void logOut() {
        new HomePage(driver).logOut(); }
    }

