package flow;

import org.openqa.selenium.WebDriver;
import pageObject.LoginPage;
import tests.BaseTest;



public class LoginFlow {
    LoginPage LoginPage;
    BaseTest BaseTest;


    public LoginFlow(WebDriver driver)  {
        super();
        LoginPage=new LoginPage(driver);


    }

    public void login() throws Exception {
        //Click the registe\login button on Main page
        LoginPage.mainLoginButtonClick();
        LoginPage.buymeEmailText(BaseTest.readFrom("buymeEmail", BaseTest.getXmlPath(), BaseTest.getXmlFile()));
        LoginPage.buymePassText(BaseTest.readFrom("buymePass", BaseTest.getXmlPath(), BaseTest.getXmlFile()));
        LoginPage.loginButtonClick();


    }
}
