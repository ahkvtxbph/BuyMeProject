package flow;

import org.openqa.selenium.WebDriver;
import pageObject.BasePage;
import pageObject.SearchProductPage;
import pageObject.SignUpPage;
import tests.BaseTest;

public class SignUpFlow {
    /*static*/ SignUpPage SignUpPage;
    /*static*/ BasePage BasePage;
    HomePageFlow HomePageFlow;
    SearchProductPage SearchProductPage;
    BaseTest BaseTest;
    LoginFlow LoginFlow;

    public  SignUpFlow(WebDriver driver)
    { super();
        BasePage=new BasePage(driver);
        SignUpPage=new SignUpPage(driver);
        SearchProductPage=new SearchProductPage(driver);
        HomePageFlow=new HomePageFlow(driver);
        BaseTest=new BaseTest(driver);
       LoginFlow=new LoginFlow(driver);
    }

    public void signUp() throws Exception {


        //Pull the name from xml file , and send it to register page name field
        SignUpPage.buymeFirstName(BaseTest.readFrom("buymeFirstName", BaseTest.getXmlPath(), BaseTest.getXmlFile()));

        // Generate email address
        BasePage.generateEmail();

        //Pull the email address that generated , and send it to register page email field
        SignUpPage.buymeEmail(BasePage.getGeneratedString());
        //Pull the password from xml file , and send it to register page password field
        SignUpPage.buymePass(BaseTest.readFrom("buymePass", BaseTest.getXmlPath(), BaseTest.getXmlFile()));
        //Pull the password from xml file , and send it to register page password validate field
        SignUpPage.buymePassV(BaseTest.readFrom("buymePassV",BaseTest.getXmlPath(), BaseTest.getXmlFile()));

        //Click the agree buttin on register page
        SignUpPage.checkBoxAgree();

        //Click the newsletter agree buttin on register page
        SignUpPage.checkBoxDivur();

        SignUpPage.title();

        //CLick the registe button on register button
        SignUpPage.buttonReg();

        BaseTest.setResult(SearchProductPage.assertDisplay());
        BaseTest.report(BaseTest.getResult());
    }

    public void preiousStep() throws Exception {
        HomePageFlow.goToRegisterPage();

        }
}
