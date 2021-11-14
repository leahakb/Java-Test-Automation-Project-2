import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;


public class Main {
    private static WebDriverWait wait;
    private static WebDriver driver;
    private boolean alreadyRegistered = true;
    private boolean notLoggedIn = true;

    @BeforeClass
    public static void openSiteAndLogin(){
        SingletonBrowser browser1 = SingletonBrowser.getInstaceOfSingletonBrowser();
        driver = browser1.getDriver();
        driver.get("https://buyme.co.il/");
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    private void toRegister() {
        //popup to login or register
        if (!alreadyRegistered) {
            driver.findElement(By.className("seperator-link")).click();
            //wait for the "to register" link element to be availabe. Popup needs time to get loaded
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.register-or-login > span")));

            driver.findElement(By.cssSelector("div.register-or-login > span")).click();

            driver.findElement(By.cssSelector("input[placeholder='שם פרטי']")).sendKeys(Constants.firstName);
            driver.findElement(By.cssSelector("input[placeholder='מייל']")).sendKeys(Constants.email);
            driver.findElement(By.id("valPass")).sendKeys(Constants.pass);
            driver.findElement(By.cssSelector("input[placeholder='אימות סיסמה']")).sendKeys(Constants.pass);
            driver.findElement(By.cssSelector("button[type=submit]")).click();

            alreadyRegistered = driver.findElement(By.className("login-error")).isDisplayed();
            if (alreadyRegistered) {
                driver.findElement(By.className("lightbox-close")).click();

            }
        }
    }

    @Test
    public void toLogin(){
        notLoggedIn = driver.findElement(By.className("seperator-link")).isDisplayed();
        if(!notLoggedIn)
            System.out.println("You are already logged in");
        else{
            //popup to login or register
            driver.findElement(By.className("seperator-link")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[gtm='כניסה ל-BUYME']")));
            WebElement login = driver.findElement(By.cssSelector("button[type=submit]"));
            Actions login_aciton = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=email]")));
            driver.findElement(By.cssSelector("input[type=email]")).sendKeys(Constants.email);
            driver.findElement(By.cssSelector("input[type=password]")).sendKeys(Constants.pass);

            login_aciton.moveToElement(login).click().perform();
        }
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