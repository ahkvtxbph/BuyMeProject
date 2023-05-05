package tests;

import com.relevantcodes.extentreports.LogStatus;
import flow.ProductFlow;
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
public class ProductTest extends BaseTest {
    private  BaseTest BaseTest;
    private ProductFlow ProductFlow;
    private SearchProductPage SearchProductPage;

    @Before
    public void beforeTest() throws IOException, AWTException, InterruptedException {
        setVideo();
        screenRecorder.start();
        driver.manage().window().maximize();
        driver.get(getUrl());

    }

    public ProductTest() {
        super(driver);
        ProductFlow=new ProductFlow(driver);
        SearchProductPage=new SearchProductPage(driver);
        BaseTest=new BaseTest(driver);
    }


    @Test
    public void test04_productPage() throws Exception {
        if (!(BaseTest.getOrder().equals("2")))
        { BaseTest.setOrder("2");
            ProductFlow.preiousStep();
            BaseTest.setOrder("2");
            myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
            myTests.log(LogStatus.INFO, "Test Start");


           ;

            ProductFlow.ProductFlow();
        }
        else {
            BaseTest.setOrder("2");
            myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
            myTests.log(LogStatus.INFO, "Test Start");


            setResult(SearchProductPage.assertDisplay());
            report(getResult());

            ProductFlow.ProductFlow();
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
