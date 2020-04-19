package homepage;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LandingPage;

import java.io.IOException;

public class ValidateNavigationbarTest extends Base {

    WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = super.initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void validateTitle(){
        LandingPage lp = new LandingPage(driver);
        Assert.assertTrue(lp.getContactMenu().isDisplayed());

    }
    @AfterTest
    public void browserClose() {
        driver.quit();
    }
}
