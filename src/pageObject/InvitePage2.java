package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvitePage2 extends BasePage {
    public InvitePage2(WebDriver driver)
    {
        super(driver);
    }

    private By smsButton  =  By.cssSelector("svg[gtm='method-sms']");
    private By smsReciveNumber = By.cssSelector("input[id='sms']");
    private By smsSenderNumber = By.cssSelector("input[placeholder='מספר נייד']");
    private By confirm=By.cssSelector("button[gtm='המשך לתשלום']");
    private By senderName=By.cssSelector("input[placeholder='שם שולח המתנה']");






public InvitePage2 smsReciveNumberText(String val)throws InterruptedException
    {    Thread.sleep(500);
        writeText(smsReciveNumber,val);
        return this;
    }
    public InvitePage2 senderNameText(String val)throws InterruptedException
    {    Thread.sleep(500);
        writeText(senderName,val);
        return this;
    }
    public InvitePage2 smsSenderNumberText(String val)throws InterruptedException
    {    Thread.sleep(500);
        writeText(smsSenderNumber,val);
        return this;
    }
    public InvitePage2 finalButtonClick() throws InterruptedException {
        click(confirm);
        return this;
    }

    public InvitePage2 smsButtonClick() throws InterruptedException {
        click(smsButton);
        return this;
    }




    public void choiceSms()  throws InterruptedException{smsButtonClick();}
    public void recievePhone(String val) throws InterruptedException {  smsReciveNumberText(val);  }
    public void senderPhone(String val) throws InterruptedException {  smsSenderNumberText(val);  }
    public void senderName(String val) throws InterruptedException {senderNameText(val);}
    public void finalButton()throws InterruptedException {finalButtonClick();}

}
