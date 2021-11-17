package Pages;

import Base.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Search extends BasePageFunctions {
    private static WebDriverWait wait;
    private static WebDriver driver =DriverSingleton.getDriverInstance();

    public Search(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver, 10);
    }
    public void processSearch(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.ui-lightbox")));
        //checkIfLoggedin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='סכום']")));
        selectPrice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='אזור']")));
        selectRegion();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='קטגוריה']")));
        selectCategory();
        SubmitSearch();
    }
    private void checkIfLoggedin(){
        int loggedin = driver.findElements(By.cssSelector("span[contains(text(), 'החשבון שלי')]")).size();
        System.out.println(loggedin);
        //in case the user is not logged in process Login
        if(loggedin == 0){
            Login login = new Login(driver);
            login.processLogin();
        }
    }
    private void selectPrice(){
        clickElement(By.xpath("//span[text()='סכום']"));
        String priceOptionLocator="//li[contains(text(),'עד 99')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(priceOptionLocator)));
        clickElement(By.xpath(priceOptionLocator));
    }
    private void selectRegion(){
        clickElement(By.xpath("//span[text()='אזור']"));
        String regionOptionLocator="//li[contains(text(),'צפון')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(regionOptionLocator)));
        clickElement(By.xpath(regionOptionLocator));
    }
    private void selectCategory(){
        clickElement(By.xpath("//span[text()='קטגוריה']"));
        String categoryOptionLocator="//li[contains(text(),'גיפט קארד למסעדות')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(categoryOptionLocator)));
        clickElement(By.xpath(categoryOptionLocator));
    }
    private void SubmitSearch(){
        clickElement(By.className("search"));
    }
}
