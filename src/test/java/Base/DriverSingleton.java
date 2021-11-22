package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver driver = null;

    public static WebDriver getDriverInstance() throws Exception{
        if(driver == null){
            String driverType = ReadXML.getData("browserType");
            switch (driverType){
                case "Chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yelena\\Downloads\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
                case "Firefox":
                System.setProperty("webdriver.firefox.driver", "C:\\Users\\Yelena\\Downloads\\geckodriver\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

}
