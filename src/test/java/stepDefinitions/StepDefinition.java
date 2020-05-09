package stepDefinitions;


import base.Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.LoginPage;

import java.io.IOException;

public class StepDefinition extends Base {



    public static Logger log = LogManager.getLogger(StepDefinition.class.getName());
    LandingPage lp;
    LoginPage loginP;

//    private Scenario myScenario;
//
//    @Before()
//    public void embedScreenshotStep(Scenario scenario) {
//
//        this.myScenario = scenario;
//
//    }


    @Given("Initialize the browser with chrome")
    public void initialize_the_browser_with_chrome() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        driver = super.initializeDriver();
        log.info("Driver is initialized");
        log.info("Navigate to homepage");

    }

    @Test
    @Given("Navigate to {string} Site")
    public void navigate_to_Site(String url) {
        driver.get(prop.getProperty(url));


    }

    @Given("Click on Login link in homepage to land on sign-on in Page")
    public void click_on_Login_link_in_homepage_to_land_on_sign_on_in_Page() {

        lp = new LandingPage(driver);

        if(lp.getPopup().size() > 0) {
            lp.getPopup().get(0).click();
        }
        lp.getLoginButton().click();


    }

    @When("User enters {string} and {string} and logs in")
    public void userEntersUsernameAndPasswordAndLogsIn(String username, String password) {
        loginP = new LoginPage(driver);
        loginP.getEmailInput().sendKeys(username);
        loginP.getPasswordInput().sendKeys(password);
        loginP.getLoginButton().click();

    }
    @Then("Verify that user is not logged in")
    public void verify_that_user_is_succesfully_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertFalse(loginP.getInvalidErrorBox().isDisplayed());


    }
    @And("Close browser")
    public void closeBrowser() {
        driver.quit();
    }

//    @After
//    public void afterScenario(Scenario scenario) throws IOException {
//        getScreenshot(scenario);
//    }


}
