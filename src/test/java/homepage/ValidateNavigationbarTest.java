package homepage;

import base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.LandingPage;

import java.io.IOException;

public class ValidateNavigationbarTest extends Base {

    public static Logger log = LogManager.getLogger(ValidateNavigationbarTest.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = super.initializeDriver();
        driver.get(prop.getProperty("url"));
        log.info("Driver is initialized");
    }

    @Test
    public void validateTitle(){
        LandingPage lp = new LandingPage(driver);
        Assert.assertFalse(lp.getContactMenu().isDisplayed());
        Assert.assertTrue(lp.getContactMenu().isDisplayed());
        log.info("Navigationbar is displayed");

    }
    @AfterTest
    public void browserClose() {
        log.info("NavigationBar Test Complete");
        driver.quit();
        driver = null;
    }
}
