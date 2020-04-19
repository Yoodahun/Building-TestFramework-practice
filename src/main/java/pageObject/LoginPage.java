package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"user_email\"]")
    WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"user_password\"]")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"new_user\"]/div[4]/input")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
}
