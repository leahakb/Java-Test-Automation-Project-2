package Login_or_Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login{
    private boolean notLoggedIn = true;
    private WebDriver driver;
    private WebDriverWait wait;

    public Login(WebDriver driver){
        this.driver = SingletonBrowser.getInstaceOfSingletonBrowser();
        //wait = new WebDriverWait(driver, 10);
    }

    public void clickEnter(){
        notLoggedIn = driver.findElement(By.className("seperator-link")).isDisplayed();
        if(!notLoggedIn)
            System.out.println("You are already logged in");
        else{
            //popup to login or register
            driver.findElement(By.className("seperator-link")).click();

        }

    }
    public void Enter(){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[gtm='כניסה ל-BUYME']")));
        WebElement login = driver.findElement(By.cssSelector("button[type=submit]"));
        Actions login_aciton = new Actions(driver);
       //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=email]")));
        driver.findElement(By.cssSelector("input[type=email]")).sendKeys(Constants.email);
        driver.findElement(By.cssSelector("input[type=password]")).sendKeys(Constants.pass);

        login_aciton.moveToElement(login).click().perform();

    }
}
