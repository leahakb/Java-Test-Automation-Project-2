package Base;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class BasePageFunctions extends Report{
    private WebDriver driver;


    public BasePageFunctions(WebDriver driver) throws Exception{
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void popup() throws Exception{
        this.driver = DriverSingleton.getDriverInstance();
        //popup to login or register
        WebElement enter_link = getWebElement(By.className("seperator-link"));
        Actions enter_action = new Actions(driver);
        enter_action.moveToElement(enter_link).click().perform();
    }

    public WebElement findElement(By locator){
        WebElement findElement = null;

        try {
            findElement = getWebElement(locator);
            testLogPass();
        }
        catch(Exception e){
            e.printStackTrace();
            testInfo();
            testLogFail();
            System.out.println(e.getMessage());
        }
        return findElement;
    }
    public void isDisplayed(By locator){
        try {
            getWebElement(locator).isDisplayed();
            testLogPass();
        } catch (Exception e) {
            e.printStackTrace();
            testInfo();
            testLogFail();
            System.out.println(e.getMessage());
        }
    }

    public void clickElement(By locator){
        try {
            getWebElement(locator).click();
            testLogPass();
        } catch (Exception e) {
            e.printStackTrace();
            testInfo();
            testLogFail();
            System.out.println(e.getMessage());
        }
    }

    public void sendKeysToElement(By locator, String text){
        try {
            getWebElement(locator).sendKeys(text);
            testLogPass();
        } catch (Exception e) {
            e.printStackTrace();
            testInfo();
            testLogFail();
            System.out.println(e.getMessage());
        }

    }
    private WebElement getWebElement(By locator){
        return  driver.findElement(locator);
    }
}
