package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;

public class ExtraPage extends BasePage {
    BaseTest BaseTest;
    public ExtraPage(WebDriver driver) {
        super(driver);
        BaseTest=new BaseTest(driver);
    }

    By preloadSite=By.cssSelector("div#app-loading-img");
    By showDetails=By.cssSelector("button[gtm='תצוגה של המתנה']");
    By giftContent = By.cssSelector("div.recipient-sender.bottom-md");
    By giftBless = By.cssSelector("div.greeting.bottom-md");
    By menu=By.cssSelector("span.arrow.ember-view.bm-icon.sm");
    By logoff=By.partialLinkText("יציאה");
    private By login = By.cssSelector("button.ember-view.bm-btn.no-reverse.main.md.stretch");
    By errorLogin = By.cssSelector("li.parsley-required");
    private static String loader="";

    public void reload()
    {   String url=BaseTest.getUrl();
        driver.get(url);
    }
     public void showDetailsClick() throws InterruptedException {
         click(showDetails);
     }

     public void logoffClick() throws InterruptedException {
         click(menu);
         Thread.sleep(1000);
         click(logoff);
         Thread.sleep(1000);
     }
     public void loginClick() throws InterruptedException {
         click(login);
     }



    public String validateAssertName(String val) {
        return(assertValuecontain(giftContent,val));
     }

    public String validateAssertBless(String val) {
        return(assertValuecontain(giftBless,val));
    }

     public String validateGiftSenderName(String val)
     {
         return(validateAssertName(val));
     }

     public String validateBless(String val)
     {
         return(validateAssertBless(val));
     }

    public String validateLoginError(String val)
    {
        return(assertValuecontain(errorLogin,val));
    }

    @Override
    public void generateEmail() {
        super.generateEmail();
    }

    public void openGiftDetail() throws InterruptedException {
        showDetailsClick();
    }

}
