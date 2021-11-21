package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePageFunctions {
    private WebDriver driver;
    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;

    public BasePageFunctions(WebDriver driver) throws Exception{
        this.driver = DriverSingleton.getDriverInstance();
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\src\\main\\resources\\extent.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("MyFirstTest", "Sample description");

        // log results
        test.log(Status.INFO, "@Test");
    }

    public void popup() throws Exception{
        this.driver = DriverSingleton.getDriverInstance();
        //popup to login or register
        WebElement enter_link = getWebElement(By.className("seperator-link"));
        Actions enter_action = new Actions(driver);
        enter_action.moveToElement(enter_link).click().perform();
    }

    public WebElement findElement(By locator){
        WebElement findElement = null;

        try {
            findElement = getWebElement(locator);
            test.log(Status.PASS, "Element found successfully");
        }
        catch(Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "Element was not found." + e.getMessage());
        }
        return findElement;
    }
    public void isDisplayed(By locator){
        try {
            getWebElement(locator).isDisplayed();
            test.log(Status.PASS, "Element found successfully and isDisplayed is applied");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element was not found. isDisplayed Failed" + e.getMessage());
        }
    }

    public void clickElement(By locator){
        try {
            getWebElement(locator).click();
            test.log(Status.PASS, "Element found successfully and .click() was applied");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element was not found. click Failed" + e.getMessage());
        }
    }

    public void sendKeysToElement(By locator, String text){
        try {
            getWebElement(locator).sendKeys(text);
            test.log(Status.PASS, "Element found successfully and .sendKeys() was applied.");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element was not found. sendKeys Failed" + e.getMessage());
        }

    }
    private WebElement getWebElement(By locator){
        return  driver.findElement(locator);
    }

}
