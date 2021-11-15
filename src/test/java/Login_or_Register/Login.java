package Login_or_Register;

import Base.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Login{
    private boolean notLoggedIn = true;
    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void Popup(){
        notLoggedIn = driver.findElement(By.className("seperator-link")).isDisplayed();
        if(!notLoggedIn)
            System.out.println("You are already logged in");
        else{
            //popup to login or register
            BasePageFunctions enter = new BasePageFunctions(driver);
            enter.popup();
        }

    }
    public void Enter(){
        WebElement login = driver.findElement(By.cssSelector("button[type=submit]"));
        Actions login_aciton = new Actions(driver);
        driver.findElement(By.cssSelector("input[type=email]")).sendKeys(Constants.email);
        driver.findElement(By.cssSelector("input[type=password]")).sendKeys(Constants.pass);

        login_aciton.moveToElement(login).click().perform();

    }
}
