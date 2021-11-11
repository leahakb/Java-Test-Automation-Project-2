import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Main {



    @BeforeClass
    public static void openSiteAndLogin(){
        SingletonBrowser browser1 = SingletonBrowser.getInstaceOfSingletonBrowser();
        WebDriver driver = browser1.getDriver();
        driver.get("https://buyme.co.il/");
        //login
        driver.findElement(By.linkText("Login"));
        driver.findElement(By.id(Constants.email_id)).sendKeys(Constants.email);
        driver.findElement(By.id(Constants.pass_id)).sendKeys(Constants.pass);
        driver.findElement(By.id(Constants.entrance_button_id)).click();
    }
    @Test
    public static void test_1()
    {

    }

    @AfterClass
    public static void runAfterClass(){
        //driver.quit();
    }

}