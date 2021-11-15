package Login_or_Register;

import Base.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {
    private WebDriver driver;
    private static WebDriverWait wait;

    public Register(WebDriver driver){
        this.driver = DriverSingleton.getDriverInstance();
        wait = new WebDriverWait(DriverSingleton.getDriverInstance(), 10);
    }
    public void Popup() {
        //popup to login or register
        BasePageFunctions enter = new BasePageFunctions(driver);
        enter.popup();
    }

    public void Registration() {
        //if (!alreadyRegistered) {
        //wait for the "toRegister" link element to be available. Popup needs time to get loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.register-or-login > span")));
        driver.findElement(By.cssSelector("div.register-or-login > span")).click();

        driver.findElement(By.cssSelector("input[placeholder='שם פרטי']")).sendKeys(Constants.firstName);
        driver.findElement(By.cssSelector("input[placeholder='מייל']")).sendKeys(Constants.email);
        driver.findElement(By.id("valPass")).sendKeys(Constants.pass);
        driver.findElement(By.cssSelector("input[placeholder='אימות סיסמה']")).sendKeys(Constants.pass);
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        if (driver.findElements(By.className("login-error")).size() != 0) {
            driver.findElement(By.className("lightbox-close")).click();
        }
    }
   // }
}
