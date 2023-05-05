package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

     By mainLoginSignupButton = By.partialLinkText("כניסה / הרשמה");
     By signUpButton = By.cssSelector("span[class='text-link theme']");
      private By pirsomet = By.cssSelector("div.adoric_element.element-shape.closeLightboxButton");


    public HomePage preloadSize(By by)
    {
        WebElement temp= driver.findElement(by);

        return this;
    }
    public HomePage mainLoginButtonClick() throws InterruptedException {
        Thread.sleep(1000);
        validateWindows(pirsomet);
        click(mainLoginSignupButton);
        return this;
    }

    public HomePage loginButtonClick() throws InterruptedException {
        Thread.sleep(1000);
        validateWindows(pirsomet);
        click(signUpButton);
        return this;
    }


    public void LoginButtonClick() throws InterruptedException {
        mainLoginButtonClick();
    }

    public void signUpButton() throws InterruptedException {
        loginButtonClick();
    }


    public String assertTitle() throws InterruptedException {
        if (assertValue(driver.getCurrentUrl(), getSignUptitle()).equals("true")) {
            return "PASS";
        }
        return "FAIL";
    }

}


