package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver)
    {

        super(driver);
    }

    private By googleLogin= By.cssSelector("div.social-btn.google");
    private By facebookLogin= By.cssSelector("div.social-btn.facebook");
    private By mainLoginButton  = By.partialLinkText("כניסה / הרשמה");
    private By loginButton = By.cssSelector("button[gtm='כניסה ל-BUYME']");
    private By buymeEmail= By.cssSelector("input[placeholder='מייל']");
    private  By buymePass = By.cssSelector("input[placeholder='סיסמה']");

    private By recover = By.cssSelector("u.bm-body-2.text-link.theme.db");
    private By buttonReg = By.cssSelector("button.ember-view.bm-btn.no-reverse.main.md.stretch");
    private By pirsomet = By.cssSelector("div.adoric_element.element-shape.closeLightboxButton");

    public LoginPage mainLoginButtonClick() throws InterruptedException {
        Thread.sleep(1000);
        validateWindows(pirsomet);
        click(mainLoginButton);
        return this;
    }
    public LoginPage buymeEmailText (String text) throws InterruptedException
    { Thread.sleep(1000);
        validateWindows(pirsomet);;
        writeText (buymeEmail, text);
        return this;
    }

    public LoginPage buymePassText (String text) throws InterruptedException
    { Thread.sleep(1000);
        validateWindows(pirsomet);
        writeText (buymePass, text);
        return this;
    }



    public LoginPage loginButtonClick () throws InterruptedException {

        validateWindows(pirsomet);
        click (loginButton);
        Thread.sleep(10000);
        return this;
    }

    public LoginPage recoverClick () throws InterruptedException
    {
        click (recover);
        return this;
    }



    public LoginPage buttonRegClick () throws InterruptedException {
        click (buttonReg);
        return this;
    }

    public LoginPage facebookegClick () throws InterruptedException
    {
        click (facebookLogin);
        return this;
    }

    public LoginPage googleClick () throws InterruptedException
    {
        click (googleLogin);
        return this;
    }


    public void loginButton()  throws InterruptedException  {
        loginButtonClick();
    }

    public void buymeEmail(String email) throws InterruptedException{
        buymeEmailText(email);
    }

    public void buymePass(String pass) throws InterruptedException {
        buymePassText(pass);
    }

    public void buttonReg() throws InterruptedException  {
        buttonRegClick();
    }


}
