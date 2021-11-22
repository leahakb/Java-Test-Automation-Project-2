package Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class OpenSite {
    private WebDriver driver;

    public OpenSite(WebDriver driver) throws Exception{
        this.driver = DriverSingleton.getDriverInstance();
    }
    public void OpenWebsite() throws Exception{
        String site_url = ReadXML.getData("URL");
        //assertion for the url
        Assert.assertEquals(Constants.URL, site_url);

        driver.get(site_url);
        //waits for the JavaScrip components to be completed
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("return document.readyState").toString().equals("complete");
    }

}
