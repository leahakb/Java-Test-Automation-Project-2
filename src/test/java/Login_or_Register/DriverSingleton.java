package Login_or_Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {
    private static DriverSingleton instanceOfDriver = null;
    private static WebDriver driver;

    //Constructor
    private DriverSingleton(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yelena\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static DriverSingleton getDriverInstance(){
        if(instanceOfDriver == null){
            instanceOfDriver = new DriverSingleton();
        }
        return instanceOfDriver;
    }

    //get driver
    public WebDriver getDriver(){
        return driver;
    }
}
