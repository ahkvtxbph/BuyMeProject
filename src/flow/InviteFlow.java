package flow;

import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;
import pageObject.BasePage;
import pageObject.InvitePage;
import pageObject.InvitePage2;
import tests.BaseTest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class InviteFlow {

    /*static*/ InvitePage2 InvitePage2;
    /*static*/ InvitePage InvitePage;
    /*static*/ BasePage BasePage;
    /*static*/ BaseTest BaseTest;
  HomePageFlow HomePageFlow;
  SignUpFlow SignUpFlow;
  SearchFlow SearchFlow;
    ProductFlow ProductFlow;
    LoginFlow LoginFlow;


    public InviteFlow(WebDriver driver) {
        super();
        HomePageFlow=new HomePageFlow(driver);
        SignUpFlow=new SignUpFlow(driver);
        SearchFlow=new SearchFlow(driver);;
        ProductFlow=new ProductFlow(driver);
        LoginFlow=new LoginFlow(driver);

        InvitePage = new InvitePage(driver);
        BasePage=new BasePage(driver);
        InvitePage2=new InvitePage2(driver);

        BaseTest=new BaseTest(driver);
    }

    public void invite() throws InterruptedException, ParserConfigurationException, IOException, SAXException {


        InvitePage.titleColor();
        InvitePage.recipient();

        InvitePage.recipientFill(BaseTest.readFrom("reciveName",BaseTest.getXmlPath(), BaseTest.getXmlFile()));
        InvitePage.comboZone();
        InvitePage.listCombo();
        InvitePage.bless(BaseTest.readFrom("bless",BaseTest.getXmlPath(), BaseTest.getXmlFile()));
        BasePage.setPageTitle();
        InvitePage.imageUpload(BaseTest.getImapgeFile());

        Thread.sleep(500);
        InvitePage.continune();
    }


    public void invite2() throws InterruptedException, ParserConfigurationException, IOException, SAXException {
        InvitePage2.choiceSms();
        InvitePage2.recievePhone(BaseTest.readFrom("smsReciveNumber",BaseTest.getXmlPath(), BaseTest.getXmlFile()));
        InvitePage2.senderName(BaseTest.readFrom("buymeFirstName",BaseTest.getXmlPath(), BaseTest.getXmlFile()));
        InvitePage2.senderPhone(BaseTest.readFrom("smsSenderNumber",BaseTest.getXmlPath(), BaseTest.getXmlFile()));
        InvitePage2.finalButton();
        BasePage.setPageTitle();
    }

    public void preiousStep() throws Exception {

        /*  HomePageFlow.goToRegisterPage();
        SignUpFlow.signUp();*/
        LoginFlow.login();
        SearchFlow.searchGift();
        ProductFlow.ProductFlow();

    }

}
