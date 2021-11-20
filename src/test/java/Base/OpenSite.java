package Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class OpenSite {
    private WebDriver driver;

    public OpenSite(WebDriver driver) throws Exception{
        this.driver = DriverSingleton.getDriverInstance();
    }
    public void OpenWebsite(){
        driver.get("https://buyme.co.il/");
        //waits for the JavaScrip components to be completed
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("return document.readyState").toString().equals("complete");
    }



}
