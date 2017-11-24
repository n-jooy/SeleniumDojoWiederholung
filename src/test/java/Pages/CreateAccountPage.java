package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    @FindBy(xpath = "//*[@id=\"noSlide\"]/h1")
    private WebElement headline;

    @FindBy(id = "id_gender1")
    private WebElement maleRadioButton;

    @FindBy(id = "uniform-id_gender2")
    private WebElement femaleRadioButton;

    @FindBy(id = "customer_firstname")
    private WebElement firstnameCustomer;

    @FindBy(id = "customer_lastname")
    private WebElement lastnameCustomer;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "firstname")
    private WebElement firstname;

    @FindBy(id = "lastname")
    private WebElement lastname;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement id_state;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "id_country")
    private WebElement id_country;

    @FindBy(id = "phone_mobile")
    private WebElement phone_mobile;

    @FindBy(id = "alias")
    private WebElement alias;

    @FindBy(id = "submitAccount")
    private WebElement submitAccount;

    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getHeadline() {
        return headline;
    }

    public WebElement getMaleRadioButton() {
        return maleRadioButton;
    }

    public WebElement getFemaleRadioButton() {
        return femaleRadioButton;
    }

    public WebElement getFirstnameCustomer() {
        return firstnameCustomer;
    }

    public WebElement getLastnameCustomer() {
        return lastnameCustomer;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getFirstname() {
        return firstname;
    }

    public WebElement getLastname() {
        return lastname;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getId_state() {
        return id_state;
    }

    public WebElement getPostcode() {
        return postcode;
    }

    public WebElement getId_country() {
        return id_country;
    }

    public WebElement getPhone_mobile() {
        return phone_mobile;
    }

    public WebElement getAlias() {
        return alias;
    }

    public WebElement getSubmitAccount() {
        return submitAccount;
    }
}
