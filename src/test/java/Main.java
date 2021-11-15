import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;

import Login_or_Register.*;
import Base.*;

public class Main {
    private static WebDriverWait wait;
    private static WebDriver driver;

    @BeforeClass
    public static void openSite(){
        OpenSite assignDriver = new OpenSite(driver);
        assignDriver.OpenWebsite();
        driver =  DriverSingleton.getDriverInstance();
        wait = new WebDriverWait(DriverSingleton.getDriverInstance(), 10);
    }
    @Test
    private void toRegister() {
        //click toRegister link in case the login has an error message

        if (driver.findElements(By.className("login-error")).size() !=0) {
            Register process = new Register(driver);
            //wait for the "toRegister" link element to be available. Popup needs time to get loaded
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.register-or-login > span")));
            process.Registration();
        }
    }

    @Test
    public void toLogin(){
        Login login = new Login(driver);
        login.Popup();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=email]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[gtm='כניסה ל-BUYME']")));
        login.Enter();
    }
    @Test
    public void searchGift(){

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