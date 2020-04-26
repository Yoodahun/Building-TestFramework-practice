package base;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;


public class Base {


    public static Logger log;

    public static WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {
        //chrome
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/data.properties");
        prop.load(fis);

        //mvn test -Dbrowser=chrome

//        String browserName = prop.getProperty("browser");
        String browserName = System.getProperty("browser");
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
        Object[][] data = new Object[2][2];
        data[0][0] = "abc@gmail.com"; //email
        data[0][1] = "1234567"; //password
//        data[0][2] = "Restricted User";

        data[1][0] = "restrocteduser@qw.com";
        data[1][1] = "456789";
//        data[1][2] = "Non restricted User";

        return data;
    }


    public void getScreenshot(ITestResult result) throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("./Screenshot/"+ result.getName()+".jpg"));
    }


}
