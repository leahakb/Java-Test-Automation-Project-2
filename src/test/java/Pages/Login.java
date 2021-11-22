package Pages;

import Base.BasePageFunctions;
import Base.Constants;
import Base.DriverSingleton;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Login extends BasePageFunctions {
    private WebDriverWait wait;
    private static WebDriver driver;

    public Login(WebDriver driver) throws Exception{
        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    public void processLogin() throws Exception{
        driver = DriverSingleton.getDriverInstance();
        openPopup();
        enterCredentials();
    }

    private void openPopup(){

            //open popup to login or register
        try {
            BasePageFunctions enter = new BasePageFunctions(driver);
            enter.popup();
        } catch (Exception e) {
            System.out.println("You are either logged in or something went wrong! Log out and try agian.");
        }

    }
    private void enterCredentials(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[gtm='כניסה ל-BUYME']")));
        WebElement login = findElement(By.cssSelector("button[type=submit]"));
        Actions login_aciton = new Actions(driver);

        String find_email = "input[type=email]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(find_email)));
        sendKeysToElement(By.cssSelector(find_email), Constants.email);
        //Asserting Email field
        String actual_entered_email = findElement(By.cssSelector(find_email)).getAttribute("value");
        Assert.assertEquals(Constants.email, actual_entered_email);

        String find_pass="input[type=password]";
        sendKeysToElement(By.cssSelector(find_pass), Constants.pass);
        //Asserting Password field
        String actual_entered_pass = findElement(By.cssSelector(find_pass)).getAttribute("value");
        Assert.assertEquals(Constants.pass, actual_entered_pass);

        login_aciton.moveToElement(login).click().perform();
    }
}
