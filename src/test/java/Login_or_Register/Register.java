package Login_or_Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {
    private boolean alreadyRegistered = true;
    private WebDriver driver;

    public Register(WebDriver driver){
        this.driver = DriverSingleton.getDriverInstance();
    }
    public void Popup() {
        //popup to login or register
        BasicPageFunctions enter = new BasicPageFunctions(driver);
        enter.popup();
    }

    public void Registration() {
        //if (!alreadyRegistered) {

            driver.findElement(By.cssSelector("div.register-or-login > span")).click();

            driver.findElement(By.cssSelector("input[placeholder='שם פרטי']")).sendKeys(Login_or_Register.Constants.firstName);
            driver.findElement(By.cssSelector("input[placeholder='מייל']")).sendKeys(Login_or_Register.Constants.email);
            driver.findElement(By.id("valPass")).sendKeys(Login_or_Register.Constants.pass);
            driver.findElement(By.cssSelector("input[placeholder='אימות סיסמה']")).sendKeys(Login_or_Register.Constants.pass);
            driver.findElement(By.cssSelector("button[type=submit]")).click();

            alreadyRegistered = driver.findElement(By.className("login-error")).isDisplayed();
            if (alreadyRegistered) {
                driver.findElement(By.className("lightbox-close")).click();

            }
        }
   // }
}
