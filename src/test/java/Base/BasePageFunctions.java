package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePageFunctions {
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
        }
        catch(Exception e){
            System.out.println("The following element not found!");
            e.printStackTrace();
        }
        return findElement;
    }
    public void isDisplayed(By locator){
        try {
            getWebElement(locator).isDisplayed();
        } catch (Exception e) {
            System.out.println("The following element not found in order to check if Displayed!");
            e.printStackTrace();
        }
    }

    public void clickElement(By locator){
        try {
            getWebElement(locator).click();
        } catch (Exception e) {
            System.out.println("The following element not found in order to be clicked!");
            e.printStackTrace();
        }
    }

    public void sendKeysToElement(By locator, String text){
        try {
            getWebElement(locator).sendKeys(text);
        } catch (Exception e) {
            System.out.println("The following element not found in order to Send Keys!");
            e.printStackTrace();
        }

    }
    private WebElement getWebElement(By locator){
        return  driver.findElement(locator);
    }

}
