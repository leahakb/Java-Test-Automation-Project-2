package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent = null;

    public static ExtentReports getInstance() throws Exception{
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\src\\main\\resources\\extent.html");
        String timeNow = String.valueOf(System.currentTimeMillis());
        if (extent == null) {
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }

}
