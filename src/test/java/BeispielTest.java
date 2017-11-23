import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BeispielTest {

    @Test
    public void testTest(){
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.google.de");
        Assert.assertEquals(driver.getTitle(), "Google");

        driver.close();
    }

}
