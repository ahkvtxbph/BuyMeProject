package tests;

import com.relevantcodes.extentreports.LogStatus;
import flow.HomePageFlow;
import flow.SignUpFlow;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObject.SearchProductPage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignUpTest extends BaseTest {

    static HomePageFlow HomePageFlow;
    static SignUpFlow SignUpFlow;
    BaseTest BaseTest;
    SearchProductPage SearchProductPage;
    public SignUpTest() {
        super(driver);
        HomePageFlow=new HomePageFlow(driver);
        SignUpFlow=new SignUpFlow(driver);
        SearchProductPage=new SearchProductPage(driver);
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
    public void test02_signPage() throws Exception {

        if (!(BaseTest.getOrder().equals("2")))
        { BaseTest.setOrder("2");
            SignUpFlow.preiousStep();

            myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
            myTests.log(LogStatus.INFO, "Test Start");

            SignUpFlow.signUp();



           }
        else {

            myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
            myTests.log(LogStatus.INFO, "Test Start");
            SignUpFlow.signUp();

            setResult(SearchProductPage.assertDisplay());
            report(getResult());
        }
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
