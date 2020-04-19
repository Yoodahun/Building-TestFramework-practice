package homepage;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.LoginPage;

import java.io.IOException;


public class HomepageTest extends Base {

    WebDriver driver;

    @Test(dataProvider = "getData")
    public void basePageNavigation(String username, String password) throws IOException {
        driver = super.initializeDriver();
        driver.get("http://qaclickacademy.com");

        LandingPage lp = new LandingPage(driver);
        lp.getLoginButton().click();

        LoginPage loginP = new LoginPage(driver);
        loginP.getEmailInput().sendKeys(username);
        loginP.getPasswordInput().sendKeys(password);
        loginP.getLoginButton().click();

//        driver.quit();
    }
}
