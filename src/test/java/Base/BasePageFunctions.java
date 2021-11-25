package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;


public class BasePageFunctions extends Report{
    private WebDriver driver;
    private static ExtentTest test;
    protected static ExtentReports report;

    public BasePageFunctions(WebDriver driver) throws Exception{
        this.driver = DriverSingleton.getDriverInstance();
        this.report = Report.getInstance();
        this.test = Report.getInstance().createTest("ByMe Test", "This file report on the outcome after testing Buyme site");
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
//            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            try {
                test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            test.log(Status.FAIL, "Driver connecwaiting tion failed! " + e.getMessage());
        }
        return findElement;
    }
    public void isDisplayed(By locator){
        try {
            getWebElement(locator).isDisplayed();
            test.log(Status.PASS, "Element found successfully");
        } catch (Exception e) {
//            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            try {
                test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            test.log(Status.FAIL, "Driver connection failed! " + e.getMessage());
        }
    }
    public void clickElement(By locator){
        try {
            getWebElement(locator).click();
            test.log(Status.PASS, "Element found successfully");
        } catch (Exception e) {
//            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            try {
                test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            test.log(Status.FAIL, "Driver connection failed! " + e.getMessage());
        }
    }
    public void sendKeysToElement(By locator, String text){
        try {
            getWebElement(locator).sendKeys(text);
            test.log(Status.PASS, "Element found successfully");
        } catch (Exception e) {
//            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            try {
                test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            test.log(Status.FAIL, "Driver connection failed! " + e.getMessage());
        }

    }
    private WebElement getWebElement(By locator){
        return  driver.findElement(locator);
    }

    private static String takeScreenShot(String ImagesPath) throws Exception{
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverSingleton.getDriverInstance();
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ImagesPath + ".png";
    }
}
