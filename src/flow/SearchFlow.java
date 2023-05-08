package flow;

import org.openqa.selenium.WebDriver;
import pageObject.BasePage;
import pageObject.SearchProductPage;
import tests.BaseTest;
public class SearchFlow {

    SearchProductPage SearchProductPage;
    BasePage BasePage;
    BaseTest BaseTest;
    HomePageFlow HomePageFlow;
    SignUpFlow signUpFlow;
    LoginFlow LoginFlow;


    public SearchFlow(WebDriver driver) {
        super();
        SearchProductPage = new SearchProductPage(driver);
        BasePage=new BasePage(driver);
        HomePageFlow=new HomePageFlow(driver);
        BaseTest=new BaseTest(driver);
        LoginFlow=new LoginFlow(driver);
       }



    public void searchGift() throws Exception {

        SearchProductPage.title();
        BasePage.setPageTitle();
        SearchProductPage.validateWindowsPirsomet();
        SearchProductPage.priceZoneArea();
        SearchProductPage.areaZoneArea();
        SearchProductPage.categoryZoneArea();
        if (SearchProductPage.product()) {
            SearchProductPage.pressProductClick();
        } else {
            BaseTest.report("FAIL");
            BasePage.driver.navigate().back();
            searchGift();
        }
        BaseTest.setResult(SearchProductPage.assertDisplay());
        BaseTest.report(BaseTest.getResult());
    }

    public void preiousStep() throws Exception {
        /*  HomePageFlow.goToRegisterPage();
        SignUpFlow.signUp();*/
        LoginFlow.login();
      }
}
