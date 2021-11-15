package Login_or_Register;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OpenSite {
    private WebDriver driver;

    public OpenSite(WebDriver driver){
        this.driver = DriverSingleton.getDriverInstance();
    }
    public void OpenWebsite(){
        driver.get("https://buyme.co.il/");
    }



}
