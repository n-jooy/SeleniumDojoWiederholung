import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WorkshopTest {

    private ChromeDriver driver;

    @BeforeClass
    public static void setupWebDriverManager(){
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeMethod
    public void initTest(){
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
    }

    @AfterMethod
    public void tearDownTest() {
        driver.quit();
    }

    @Test
    public void createNewUserTest(){
        /**
         * As a new customer I want to register as a new user
         *
         * AC:
         * I can register a new user
         */
    }

    @Test
    public void buyABlouseTest(){
        /**
         * As a registered user I want to olace an order for a blouse
         *
         * AC:
         * I can place my order
         * Order is shown on my order list
         */
    }

    @Test
    public void addToWishlistTest(){
        /**
         * As a registered user I want to add a dress to my wishlist
         *
         * AC:
         * I can add things to my wishlists
         * A click on View in my wishlist redirects to the product
         */
    }

    @Test
    public void removeFromWishlistTest(){
        /**
         * As a registered user I want to delete things from my wishlist
         *
         * AC:
         * I can remove things from my wishlist by clicking on delete
         */
    }

    @Test
    public void searchInCatalogTest(){
        /**
         * As a customer I want to search for products with the catalog search filter. I expect that when I search
         *
         * AC:
         * Searching for a certain color displays only products with that color available
         */
    }

}
