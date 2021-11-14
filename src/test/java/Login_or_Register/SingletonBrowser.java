package Login_or_Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonBrowser {
    //instance of singletone class
    private static SingletonBrowser instaceOfSingletonBrowser = null;

    private WebDriver driver;

    //Constructor
    private SingletonBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yelena\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    //instance of class
    public static SingletonBrowser getInstaceOfSingletonBrowser(){
        if(instaceOfSingletonBrowser == null){
            instaceOfSingletonBrowser = new SingletonBrowser();
        }
        return instaceOfSingletonBrowser;
    }

    //get driver
    public WebDriver getDriver(){
        return driver;
    }
}
