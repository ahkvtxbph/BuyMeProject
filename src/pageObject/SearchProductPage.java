package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.*;

public class SearchProductPage extends BasePage {
    private int rand;
    private String choice;
    private boolean itemResult = true;

    public SearchProductPage(WebDriver driver) {
        super(driver);
    }

    private By noResult = By.cssSelector("h1.title-xxl.bottom-md.top-none");
    private By priceZone = By.cssSelector("span[title='סכום']");
    private By areaZone = By.cssSelector("span[title='אזור']");
    private By areaList = By.cssSelector("li[value='12']");
    public By categoryZoneInput = By.cssSelector("span[title='קטגוריה']");
    private By categorySearch = By.cssSelector("input[placeholder='חיפוש']");
    private By categoryCombo = By.partialLinkText("גיפט קארד למותגי אופנה");
    private By search = By.partialLinkText("תמצאו לי מתנה");
    private By pirsomet = By.cssSelector("div.adoric_element.element-shape.closeLightboxButton");
    private By category=By.cssSelector("label.ember-view.bm-field.bm-select.show-options.with-icon.empty.md.no-label");

    private By sumAreb = By.cssSelector("div.mx-12.bottom-md.money-input");

    private By myProfile = partialLinkText("החשבון שלי");

    public SearchProductPage priceZoneClick() throws InterruptedException {
       //System.out.println(driver.findElement(myProfile).getText()+" gettest");
        Thread.sleep(1000);
        validateWindows(pirsomet);
        click(priceZone);

        WebElement industries = driver.findElement(By.cssSelector("div.input-label-wrapper"));
        List<WebElement> links = industries.findElements(tagName("li"));
        rand = randOption(links.size());

        Thread.sleep(1000);
        rand = randOption(links.size());
        By loc= By.cssSelector("li[id='"+links.get(rand).getAttribute("id")+"']");
        priceComboClick(loc);
        return this;
    }
    public  void validateWindowsPirsomet () throws InterruptedException {
        validateWindows(pirsomet);
    }
    public SearchProductPage areaZoneClick() throws InterruptedException {
        Thread.sleep(1000);
        validateWindows(pirsomet);
        click(areaZone);
        WebElement industries = driver.findElement(category);
        List<WebElement> links = industries.findElements(tagName("li"));
        Thread.sleep(1000);
        rand = randOption(links.size());

        By loc= By.cssSelector("li[id='"+links.get(rand).getAttribute("id")+"']");
        click(loc);
        return this;
    }


    public SearchProductPage searchButtonClick() throws InterruptedException {
        click(search);
        return this;
    }

    public SearchProductPage priceComboClick(By element) throws InterruptedException {

        click(element);
        return this;
    }

    public SearchProductPage areaListClick(By element) throws InterruptedException {
        click(element);
        return this;
    }

    public SearchProductPage categoryZoneClick() throws InterruptedException {
        Thread.sleep(1000);
        validateWindows(pirsomet);

        click(categoryZoneInput);

        WebElement industries = driver.findElement(category);
        List<WebElement> links = industries.findElements(tagName("li"));

        rand = randOption(links.size());

        choice = areaConvertCategory(links.get(rand).getText());

        By loc= By.cssSelector("li[id='"+links.get(rand).getAttribute("id")+"']");
        WebElement str = driver.findElement(loc);

        String strText = str.getText();

        writeText(categorySearch, strText);
        categoryComboClick(loc);
        searchButtonClick();
        return this;
    }


    public SearchProductPage categoryComboClick(By by) throws InterruptedException {
        click(by);
        return this;
    }

    public SearchProductPage searchClick() throws InterruptedException {
        click(search);
        return this;
    }

    public SearchProductPage getTitleText() {
        getPageTitle();

        return this;
    }

    public SearchProductPage titleAssert() {

        try {
            Assert.assertEquals(getPageTitle(), getPageTitle());
            System.out.println(getPageTitle() + " - passed");
        } catch (AssertionError e) {
            System.out.println(getPageTitle() + " - failed");

            throw e;
        }
        return this;
    }


    public SearchProductPage sumAreaText(String sum) throws InterruptedException {

        writeText(sumAreb, sum);
        return this;
    }

    public boolean validateFountItem() throws InterruptedException {
        Thread.sleep(750);
        itemResult = driver.findElement(noResult).getText().contains("לא נמצאו");
        if (!itemResult)
            return true;
        return false;
    }

    public SearchProductPage pressProductClick() throws InterruptedException {

        Thread.sleep(750);
        WebElement industries = driver.findElement(By.cssSelector("ul.grid.bm-product-cards"));
        List<WebElement> links = industries.findElements(cssSelector("div.ember-view.bm-product-card-link.mx-4.lr-6.sm-12"));


        Thread.sleep(750);
        rand = randOption(links.size());

        By gift = By.partialLinkText(links.get(rand).getText());
        click(gift);
        return this;

    }


    public void priceZoneArea() throws InterruptedException {
        priceZoneClick();
    }

    public void areaZoneArea() throws InterruptedException {
        areaZoneClick();
    }

    public void categoryZoneArea() throws InterruptedException {
        categoryZoneClick();
    }

    public void searchArea() throws InterruptedException {
        searchClick();
    }

    public void title() {
        getTitleText();
    }

    public boolean product() throws InterruptedException {
        return validateFountItem();
    }

    public void equalTitle() {
        titleAssert();
    }

    public void sumNum(String value) throws InterruptedException {
        sumAreaText(value);
    }

    public  String assertDisplay() throws InterruptedException {

        if (assertIsDisplay(myProfile).contains("true")) {
            return "PASS";
        }
        return "FAIL";
    }

}

