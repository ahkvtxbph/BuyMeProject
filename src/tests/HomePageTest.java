package tests;

import com.relevantcodes.extentreports.LogStatus;
import flow.HomePageFlow;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePageTest extends BaseTest {
    static HomePageFlow HomePageFlow;

    By preloadSite=By.cssSelector("div.spinner");
    public HomePageTest() {
        super(driver);
        HomePageFlow=new HomePageFlow(driver);

    }
    @Before
    public void beforeTest() throws IOException, AWTException, InterruptedException {
        setVideo();
        screenRecorder.start();
        driver.manage().window().maximize();
        driver.get(getUrl());
    }
    @Test
    public void test01_pressSignUpPage() throws Exception {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.INFO, "Test Start");

         HomePageFlow.goToRegisterPage();

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
