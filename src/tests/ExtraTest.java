
package tests;

import com.relevantcodes.extentreports.LogStatus;
import flow.ExtraFlow;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExtraTest extends BaseTest {
    ExtraFlow ExtraFlow;
    BaseTest BaseTest;

    @Before
    public void beforeTest() throws IOException, AWTException, InterruptedException {
        setVideo();
        screenRecorder.start();
        driver.manage().window().maximize();
        driver.get(getUrl());
    }
    public ExtraTest() {
        super(driver);
        BaseTest=new BaseTest(driver);
        ExtraFlow=new ExtraFlow(driver);
    }


    @Test
    public  void test06_extraTest() throws Exception {
        //  BaseTest.setOrder("2");

        ExtraFlow.preiousStep();

        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.INFO, "Test Start");

        ExtraFlow.extra();
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

