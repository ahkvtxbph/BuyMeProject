package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.By.cssSelector;

public class ProductPage extends BasePage {
    private int rand;
    private String choice="הכנס סכום";
    private String   tempStr;
    private BaseTest BaseTest;
    private SearchProductPage SearchProductPage;
    public ProductPage(WebDriver driver)
    {
        super(driver);

        SearchProductPage=new SearchProductPage(driver);
        BaseTest=new BaseTest(driver);
    }


    private By sumAreb = By.cssSelector("input[placeholder='הכנס סכום'].ember-view.ember-text-field");
    private By confirm=By.cssSelector("div.mx-12.money-btn");
    private By imgBox=By.cssSelector("div.gift-card-img");



    public ProductPage sumAreaText (By by,String sum) throws InterruptedException{

        writeText (by,sum);
        return this;
    }

    public ProductPage confirmClick ()  throws InterruptedException{
        click (confirm);
        return this;
    }

    public ProductPage sumInputClick() throws InterruptedException
    {
        click (sumAreb);
        return this;
    }

    public ProductPage moveToElement(String value) throws InterruptedException
    {
        waitElement(imgBox);
        WebElement industries = driver.findElement(By.cssSelector("div.inner"));
        List<WebElement> links = industries.findElements(cssSelector("li.ember-view.bm-gift-card-link"));
        Random random = new Random();
        rand = random.nextInt(links.size());

        if (links.size()==0) {
            WebElement industriesSec = driver.findElement(By.cssSelector("div.gifts.no-pagination"));
            List<WebElement> linksSec = industriesSec.findElements(cssSelector("li.ember-view.bm-gift-card-link"));
            Random randomSec = new Random();
            rand = randomSec.nextInt(linksSec.size());
        }

        By gift= By.cssSelector("li[id='"+links.get(rand).getAttribute("id")+"']");

        WebElement industries2 = driver.findElement(gift);
        if(industries2.getText().contains("שובר כספי"))
        {
            By gift2 = gift.cssSelector("input[placeholder='הכנס סכום'].ember-view.ember-text-field");
            sumAreaText(gift2, value);
            confirmClick();
        }
        else {
            click(gift);
        }


            return this;
        }



    public String assertTitleNotEqual(String url) throws InterruptedException {
        if (assertNotEqualValue(driver.getCurrentUrl(),url).contains("true")) {
            return "PASS";
        }
        return "FAIL";
    }

    public void sumNum(String value) throws InterruptedException, IOException {
        BaseTest.setResult(SearchProductPage.assertDisplay());
        BaseTest.report(BaseTest.getResult());
        moveToElement(value);
    }



    public void sumInput() throws InterruptedException  {  sumInputClick();  }
}
