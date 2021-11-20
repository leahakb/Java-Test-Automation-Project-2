import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.*;
import Base.*;


public class Main {
   // private static WebDriverWait wait;
    private static WebDriver driver;

    @BeforeClass
    public static void openSite() throws Exception{
        OpenSite assignDriver = new OpenSite(driver);
        assignDriver.OpenWebsite();
        driver =  DriverSingleton.getDriverInstance();
    }
    @Test
    private void toRegister() throws Exception{
        //click toRegister link in case the login has an error message
        Register register = new Register(driver);
        //open a popup if the lightbox is not opened
//        if(driver.findElements(By.className("lightbox-title")).size() == 0)
//            register.processRegistration();
    }

    @Test(priority = 1)
    public void toLogin() throws Exception{
        Login login = new Login(driver);
        login.processLogin();
    }
    @Test(dependsOnMethods = {"toLogin"})
    public void searchGift() throws Exception{
        Search search = new Search(driver);
        search.processSearch();
    }
    @Test(dependsOnMethods = {"searchGift"})
    public void pickBusiness() throws Exception{
        Business pickBusness = new Business(driver);
        pickBusness.processPickBusiness();
    }
    @Test(dependsOnMethods = {"pickBusiness"})
    public void sendRecieveInfo() throws Exception{
        SenderReceiver sr = new SenderReceiver(driver);
        sr.processSenderReceiver();
    }
    @AfterClass
    public void runAfterClass(){
        //driver.quit();
    }

}