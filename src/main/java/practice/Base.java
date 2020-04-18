package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public void initializeDriver() throws IOException {
        //chrome
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/data.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/yoodahun/Documents/Github/Java/Selenium WebDriver with Java/chromedriver");
            WebDriver driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {//firefox

        } else  {

        }

    }
}
