package Login_or_Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Register {
    private boolean alreadyRegistered = true;
    public void toRegister(WebDriver driver) {
        if (!alreadyRegistered) {
            driver.findElement(By.className("seperator-link")).click();
            //wait for the "to register" link element to be availabe. Popup needs time to get loaded
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.register-or-login > span")));

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
    }
}
