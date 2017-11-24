import Pages.*;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Ignore;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by alexanderhe on 06.07.17.
 */
public class ShoppingTest {

    private ChromeDriver driver;

    @BeforeClass
    public static void setupWebDriverManager() {
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeMethod
    public void initTest() {
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
    }

    @AfterMethod
    public void tearDownTest() {
        driver.quit();
    }

    @Test(enabled = false)
    public void loginWithValidCredentialsShouldBeSuccessfullTest() {
        driver.findElementByCssSelector("a.login").click();
        driver.findElementById("email").sendKeys("rianamahliadewi@gmail.com");
        driver.findElementById("passwd").sendKeys("lalayeyeye");
        driver.findElementById("SubmitLogin").click();
        String welcomeText = driver.findElementByCssSelector("p.info-account").getText();
        assertThat(welcomeText, is(equalTo("Welcome to your account. Here you can manage all of your personal information and orders.")));
    }

    @Test(enabled = false)
    public void loginWithValidCredentialsShouldBeSuccessfullWithPageObjectsTest() {
        WelcomePage welcome = new WelcomePage(driver);
        LoginPage login = welcome.clickSignInButton();
        login.fillEmail("rianamahliadewi@gmail.com");
        login.fillPassword("lalayeyeye");
        login.clickLoginButton();
        AccountPage account = new AccountPage(driver);
        String welcomeText = account.fetchWelcomeText();
        assertThat(welcomeText, is(equalTo("Welcome to your account. Here you can manage all of your personal information and orders.")));
    }

    @Test(enabled = false)
    public void loginWithInvalidCredentialsShouldThrowAnAlertTest() {
        driver.findElementByCssSelector("a.login").click();
        driver.findElementById("email").sendKeys("invalidEmail@gmail.com");
        driver.findElementById("passwd").sendKeys("wrongPassword");
        driver.findElementById("SubmitLogin").click();
        String errorText = driver.findElementByXPath("//div[@class='alert alert-danger']//ol//li").getText();
        assertThat(errorText, is(equalTo("Authentication failed.")));
    }

    @Test(enabled = false)
    public void loginWithInvalidCredentialsShouldThrowAnAlertWithPageObjectsTest() {
        WelcomePage welcome = new WelcomePage(driver);
        LoginPage login = welcome.clickSignInButton();
        login.fillEmail("invalidEmail@gmail.com");
        login.fillPassword("wrongPassword");
        login.clickLoginButton();
        String errorText = login.fetchErrorMessage();
        assertThat(errorText, is(equalTo("Authentication failed.")));
    }

    @Test(enabled = false)
    public void searchForProductBySendingReturnTest() {
        driver.findElementById("search_query_top").sendKeys("dress");
        driver.findElementById("search_query_top").sendKeys(Keys.RETURN);
        List<WebElement> products = driver.findElementsByXPath("//ul[@class='product_list grid row']//li");
        assertThat(products.size(), is(greaterThan(1)));
    }

    @Test(enabled = false)
    public void searchForProductBySendingReturnWithPageObjectsTest() {
        WelcomePage welcome = new WelcomePage(driver);
        welcome.fillProductSearch("dress");
        SearchResultPage searchResults = welcome.sendReturnToSearchField();
        int numberOfResults = searchResults.countNumberOfResults();
        assertThat(numberOfResults, is(greaterThan(1)));
    }

    @Test(enabled = false)
    public void searchForProductByClickingSearchButtonTest() {
        driver.findElementById("search_query_top").sendKeys("dress");
        driver.findElementByCssSelector("button.btn.btn-default.button-search").click();
        List<WebElement> products = driver.findElementsByXPath("//ul[@class='product_list grid row']//li");
        assertThat(products.size(), is(greaterThan(1)));
        driver.quit();
    }

    @Test(enabled = false)
    public void searchForProductByClickingSearchButtonWithPageObjectsTest() {
        WelcomePage welcome = new WelcomePage(driver);
        welcome.fillProductSearch("dress");
        SearchResultPage searchResults = welcome.clickSearchButton();
        int numberOfResults = searchResults.countNumberOfResults();
        assertThat(numberOfResults, is(greaterThan(1)));
    }

    @Test(enabled = false)
    public void sendContactMessageWithoutSubjectShouldFailTest() {
        driver.findElementById("contact-link").click();
        driver.findElementById("email").sendKeys("test@testmail.co.uk");
        driver.findElementById("message").sendKeys("This is a test. Please do nothing");
        driver.findElementById("submitMessage").click();
        String errorText = driver.findElementByXPath("//div[@class='alert alert-danger']//ol//li").getText();
        assertThat(errorText, is(equalTo("Please select a subject from the list provided.")));
    }

    @Test(enabled = false)
    public void sendContactMessageWithoutSubjectShouldFailWithPageObjectsTest() {
        WelcomePage welcome = new WelcomePage(driver);
        ContactPage contact = welcome.clickOnContactUs();
        contact.fillEmail("test@testmail.co.uk");
        contact.fillMessage("This is a test. Please do nothing");
        contact.clickSubmit();
        String errorText = contact.fetchErrorMessage();
        assertThat(errorText, is(equalTo("Please select a subject from the list provided.")));
    }

    @Test
    public void createNewUserTest() throws InterruptedException {
        WelcomePage welcome = new WelcomePage(driver);
        LoginPage login = welcome.clickSignInButton();
        login.fillEmailCreate("sag@ich.net");
        login.clickCreateButton();
        RegistrationPage reg = new RegistrationPage(driver);
        reg.clickGenderMale();
        reg.fillCustomerFirstname("Alex");
        /**
         * As a new customer I want to register as a new user
         *
         * AC:
         * I can register a new user
         */
    }

    @Test
    public void buyABlouseTest() {
        /**
         * As a registered user I want to olace an order for a blouse
         *
         * AC:
         * I can place my order
         * Order is shown on my order list
         */
    }

    @Test
    public void addToWishlistTest() {
        /**
         * As a registered user I want to add a dress to my wishlist
         *
         * AC:
         * I can add things to my wishlists
         * A click on View in my wishlist redirects to the product
         */
    }

    @Test
    public void removeFromWishlistTest() {
        /**
         * As a registered user I want to delete things from my wishlist
         *
         * AC:
         * I can remove things from my wishlist by clicking on delete
         */
    }
}
