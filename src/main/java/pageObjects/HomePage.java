package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage  {

    WebDriver webDriver;


    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[2]/header/div[2]/div[1]/div/div[2]/div[1]/div[1]/a")
    private WebElement homePageLoginButton;





    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public  void clickHomePageLoginButton(){
        homePageLoginButton.click();

    }



    public WebDriver getWebDriver() {
        return webDriver;
    }
}
