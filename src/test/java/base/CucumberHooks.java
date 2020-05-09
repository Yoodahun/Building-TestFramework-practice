package base;




import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class CucumberHooks {

    Base base = new Base();
    Scenario scenario;

 @Before
    public void beforeScenario(Scenario scenario){
        this.scenario = scenario;
        System.out.println("This will run before the Scenario");
    }

 @After
    public void afterScenario(Scenario scenario) throws IOException {
        base.getScreenshot(scenario);
    }
}

