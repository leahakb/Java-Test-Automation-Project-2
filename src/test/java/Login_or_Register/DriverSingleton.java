package Login_or_Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {
    private static SingletonBrowser getDriverInstance = null;
    private static WebDriver driver;

    public static DriverSingleton getDriverInstance(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        return getDriverInstance;
    }

    //get driver
    public WebDriver getDriver(){
        return driver;
    }
    }
}
