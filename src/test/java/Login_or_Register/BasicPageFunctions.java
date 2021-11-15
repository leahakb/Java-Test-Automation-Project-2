package Login_or_Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasicPageFunctions {
    private WebDriver driver;

    public BasicPageFunctions(WebDriver driver){
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void popup(){
        this.driver = DriverSingleton.getDriverInstance();
        //popup to login or register
        WebElement enter_link = driver.findElement(By.className("seperator-link"));
        Actions enter_action = new Actions(driver);
        enter_action.moveToElement(enter_link).click().perform();
    }


}
