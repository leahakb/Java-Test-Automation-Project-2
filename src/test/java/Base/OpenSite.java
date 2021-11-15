package Base;
import org.openqa.selenium.WebDriver;


public class OpenSite {
    private WebDriver driver;

    public OpenSite(WebDriver driver){
        this.driver = DriverSingleton.getDriverInstance();
    }
    public void OpenWebsite(){
        driver.get("https://buyme.co.il/");
    }



}
