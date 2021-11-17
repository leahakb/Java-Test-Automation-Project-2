package Pages;

import Base.BasePageFunctions;
import Base.Constants;
import Base.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SenderReceiver extends BasePageFunctions {
    private static WebDriverWait wait;
    private static WebDriver driver = DriverSingleton.getDriverInstance();

    public SenderReceiver(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);
    }
    public void processSenderReceiver(){
        enterName();
        selectEvent();
        writeBlessing();
        uploadPicture();
        pressContinue();
        pressNow();
        pickEmailOrSMS();
        enterEmailOrSMS();
        enterSenderName();
        pressContinue2();
        assertSenderReceiver();
    }
    private void enterName(){
        sendKeysToElement(By.cssSelector("label#friendName>input"), Constants.friendName);
    }
    private void selectEvent(){
        clickElement(By.xpath("//span[title='לאיזה אירוע?']"));
        String eventOptionLocator="//li[contains(text(),'יום הולדת')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(eventOptionLocator)));
        clickElement(By.xpath(eventOptionLocator));
    }
    private void writeBlessing(){
        sendKeysToElement(By.xpath("//span[//span[contains(text(), 'ברכה']]::textarea"),Constants.blessings);
    }
    private void uploadPicture(){

    }
    private void pressContinue(){

    }
    private void pressNow(){

    }
    private void pickEmailOrSMS(){

    }
    private void enterEmailOrSMS(){

    }
    private void enterSenderName(){

    }
    private void pressContinue2(){

    }
    private void assertSenderReceiver(){

    }
}
