package Pages;

import Base.BasePageFunctions;
import Base.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class Business extends BasePageFunctions {
    private static WebDriverWait wait;
//    private static WebDriver driver = DriverSingleton.getDriverInstance();
    public Business(WebDriver driver) throws Exception{
        super(driver);
        wait = new WebDriverWait(driver, 10);
    }
    public void processPickBusiness(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.grid")));
        pickBusiness();
        enterAmount();
        Submit();
    }
    private void pickBusiness(){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("ul.grid/li/a")));
        clickElement(By.cssSelector("ul.grid>li>a"));
    }
    private void enterAmount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='הכנס סכום']")));
        sendKeysToElement((By.cssSelector("input[placeholder='הכנס סכום']")),"20");
    }
    private void Submit(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[gtm='בחירה']")));
        clickElement(By.cssSelector("button[gtm='בחירה']"));
    }
}
