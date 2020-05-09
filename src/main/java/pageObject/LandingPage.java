package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage {

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/h2")
    WebElement featureCoursesText;

    @FindBy(xpath = "//*[@id=\"homepage\"]/header/div[2]/div/nav/ul/li[8]/a")
    WebElement contactMenu;

    @FindBy(xpath = "//button[text()='NO THANKS']")
    List<WebElement> popups;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getFeatureCoursesText() {
        return featureCoursesText;
    }

    public WebElement getContactMenu() {
        return contactMenu;
    }

    public List<WebElement> getPopup() {
        return popups;
    }
}
