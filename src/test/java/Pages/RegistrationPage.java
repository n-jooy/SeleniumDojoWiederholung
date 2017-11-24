package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    @FindBy(id = "id_gender1")
    private WebElement genderMale;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstname;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastname;

    @FindBy(id = "passwd")
    private WebElement passwd;

    @FindBy(id = "firstname")
    private WebElement addressFirstname;

    @FindBy(id = "lastname")
    private WebElement addressLastname;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement costcode;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "phone_mobile")
    private WebElement phoneMobil;

    @FindBy(id = "alias")
    private WebElement aliasMyAddress;

    @FindBy(id = "submitAccount")
    private WebElement submitAccountButton;

// Constructor:
    public RegistrationPage(WebDriver driver) throws InterruptedException {
        PageFactory.initElements(driver, this);
        Thread.sleep(5000);}

    public void clickGenderMale() {genderMale.click();}

    public void fillCustomerFirstname(String cFirstname) {customerFirstname.sendKeys(cFirstname);}

    public void fillCustomerLastname(String cLastname) {customerLastname.sendKeys(cLastname);}
}
