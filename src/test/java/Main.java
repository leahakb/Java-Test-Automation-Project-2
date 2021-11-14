import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        //wait = new WebDriverWait(driver, 10);
    }
    @Test
    private void toRegister() {
        //popup to login or register
        Register register = new Register(driver);
        register.toRegister();
    }

    @Test
    public void toLogin(){
        Login login = new Login(driver);
        login.clickEnter();
        login.Enter();

//        notLoggedIn = driver.findElement(By.className("seperator-link")).isDisplayed();
//        if(!notLoggedIn)
//            System.out.println("You are already logged in");
//        else{
//            //popup to login or register
//            driver.findElement(By.className("seperator-link")).click();
//
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[gtm='כניסה ל-BUYME']")));
//            WebElement login = driver.findElement(By.cssSelector("button[type=submit]"));
//            Actions login_aciton = new Actions(driver);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=email]")));
//            driver.findElement(By.cssSelector("input[type=email]")).sendKeys(Constants.email);
//            driver.findElement(By.cssSelector("input[type=password]")).sendKeys(Constants.pass);
//
//            login_aciton.moveToElement(login).click().perform();
//        }
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