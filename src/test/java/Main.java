import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;

import Login_or_Register.*;


public class Main {
    private static WebDriverWait wait;
    private static WebDriver driver;

    @BeforeClass
    public static void openSite(){
        OpenSite assignDriver = new OpenSite(driver);
        assignDriver.OpenWebsite();
        wait = new WebDriverWait(DriverSingleton.getDriverInstance().getDriver(), 10);
    }
    @Test
    private void toRegister() {
        //popup to login or register

        Register process = new Register();
        process.toRegister();
        //wait for the "to register" link element to be availabe. Popup needs time to get loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.register-or-login > span")));
        process.Registration();
    }

    @Test
    public void toLogin(){
//        Login login = new Login();
//        login.toLogin();
//        login.clickEnter();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=email]")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[gtm='כניסה ל-BUYME']")));
//        login.Enter();
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