package tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import flow.*;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import pageObject.*;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class BaseTest {

    static String optionStatus="1";
    static     LoginPage  LoginPage;
    static   SignUpPage SignUpPage;
    static  BasePage BasePage;
    static  HomePage HomePage;
    static ProductPage ProductPage;
    static InvitePage InvitePage;
    static InvitePage2 InvitePage2;
    static  ExtraPage ExtraPage;
    static  SearchProductPage SearchProductPage;

    static    HomePageFlow HomePageFlow;
    static    SignUpFlow SignUpFlow;
    static    ProductFlow ProductFlow;
    static   SearchFlow SearchFlow;
    static   InviteFlow InviteFlow;
    static  ExtraFlow ExtraFlow;

    static  HomePageTest HomePageTest;
    static  SignUpTest SignUpTest;
    static    SearchProductTest SearchProductTest;
    static   ProductTest ProductTest;
    static   InviteTest InviteTest;
    static ExtraTest ExtraTest;

    private static String order="1";
    private static String browse="";

    private static   String xmlPath="src/data/";
    private static   String xmlFile="config.xml";

    private   String result = "";
    private static   String url = "";
    static ExtentTest myTests;
    static ExtentReports extent;
    static String reportFilePath="";
    private static   String iPath="";
    static File fileCodec;
    private static   String fileCodecPath="src/data/mmpeg/bin";
    private static   File reportFile;
    private static File videotFile;
    private static   String imagePath="";
    private static   String reportPath;
    static String videoFOlder="src/data/report/video/";

    private   String cPath="src/data/report/cast/";
    private   File fileCastPath = new File(new File(cPath).getAbsolutePath());
    private   String castPath=String.valueOf(fileCastPath);

    private static   String imageUpload="";
    private static   File file;
     static String videoName;
    static String videoName2="myVideo";     ;
    private static String parent;
    private static String tempName="\\"+"Vid" + System.currentTimeMillis()+".webm";

    static Desktop desktop = Desktop.getDesktop();

    public static WebDriver driver;
    public static WebDriver driver2;

     static   ScreenRecorder screenRecorder;



      String assertionError = null;

    public BaseTest(WebDriver driver)
    {
       this.driver=driver;
        driver2=driver;
    }
    public static void setParent(String val)
    {
        parent=val;

    }
    public String getParent()
    {
        return parent;
    }
    public void setOptionStatus(String val)
    {
        optionStatus=val;
    }
    public static String getOptionStatus()
    {
        return optionStatus;
    }
    public static void setUrl() throws ParserConfigurationException, IOException, SAXException {
        url=readFrom("url",getXmlPath(), getXmlFile());
    }

    public static String getUrl() {
        return url;
    }

    public static String getXmlPath() {
        return xmlPath;
    }

    public static String getXmlFile()
    {
        return xmlFile;
    }


    public static void setImapgePath() throws ParserConfigurationException, IOException, SAXException {
        iPath=readFrom("imagePath",getXmlPath(), getXmlFile());
        File fileImapgePath = new File(new File(iPath).getAbsolutePath());
        imagePath=String.valueOf(fileImapgePath);
    }

    public  String getiPath()
    {
        return imagePath;
    }

    public static void setReportFilePath() throws ParserConfigurationException, IOException, SAXException {
        reportFilePath=readFrom("report",getXmlPath(), getXmlFile());
        reportFile= new File(new File(reportFilePath).getAbsolutePath());
        reportPath=String.valueOf(reportFile);
    }
    public static void setImapgeFile() throws ParserConfigurationException, IOException, SAXException {
        imageUpload=readFrom("img",getXmlPath(), getXmlFile());
        file=new File(new File(imageUpload).getAbsolutePath());

    }

    public String getImapgeFile()
    {
        return String.valueOf(file);
    }
    public static void setBrowse(String val)
    {
        browse=val;
    }

    public static String getBrowse()
    {
        return browse;
    }

    public  String getCasrPath()
    {
        return castPath;
    }

    public  void setOrder(String val)
    {
        this.order=val;
    }
    public  String getOrder()
    {
        return order;
    }


    public  void setResult(String val)
    {
        result=val;
    }
    public  String getResult()
    {
        return result;
    }
    @BeforeClass
    public static void testSetup()throws Exception {
        setReportFilePath();
        resetPage();
        extent = new ExtentReports(reportFilePath);
        myTests = extent.startTest("Buyme.co.il");

        setImapgeFile();
        setImapgePath();
        setUrl();
        setBrowse(readFrom("brwoser",getXmlPath(), getXmlFile()).toLowerCase());
        resetBrowser(getBrowse());

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    public class SpecializedScreenRecorder extends ScreenRecorder {

        private String name;

        public SpecializedScreenRecorder(GraphicsConfiguration cfg,
                                         Rectangle captureArea, Format fileFormat, Format screenFormat,
                                         Format mouseFormat, Format audioFormat, File movieFolder,
                                         String name) throws IOException, AWTException {
            super(cfg, captureArea, fileFormat, screenFormat, mouseFormat,
                    audioFormat, movieFolder);
            this.name = videoName2;

        }
    }
    public  void setVideo() throws IOException, AWTException
    {
        videotFile= new File(new File(videoFOlder).getAbsolutePath());
        System.out.println(videotFile+" videotFile");
        //Create a instance of GraphicsConfiguration to get the Graphics configuration
        //of the Screen. This is needed for ScreenRecorder class.
        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        //Create a instance of ScreenRecorder with the required configurations
        //MIME_AVI


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        Rectangle captureSize = new Rectangle(0,0, width, height);
     /*   screenRecorder = new ScreenRecorder(gc,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, (int)24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f,
                        KeyFrameIntervalKey, (int) (15 * 60)),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,"black",
                        FrameRateKey, Rational.valueOf(30)),null);*/

        screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
                new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f,
                        KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                        FrameRateKey, Rational.valueOf(30)),
                null, videotFile, "MyVideo");

    }

    public static void resetPage()
    {
         LoginPage=new  LoginPage(driver);
        SignUpPage=new SignUpPage(driver);
        BasePage=new BasePage(driver);
        HomePage=new HomePage(driver);
        ProductPage=new ProductPage(driver);
        InvitePage=new InvitePage(driver);
        InvitePage2=new InvitePage2(driver);
        SearchProductPage=new SearchProductPage(driver);
        ExtraPage=new ExtraPage(driver);

        HomePageFlow=new HomePageFlow(driver);
        SignUpFlow=new SignUpFlow(driver);
        ProductFlow=new ProductFlow(driver);
        SearchFlow=new SearchFlow(driver);
        InviteFlow=new InviteFlow(driver);
        ExtraFlow=new ExtraFlow(driver);

        HomePageTest=new HomePageTest();
        SignUpTest=new SignUpTest();
        SearchProductTest=new SearchProductTest();
        ProductTest=new ProductTest();
        InviteTest =new InviteTest();
        ExtraTest=new ExtraTest();
    }

    public  void report(String result) throws IOException {
        myTests.log(LogStatus.INFO, "screen:" + myTests.addScreenCapture(takeScreenShot(getiPath() + "\\" + System.currentTimeMillis())));
        if (result.contains("PASS") || result.contains("equal")|| result.contains("true"))
            myTests.log(LogStatus.PASS, "Log from threadId:  " + result);
        else
            myTests.log(LogStatus.FAIL, "Log from threadId:  " + result);
    }

    public  void reportDimension(String size)throws IOException {
        myTests.log(LogStatus.INFO, "screen:" + myTests.addScreenCapture(takeScreenShot(imagePath + "\\" + System.currentTimeMillis())));
        myTests.log(LogStatus.PASS, "Log from threadId: size of Preloader " + size);
    }
    public   String  takeScreenShot(String ImagePath) throws IOException
    {
        TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagePath+".png");
        try
        {
            FileUtils.copyFile(screenShotFile,destinationFile);

        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return ImagePath+".png";
    }

    public void captureElement(WebElement ele,String size) throws IOException {

        // Get entire page screenshot
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

// Get the location of element on the page
        org.openqa.selenium.Point point = ele.getLocation();

// Get width and height of the element
        int eleWidth = ele.getSize().getWidth();
        int eleHeight = ele.getSize().getHeight();

// Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
                eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);


     String image=imagePath + "\\" + System.currentTimeMillis()+".png";
// Copy the element screenshot to disk

        File screenshotLocation = new File(image);
        FileUtils.copyFile(screenshot, screenshotLocation);
        myTests.log(LogStatus.INFO, "screen:" + myTests.addScreenCapture(String.valueOf(screenshotLocation)));
        myTests.log(LogStatus.PASS, "Log from threadId: size of Preloader " + size);
    }

    public static void resetBrowser(String browseReset) {
        if (browseReset.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/data/driver/chromedriver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("disable-popup-blocking");

              driver = new ChromeDriver(options);
        } else {
            System.setProperty("webdriver.gecko.driver", "src/data/driver/firefox/geckodriver.exe");
            driver = new FirefoxDriver();

        }
    }

    public static void resetBrowserJs(String browseReset) {

        if (browseReset.equals("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("disable-popup-blocking");

            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.managed_default_content_settings.javascript", 2);
            options.setExperimentalOption("prefs", prefs);


            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } else {

            driver = new FirefoxDriver();
        }
    }

    public static String readFrom(String keyData, String path, String file) throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File(path+file);
        DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
        Document doc = dbBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        return doc.getElementsByTagName(keyData).item(0).getTextContent();
    }

    public static void convertVideo(String val) throws IOException, InterruptedException {

        Process proc = Runtime.getRuntime().exec("cmd.exe /c start " +fileCodecPath+"\\"+"ffmpeg -i " +val+ " "+videotFile.getAbsolutePath()+tempName);
        InputStream in = proc.getInputStream();
        byte buff[] = new byte[1024];
        int cbRead;

        try {
            while ((cbRead = in.read(buff)) != -1) {
                // Use the output of the process...
            }
        } catch (IOException e) {
            // Insert code to handle exceptions that occur
            // when reading the process output
        }

// No more output was available from the process, so...

// Ensure that the process completes
        try {
            proc.waitFor();
        } catch (InterruptedException e) {
            // Handle exception that could occur when waiting
            // for a spawned process to terminate
        }

// Then examine the process exit code
        if (proc.exitValue() == 1) {
            // Use the exit value...
        }


    }

    public static void deleteAviFile(String videoToDelete) throws IOException {
        File file = new File(new File(videoToDelete).getAbsolutePath());
        boolean result = Files.deleteIfExists(file.toPath());
        if (result)
        {System.out.println("Avi file delete");}
        else
        {
            System.out.println("Avi file not deleted");
        }
    }

    public static void renameVideoName()
    {
        File sourceFile = new File(videoName);
        File destFile = new File(videotFile.getAbsolutePath()+"\\"+"1.avi");
        if (sourceFile.renameTo(destFile)) {
            System.out.println("File renamed successfully");
        } else {
            System.out.println("Failed to rename file");
        }
    }
    @AfterClass
    public static void end() throws InterruptedException, IOException {
        String folder="";

       renameVideoName();
        videoName=videotFile.getAbsolutePath()+"\\"+"1.avi";
        String videoToDelete=videoName;
        convertVideo(videoName);
        deleteAviFile(videoToDelete);
        folder=videotFile.getAbsolutePath();

        folder+=tempName;
        System.out.println(folder);

        myTests.log(LogStatus.INFO, "Screencast: " + myTests.addScreencast(folder));//videoName));

        driver.close();
        driver.quit();

        extent.flush();

        desktop.open(reportFile);


       // desktop.open(new File(temp));
       // desktop.open(new File(videoName));
    }

}
