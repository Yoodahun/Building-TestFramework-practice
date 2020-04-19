package homepage;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.LandingPage;
import pageObject.LoginPage;

import java.io.IOException;


public class HomepageTest extends Base {

    WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = super.initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String username, String password){
        LandingPage lp = new LandingPage(driver);
        lp.getLoginButton().click();

        LoginPage loginP = new LoginPage(driver);
        loginP.getEmailInput().sendKeys(username);
        loginP.getPasswordInput().sendKeys(password);
        loginP.getLoginButton().click();

//        driver.quit();
    }

    @Test
    public void validateTitle(){
        LandingPage lp = new LandingPage(driver);

        //compare the text from the browser with actual text - Error
        Assert.assertEquals(
                lp.getFeatureCoursesText().getText(),
                "FEATURED COURSES"
        );
        Assert.assertTrue(lp.getContactMenu().isDisplayed()

        );


    }

    @AfterTest
    public void browserClose() {
        driver.quit();
    }


}
