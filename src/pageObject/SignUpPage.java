package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver)
    {
        super(driver);
    }



    private By buymeFirstName= By.cssSelector("input[placeholder='שם פרטי']");
    private By buymeEmail= By.cssSelector("input[placeholder='מייל']");
    private By buymePass = By.cssSelector("input[placeholder='סיסמה']");
    private By buymePassV = By.cssSelector("input[placeholder='אימות סיסמה']");
    private By checkBoxAgree = By.cssSelector("div.login-options.grid.register-text");
    private By checkBoxDivur = By.cssSelector("div.login-options.grid.bottom-lr.register-text");
    private By buttonReg = By.cssSelector("button.ember-view.bm-btn.no-reverse.main.md.stretch");



    public SignUpPage buymeFirstNameText (String text)throws InterruptedException
    {
        writeText (buymeFirstName, text);
        return this;
    }

    public SignUpPage buymeEmailText (String text) throws InterruptedException
    {
        writeText (buymeEmail, text);
        return this;
    }

    public SignUpPage buymePassText (String text) throws InterruptedException
    {
        writeText (buymePass, text);
        return this;
    }

    public SignUpPage buymePassVText (String text) throws InterruptedException
    {
        writeText (buymePassV, text);
        return this;
    }

    public SignUpPage getTitleText ()
    {
        getPageTitle();
        return this;
    }

    public SignUpPage checkBoxAgreeClick () throws InterruptedException
    {
        click (checkBoxAgree);
        return this;
    }

    public SignUpPage checkBoxDivurClick () throws InterruptedException
    {
        click (checkBoxDivur);
        return this;
    }

    public SignUpPage buttonRegClick () throws InterruptedException
    {
        click (buttonReg);
        return this;
    }


       public void buymeFirstName(String name) throws InterruptedException
    {
        buymeFirstNameText(name); }
    public void buymeEmail(String email) throws InterruptedException {

        buymeEmailText(email);
    }

    public void buymePass(String pass) throws InterruptedException {
        buymePassText(pass);
    }
    public void buymePassV(String passV) throws InterruptedException {  buymePassVText(passV);   }
    public void checkBoxAgree() throws InterruptedException  {checkBoxAgreeClick();}
    public void checkBoxDivur() throws InterruptedException  {checkBoxDivurClick();}
    public void buttonReg() throws InterruptedException  {  buttonRegClick();  }

    public void title() {getTitleText();
   }




    public boolean validate() {
        boolean result=true;
      if(driver.findElement(By.cssSelector("li.parsley-type")).isDisplayed())
          result=false;
       System.out.println(result+" bbb");
        if (!result)
        { return  true;
        }
        else  return false;

    }
}
