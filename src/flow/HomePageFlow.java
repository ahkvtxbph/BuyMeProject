package flow;

import org.openqa.selenium.WebDriver;
import pageObject.BasePage;
import pageObject.HomePage;
import pageObject.SignUpPage;
import tests.BaseTest;


public class HomePageFlow {
    HomePage HomePage;
   SignUpPage SignUpPage;
   BasePage BasePage;
    BaseTest BaseTest;




    public HomePageFlow(WebDriver driver)
    {
        super();
        HomePage=new HomePage(driver);
        BaseTest=new BaseTest(driver);
    }

    public void goToRegisterPage() throws Exception {
        //Click the registe\login button on Main page

        HomePage.LoginButtonClick();

        HomePage.signUpButton();
        BaseTest.setResult(HomePage.assertTitle());
        BaseTest.report(BaseTest.getResult());
    }

}
