package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexanderhe on 07.07.17.
 */
public class LoginPage {

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    @FindBy(id = "email_create")
    private WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    private WebElement submitCreateButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']//ol//li")
    private WebElement errorBox;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillEmail(String username){
        email.sendKeys(username);
    }

    public void fillPassword(String pwd){
        password.sendKeys(pwd);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String fetchErrorMessage(){
        return errorBox.getText();
    }

    public void fillEmailCreate(String email) {
        emailCreate.sendKeys(email);
    }

    public CreateAccountPage submitCreateButton() {
        submitCreateButton.click();
        return new CreateAccountPage(driver);
    }
}
