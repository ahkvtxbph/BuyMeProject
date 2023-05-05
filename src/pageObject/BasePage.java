package pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;


public class BasePage {

    private String SignUptitle="https://buyme.co.il/?modal=login";
    String valResult="";
    private String url,title="";
    private int choice;
    private final String productMoney="assertValuecontain";
    private String generatedstring;
    private static String color ="";
    private static String loader="";

    public WebDriver driver;
    public WebDriver driver2;

    public BasePage(WebDriver driver) {this.driver=driver; this.driver2=driver;}

    public static void setColor(String val) {
        color=val;
    }
    public static String getcolor() {
        return color;
    }
    public String getSignUptitle() {
        return SignUptitle;
    }
    public void setGeneratedString(String val)
    {
        this.generatedstring=val;
    }

    public String getGeneratedString()
    {
        return this.generatedstring;
    }
    public void generateEmail()
    {
        RandomStringUtils RandomStringUtils = null;
        setGeneratedString(RandomStringUtils.randomAlphabetic(8)+"@wallaballa.com");

    }


    public  BasePage validateWindows(By by) throws InterruptedException {
        Thread.sleep(750);
        if (driver.findElement(by).isDisplayed())
            click(by);
        return this;
    }



    public String getProductMoney()
    {
        return productMoney;
    }

    public void setChoice(int val)
    {
        choice=val;
    }
    public int getChoice(int val)
    {
        return choice;
    }
    public void setPageTitle()
    {
        title=getPageTitle();
    }


    public String getPageTitle()
    {
        return this.title;
    }

    public void setPageUrl()
    {
        url=getPageUrl();
    }

    public String getPageUrl()
    {
        return this.url;
    }
    public void writeText (By element, String toFill) throws InterruptedException {

        waitElement(element);
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(toFill);
    }
    public String assertValue(String actual, String expected)
    {
        try{
            assertEquals(actual, expected);

            valResult="true";
        }catch(AssertionError e){

            valResult="false";
        }
        return valResult;
    }
    public String assertNotEqualValue(String trueResult, String expected)
    {
        try{
            assertEquals(trueResult, expected);
            System.out.println("not equal");
            valResult="false";
        }catch(AssertionError e){
            System.out.println("equal");
            valResult="true";
        }
        return valResult;
    }


    public String assertValuecontain(By trueResult, String expected)
    {  String accutal="";
        WebElement text= driver.findElement(trueResult);
        accutal=text.getText();
        try{
            assertThat(accutal,containsString(expected));
            valResult="true";
        }catch(AssertionError e){
            valResult="false";
        }
        return valResult;
    }

    public boolean assertTrueIsDisplay(By by)
    {
        boolean e =driver.findElement(by).isDisplayed();
        return e;
    }
    public String assertIsDisplay(By by)
    {        try{
            WebElement e =driver.findElement(by);
            assertTrue(e.isDisplayed());

            valResult="true";
        }catch(AssertionError e){
            System.out.println(e.getMessage());
            valResult="false";
        }
        return valResult;
    }

    public boolean validate(By clickable)
    {
        WebElement element=driver.findElement((clickable));
        if(element.isSelected())
        {
            return true;
        }
        return false;
    }
    public  void click (By clickable) throws InterruptedException {
        waitElement(clickable);
        driver.findElement(clickable).click();
    }



    public void selectByIndex (By elementLoction,  int index){
        waitElement(elementLoction);
        WebElement combo= driver.findElement(elementLoction);
        Select selectIndex = new Select(combo);
        selectIndex.selectByIndex(index);

    }

    public void selectByText (By elementLoction, String text){
        waitElement(elementLoction);
        WebElement combo= driver.findElement(elementLoction);
        Select selectText = new Select(combo);
        selectText.selectByValue(text);

    }



    public  void waitElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public String areaConvertCategory(String rand)
    {String temp="";
        switch (rand)
        {
            case "המתנות האהובות של 2023":
            {  temp="1";
                break;
            }
            case "מתנות לחג - המלצות הנבחרת":
            {  temp="2";
                break;
            }
            case "מתנות למזל טלה":
            {  temp="3";
                break;
            }
            case "גיפט קארד למותגי אופנה":
            {  temp="4";
                break;
            }
            case "גיפט קארד למסעדות שף":
            {  temp="5";
                break;
            }
            case "גיפט קארד למתנות ליולדת וצעצועים":
            {  temp="6";
                break;
            }
            case "גיפט קארד לבתי ספא":
            {  temp="7";
                break;
            }
            case "מתנות במימוש אונליין":
            {  temp="8";
                break;
            }
            case "גיפט קארד לארוחת בוקר ובתי קפה":
            {  temp="9";
                break;
            }
            case "גיפט קארד לתרבות ופנאי":
            {  temp="10";
                break;
            }
            case "נופש ומלונות":
            {  temp="11";
                break;
            }
            case "גיפט קארד למסעדות":
            {  temp="12";
                break;
            }
            case "סדנאות והעשרה":
            {  temp="13";
                break;
            }
            case "גיפט קארד לבית, מטבח וגאדג'טים":
            {  temp="14";
                break;
            }
            case "גיפט קארד לבריאות, ספורט ואקסטרים":
            {  temp="15";
                break;
            }
            case "חוויות משותפות":
            {  temp="16";
                break;
            }
            case "גיפט קארד למתנות קולינריות":
            {  temp="17";
                break;
            }
            case "גיפט קארד ליופי וטיפוח":
            {  temp="18";
                break;
            }
            default:
            {   temp="5";
                break;
            }
        }
        return temp;
    }
    public String areaConvert(String rand)
    { String temp="";
        switch (rand)
        {
            case "מרכז":{
                temp= "11";
                break;}
            case "צפון":{
                temp= "9";
                break;}
            case "דרום":{
                temp= "12";
                break;}
            case "ירושלים":
            {temp= "14";
                break;}
            case "חיפה":
            { temp= "16";
                break;}
            case "השרון":
            {temp= "2835";
                break;}
            case "אילת":{
                temp= "2836";
                break;}
            case "פריסה ארצית":
            {temp= "3015";
                break;}
            case "ת"+'"'+"א והסביבה":
            {temp= "13";
                break;}
            default:
                temp= "13";
                break;
        }
        return temp;
    }
    public int randOption(int num)
    {int rand=0;
        if (num==1) {
            rand = 0;
            return rand;
        }
        Random random = new Random();
        do {
            rand = random.nextInt(num);
        }while (rand<1);
        return rand;
    }
}

