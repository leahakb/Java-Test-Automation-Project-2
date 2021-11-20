package Pages;

import Base.BasePageFunctions;
import Base.Constants;
import Base.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=email]")));
        sendKeysToElement(By.cssSelector("input[type=email]"), Constants.email);
        sendKeysToElement(By.cssSelector("input[type=password]"), Constants.pass);

        login_aciton.moveToElement(login).click().perform();
    }
}
