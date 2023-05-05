package flow;

import org.openqa.selenium.WebDriver;
import pageObject.BasePage;
import pageObject.ProductPage;
import pageObject.SearchProductPage;
import tests.BaseTest;

public class ProductFlow {

     ProductPage ProductPage;
     BaseTest BaseTest;
     BasePage BasePage;
    HomePageFlow HomePageFlow;
    SignUpFlow SignUpFlow;
    SearchFlow SearchFlow;
    SearchProductPage SearchProductPage;



    public  ProductFlow(WebDriver driver)
    {  super();
        ProductPage=new ProductPage(driver);
        BasePage=new BasePage(driver);
        HomePageFlow=new HomePageFlow(driver);
        SignUpFlow=new SignUpFlow(driver);
        SearchFlow=new SearchFlow(driver);;
        SearchProductPage=new SearchProductPage(driver);
        BaseTest=new BaseTest(driver);
    }
    public void ProductFlow() throws Exception {
        BaseTest.setResult(SearchProductPage.assertDisplay());
        BaseTest.report(BaseTest.getResult());
        ProductPage.sumNum(BaseTest.readFrom("buymeSum", BaseTest.getXmlPath(), BaseTest.getXmlFile()));
        BasePage.setPageTitle();
    }
    public void preiousStep() throws Exception {
        HomePageFlow.goToRegisterPage();
        SignUpFlow.signUp();
        SearchFlow.searchGift();
    }
}
