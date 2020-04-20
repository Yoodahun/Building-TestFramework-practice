package homepage;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.LandingPage;

import java.io.IOException;

public class ValidateNavigationbarTest extends Base {

    WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = super.initializeDriver();
        driver.get(prop.getProperty("url"));
        log.info("Driver is initialized");
    }

    @Test
    public void validateTitle(){
        LandingPage lp = new LandingPage(driver);
        Assert.assertTrue(lp.getContactMenu().isDisplayed());
        log.info("Navigationbar is displayed");

    }
    @AfterTest
    public void browserClose() {
        log.info("NavigationBar Test Complete");
        driver.quit();
    }
}
