package homepage;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.LandingPage;
import pageObject.LoginPage;

import java.io.IOException;


public class HomepageTest extends Base {
// TODO: adding logs
// TODO: Generating html reports
// TODO: Screenshots on failure
// TODO: Jenkins integrations.

    WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = super.initializeDriver();
        log.info("Driver is initialized");
        log.info("Navigate to homepage");
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String username, String password){

        driver.get(prop.getProperty("url"));
        LandingPage lp = new LandingPage(driver);
        lp.getLoginButton().click();

        LoginPage loginP = new LoginPage(driver);
        loginP.getEmailInput().sendKeys(username);
        loginP.getPasswordInput().sendKeys(password);
        loginP.getLoginButton().click();
        log.info("Successfully validated Text Message");

//        driver.quit();
    }

    @Test
    public void validateTitle(){
        driver.get(prop.getProperty("url"));
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
        log.info("Homepage Test Complete");
        driver.quit();
    }


}
