import org.openqa.selenium.By;
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
    public static void openSite(){
        OpenSite assignDriver = new OpenSite(driver);
        assignDriver.OpenWebsite();
        driver =  DriverSingleton.getDriverInstance();
        //wait = new WebDriverWait(DriverSingleton.getDriverInstance(), 10);
    }
    @Test
    private void toRegister() {
        //click toRegister link in case the login has an error message
        Register register = new Register(driver);
        //open a popup if the lightbox is not opened
        if(driver.findElements(By.className("lightbox-title")).size() == 0)
            register.processRegistration();
    }

    @Test
    public void toLogin(){
        Login login = new Login(driver);
        login.processLogin();
    }
    @Test
    public void searchGift(){
        Search search = new Search(driver);
        search.processSearch();
    }
    @Test
    public void pickBusiness(){

    }
    @Test
    public void sendRecieveInfo(){

    }
    @AfterClass
    public void runAfterClass(){
        //driver.quit();
    }

}