package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DriverSingleton {

    private static WebDriver driver = null;

    public static WebDriver getDriverInstance() throws Exception{
        if(driver == null){
            String driverType = ReadXML.getData("browserType");
            switch (driverType){
                case "Chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yelena\\Downloads\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
                case "Firefox":
                System.setProperty("webdriver.firefox.driver", "C:\\Users\\Yelena\\Downloads\\geckodriver\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
            driver.manage().window().maximize();
        }
        return driver;
    }
//    private static String getData (String keyName) throws Exception{
//        ClassLoader classLoader = DriverSingleton.class.getClassLoader();
//        String file_path = "C:\\Users\\Yelena\\IdeaProjects\\Automation Java Project 2 - Buyme site\\src\\main\\resources\\data.xml";
//        File fXmlFile = new File(file_path);
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//        Document doc = dBuilder.parse(fXmlFile);
//        doc.getDocumentElement().normalize();
//
//        return doc.getElementsByTagName(keyName).item(0).getTextContent();
//    }

}
