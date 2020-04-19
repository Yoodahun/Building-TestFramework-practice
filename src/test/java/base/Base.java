package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    WebDriver driver;

    public WebDriver initializeDriver() throws IOException {
        //chrome
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/data.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/yoodahun/Documents/Github/Java/Selenium WebDriver with Java/chromedriver");
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {//firefox

        } else  {

        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @DataProvider
    public Object[][] getData() {
        //Row stands for how many different data types test should run
        Object[][] data = new Object[1][2];
        data[0][0] = "abc@gmail.com"; //email
        data[0][1] = "1234567"; //password
//        data[0][2] = "Restricted User";

//        data[1][0] = "restrocteduser@qw.com";
//        data[1][1] = "456789";
//        data[1][2] = "Non restricted User";

        return data;
    }

    @AfterSuite
    public void browserClose() {
        driver.quit();
    }
}
