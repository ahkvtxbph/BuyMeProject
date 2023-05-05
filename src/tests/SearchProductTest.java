package tests;

import com.relevantcodes.extentreports.LogStatus;
import flow.SearchFlow;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObject.BasePage;
import pageObject.ProductPage;
import pageObject.SearchProductPage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SearchProductTest extends BaseTest {
    SearchFlow SearchFlow;
    BaseTest BaseTest;
    ProductPage ProductPage;
    BasePage BasePage;
    SearchProductPage SearchProductPage;

    public SearchProductTest() {
        super(driver);
        SearchFlow=new SearchFlow(driver);
        ProductPage=new ProductPage(driver);
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
    public void test03_searchProductPage() throws Exception {
        if (!(BaseTest.getOrder().equals("2"))) {
            BaseTest.setOrder("2");
            SearchFlow.preiousStep();

            myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
            myTests.log(LogStatus.INFO, "Test Start");


            SearchFlow.searchGift();



            setResult(ProductPage.assertTitleNotEqual(BasePage.getPageTitle()));
            report(getResult());
        } else {

            myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
            myTests.log(LogStatus.INFO, "Test Start");


            SearchFlow.searchGift();

            setResult(SearchProductPage.assertDisplay());
            report(getResult());

            setResult(ProductPage.assertTitleNotEqual(BasePage.getPageTitle()));
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
