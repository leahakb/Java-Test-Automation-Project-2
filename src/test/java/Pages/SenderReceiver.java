package Pages;

import Base.BasePageFunctions;
import Base.Constants;
import Base.DriverSingleton;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SenderReceiver extends BasePageFunctions {
    private static WebDriverWait wait;
    private static WebDriver driver;

    public SenderReceiver(WebDriver driver) throws Exception{
        super(driver);
        wait = new WebDriverWait(driver, 10);
    }
    public void processSenderReceiver() throws Exception{
        driver = DriverSingleton.getDriverInstance();
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
    }
    private void enterName(){
        String find_receiver = "label#friendName>input";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(find_receiver)));
        //to clear the autofill if any exists in browser
        findElement(By.cssSelector(find_receiver)).clear();
        sendKeysToElement(By.cssSelector(find_receiver), Constants.friendName);
        //Asserting Sender Name field
        String actual_entered_reciever = findElement(By.cssSelector(find_receiver)).getAttribute("value");
        Assert.assertEquals(Constants.friendName, actual_entered_reciever);
    }
    private void selectEvent(){
        String eventOptionLocator="//span[contains(text(),'יום הולדת')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(eventOptionLocator)));
        clickElement(By.xpath(eventOptionLocator));
    }
    private void writeBlessing(){
        //clear placeholder text
        findElement(By.cssSelector("textarea")).clear();
        //enter new text
        sendKeysToElement(By.cssSelector("textarea"),Constants.blessings);
    }
    private void uploadPicture(){
        //clickElement(By.cssSelector("label.bm-media-upload"));
        findElement(By.cssSelector("label.bm-media-upload>input")).sendKeys("C:\\Users\\Yelena\\Downloads\\test.png");
    }
    private void pressContinue(){
        clickElement(By.cssSelector("button[gtm='המשך']"));
    }
    private void pressNow(){
        //Wait added for the JS (1->2 progress) function that needs to be completed for the page to be ready
        try
        {
            Thread.sleep(1000); // Sleep the current thread for 1 second
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.progress.complete")));
    }
    private void pickEmailOrSMS(){
        clickElement(By.cssSelector("svg[gtm='method-sms']"));
    }
    private void enterEmailOrSMS(){
        findElement(By.cssSelector("input#sms")).clear();
        sendKeysToElement(By.cssSelector("input#sms"),Constants.phone);
    }
    private void enterSenderName(){
        //scroll down to the filed visibility
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        findElement(By.cssSelector("input[placeholder='שם שולח המתנה']")).clear();
        sendKeysToElement(By.cssSelector("input[placeholder='שם שולח המתנה']"),Constants.senderName);
        //Asserting Sender Name field
        String actual_entered_sender= findElement(By.cssSelector("input[placeholder='שם שולח המתנה']")).getAttribute("value");
        Assert.assertEquals(Constants.senderName, actual_entered_sender);

        findElement(By.cssSelector("input[placeholder='מספר נייד']")).clear();
        sendKeysToElement(By.cssSelector("input[placeholder='מספר נייד']"),Constants.senderPhone);
    }
    private void pressContinue2(){
        clickElement(By.cssSelector("button[gtm='המשך לתשלום']"));
    }
}
