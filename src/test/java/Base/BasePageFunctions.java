package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePageFunctions {
    private WebDriver driver;

    public BasePageFunctions(WebDriver driver){
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void popup(){
        this.driver = DriverSingleton.getDriverInstance();
        //popup to login or register
        WebElement enter_link = getWebElement(By.className("seperator-link"));
        Actions enter_action = new Actions(driver);
        enter_action.moveToElement(enter_link).click().perform();
    }

    public WebElement findElement(By locator){
        return getWebElement(locator);
    }
    public void isDisplayed(By locator){
        getWebElement(locator).isDisplayed();
    }

    public void clickElement(By locator){
        getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text){
        getWebElement(locator).sendKeys(text);
    }
    private WebElement getWebElement(By locator){
        return  driver.findElement(locator);
    }

//    public void getSize(By locator){
//        getWebElements(locator);
//    }
//    private WebElement getWebElements(By locator){
//        return  driver.findElements(locator);
//    }

}
