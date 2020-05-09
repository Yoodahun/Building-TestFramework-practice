package cucumber;







import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

@CucumberOptions(
        features = "src/test/java/resource/features",
        glue = {"stepDefinitions", "base"}
)
public class TestRunner extends AbstractTestNGCucumberTests {



}
