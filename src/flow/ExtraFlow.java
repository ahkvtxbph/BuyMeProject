package flow;

import data.Data;
import org.openqa.selenium.*;
import pageObject.BasePage;
import pageObject.ExtraPage;
import pageObject.HomePage;
import tests.BaseTest;

import java.util.List;

import static org.openqa.selenium.By.tagName;
import static tests.BaseTest.*;


public class ExtraFlow {
    HomePageFlow HomePageFlow;
    SignUpFlow SignUpFlow;
    SearchFlow SearchFlow;
    ProductFlow ProductFlow;
    InviteFlow InviteFlow;
     ExtraPage ExtraPage;
     BasePage BasePage;
     HomePage HomePage;
     LoginFlow LoginFlow;
     Data Data;
    BaseTest BaseTest;


    private String result="";

    public  ExtraFlow(WebDriver driver)
    { super();
        HomePageFlow=new HomePageFlow(driver);
        SignUpFlow=new SignUpFlow(driver);
        SearchFlow=new SearchFlow(driver);;
        ProductFlow=new ProductFlow(driver);
        InviteFlow=new InviteFlow(driver);
        InviteFlow=new InviteFlow(driver);
        LoginFlow=new LoginFlow(driver);
        ExtraPage=new ExtraPage(driver);
        BasePage=new BasePage(driver);
        BaseTest=new BaseTest(driver);
        HomePage=new HomePage(driver);
        Data=new Data();
    }
    public void extra () throws Exception {

        String size;

        ExtraPage.openGiftDetail();

        BaseTest.setResult(ExtraPage.validateGiftSenderName(BaseTest.readFrom("buymeFirstName",BaseTest.getXmlPath(), BaseTest.getXmlFile())));

        BaseTest.report("buymeFirstName "+BaseTest.getResult());
        BaseTest.setResult(ExtraPage.validateGiftSenderName(BaseTest.readFrom("reciveName",BaseTest.getXmlPath(), BaseTest.getXmlFile())));
        BaseTest.report("reciveName "+BaseTest.getResult());
        BaseTest.setResult(ExtraPage.validateBless(BaseTest.readFrom("bless",BaseTest.getXmlPath(), BaseTest.getXmlFile())));
   
        BaseTest.report("bless "+BaseTest.getResult());


        BasePage.driver.navigate().back();
        result=BasePage.assertValue(ExtraPage.getcolor(),readFrom("expectedColor",BaseTest.getXmlPath(),BaseTest.getXmlFile()));

        BaseTest.report("titleColor - למי לשלוח "+result);

        ExtraPage.reload();
        Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) BasePage.driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        BaseTest.report("Bottom of Choose gift screen PASS");

        Thread.sleep(500);
        ExtraPage.logoffClick();
        HomePage.LoginButtonClick();
        ExtraPage.loginClick();
        BaseTest.report("Login Empty Field "+Data.getErrorLoginMessege() +BaseTest.getResult());
        BaseTest.setOptionStatus("2");


         String parent=driver.getWindowHandle();
        WebDriver driver2 = driver;

        BaseTest.resetBrowserJs(getBrowse());
        driver.manage().window().maximize();
        driver.get(BaseTest.getUrl());

        Thread.sleep(1500);
        String parent3=driver.getWindowHandle();

        driver.switchTo().window(parent3);
        WebElement industries = driver.findElement(By.cssSelector("div#prerendered"));
        List<WebElement> links = industries.findElements(tagName("div"));
        size = String.valueOf(links.get(2).getSize());
        BaseTest.captureElement(links.get(2),size);


       // BaseTest.reportDimension(size);

        driver2.close();
        driver2.quit();


    }

    public void preiousStep() throws Exception {
      /*  HomePageFlow.goToRegisterPage();
        SignUpFlow.signUp();*/
        LoginFlow.login();
        SearchFlow.searchGift();
        ProductFlow.ProductFlow();
        InviteFlow.invite();
        InviteFlow.invite2();
    }
}
