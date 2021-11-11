import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        SingletonBrowser browser1 = SingletonBrowser.getInstaceOfSingletonBrowser();
        WebDriver driver = browser1.getDriver();
        driver.get("https://buyme.co.il/");
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