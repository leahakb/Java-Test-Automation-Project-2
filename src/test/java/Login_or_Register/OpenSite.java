package Login_or_Register;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OpenSite {
    private WebDriver driver;

    public OpenSite(WebDriver driver){
        this.driver = driver;
    }
    public void OpenWebsite(){
        SingletonBrowser browser1 = SingletonBrowser.getInstaceOfSingletonBrowser();
        driver = browser1.getDriver();
        driver.get("https://buyme.co.il/");
    }



}
