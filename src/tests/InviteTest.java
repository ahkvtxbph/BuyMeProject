package tests;

import com.relevantcodes.extentreports.LogStatus;
import flow.InviteFlow;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.xml.sax.SAXException;
import pageObject.BasePage;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InviteTest extends BaseTest {

   InviteFlow InviteFlow;
    BaseTest BaseTest;
    BasePage BasePage;
    public InviteTest() {
        super(driver);
        InviteFlow=new InviteFlow(driver);
        BaseTest=new BaseTest(driver);
    }
    @Before
    public void beforeTest() throws IOException, AWTException, InterruptedException {
        setVideo();
        screenRecorder.start();
        driver.manage().window().maximize();
        driver.get(getUrl());

    }


    @Test
    public void test05_invitePage() throws Exception {
        if (!(BaseTest.getOrder().equals("2")))
        { BaseTest.setOrder("2");
            InviteFlow.preiousStep();


            myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
            myTests.log(LogStatus.INFO, "Test Start");
            continueTest();
        }
        else {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.INFO, "Test Start");

        InviteFlow.invite();
        InviteFlow.invite2();
        BasePage.setPageTitle();
        }
    }

    public void continueTest() throws ParserConfigurationException, IOException, InterruptedException, SAXException {


        InviteFlow.invite();
        InviteFlow.invite2();
        BasePage.setPageTitle();
    }
    @After

        public void after() throws Exception {
            BaseTest.screenRecorder.stop();
            java.util.List<File> a=screenRecorder.getCreatedMovieFiles();
            List<File> createdMovieFiles = screenRecorder.getCreatedMovieFiles();


            for(File movie : createdMovieFiles){
                System.out.println("New movie created: " + movie.getAbsolutePath());
                videoName= movie.getAbsolutePath();

            }
            // myTests.log(LogStatus.INFO, "Screencast: " + myTests.addScreencast(videoName));

            extent.endTest(myTests);
        }
}
