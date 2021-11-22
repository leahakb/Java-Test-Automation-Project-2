package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Report {
    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;
    String timeNow = String.valueOf(System.currentTimeMillis());

    public Report(){
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\src\\main\\resources\\extent.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("MyFirstTest", "Sample description");
        String timeNow = String.valueOf(System.currentTimeMillis());
        // log results
        test.log(Status.INFO, "@Test");
    }
    public void testLogPass(){
        test.log(Status.PASS, "Element found successfully");
    }
    public void testLogFail(){
        test.log(Status.FAIL, "Element was not found.");
    }
    public void testInfo(){
        try {
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
        catch (Exception e){
            e.printStackTrace();
        }
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
    public void testEnd(){
        extent.flush();
    }

}
