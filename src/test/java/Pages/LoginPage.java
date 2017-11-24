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

    @FindBy(xpath = "//div[@class='alert alert-danger']//ol//li")
    private WebElement errorBox;

    @FindBy(id = "email_create")
    private WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    private WebElement createButton;

    public LoginPage(WebDriver driver) {
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

    public void fillEmailCreate(String username){ emailCreate.sendKeys(username);}

    public void clickCreateButton(){
        createButton.click();

    }
}
