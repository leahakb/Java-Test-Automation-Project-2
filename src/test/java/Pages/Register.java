package Pages;

import Base.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register extends BasePageFunctions {
    private static WebDriverWait wait;
    private static WebDriver driver = DriverSingleton.getDriverInstance();

    public Register(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver, 10);
    }
    public void processRegistration(){
        openPopup();
        Registration();
    }
    private void openPopup() {
        //popup to login or register
        BasePageFunctions enter = new BasePageFunctions(DriverSingleton.getDriverInstance());
        enter.popup();
    }

    private void Registration() {
        //if (!alreadyRegistered) {
        //wait for the "toRegister" link element to be available. Popup needs time to get loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.register-or-login > span")));
        clickElement(By.cssSelector("div.register-or-login > span"));

        sendKeysToElement(By.cssSelector("input[placeholder='שם פרטי']"),Constants.firstName);
        sendKeysToElement(By.cssSelector("input[placeholder='מייל']"),Constants.email);
        sendKeysToElement(By.id("valPass"),Constants.pass);
        sendKeysToElement(By.cssSelector("input[placeholder='אימות סיסמה']"),Constants.pass);
        clickElement(By.cssSelector("button[type=submit]"));

//        if (driver.findElements(By.className("login-error")).size() != 0) {
//            clickElement(By.className("lightbox-close"));
//        }
    }
}
