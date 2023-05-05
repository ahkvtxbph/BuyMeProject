package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class InvitePage extends BasePage {
    public InvitePage(WebDriver driver)
    {
        super(driver);
    }

    private By otherRecipient  =  By.cssSelector("div[gtm='למישהו אחר']");
    private By recipient = By.cssSelector("input[data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']");
    private By blessingAera = By.cssSelector("textarea[data-parsley-group='voucher-greeting']");
    private By areaZone  =  By.cssSelector("span[title='לאיזה אירוע?']");
    private By areaList = By.cssSelector("li[value='11']");
    private By waitconfirm=By.cssSelector("div[class='bm-white-loading-screen fade-in']");
    private By confirm=By.cssSelector("button[gtm='המשך']");
    private By image = By.cssSelector("input[type='file']");
    private By receiverTitle = By.cssSelector("div.step.active div.label.bottom-xs");




public InvitePage recipientText(String val)throws InterruptedException
    { System.out.println(recipient+" RV "+val);
        writeText(recipient,val);
        return this;
    }

    public InvitePage blessingAeraText(String val)throws InterruptedException
    {
        writeText(blessingAera,val);
        return this;
    }

     public InvitePage otherRecipientClick() throws InterruptedException {
       if (!driver.findElement(otherRecipient).isSelected())
           click(otherRecipient);
          return this;
    }
    public InvitePage areaZoneClick() throws InterruptedException {
        if (driver.findElement(areaZone).isDisplayed())
        click(areaZone);
        return this;
    }

    public InvitePage areaListClick() throws InterruptedException {
        if (driver.findElement(areaZone).isDisplayed())
        click(areaList);
        return this;
    }

    public InvitePage confirmClick() throws InterruptedException {
        Thread.sleep(7500);
        click(confirm);
        return this;
    }

   public InvitePage uploadImage(String val)throws InterruptedException
    {
        WebElement chooseFile = driver.findElement(image);
        chooseFile.sendKeys(val);
       return this;
    }

    public InvitePage titleColor()throws InterruptedException
    { waitElement(receiverTitle);
        String colorString = driver.findElement(receiverTitle).getCssValue("color");
        String colorValue = Color.fromString(colorString).asHex();
        setColor(colorValue);
        return this;
    }

    public void recipient()  throws InterruptedException{otherRecipientClick();}
    public void recipientFill(String val) throws InterruptedException {  recipientText(val);  }
    public void comboZone() throws InterruptedException {  areaZoneClick();  }
    public void listCombo()throws InterruptedException {areaListClick();}
    public void bless(String val)throws InterruptedException{blessingAeraText(val);}
    public void imageUpload(String val) throws InterruptedException {uploadImage(val);}
    public void continune()throws InterruptedException{confirmClick();}
}
