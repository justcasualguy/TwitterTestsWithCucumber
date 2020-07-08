package pageObjects;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.TwitterTestBase;

import java.time.Duration;

import static testBase.TwitterTestBase.delayedInput;


public class LoginPage  {

    private WebDriver webDriver;

    @FindBy(name = "session[username_or_email]")
    private WebElement usernameTextField;

    @FindBy(name = "session[password]")
    private WebElement passwordTextField;


    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void enterUsername() {
        waitForEnablingElement(usernameTextField);
        delayedInput(usernameTextField,
                TwitterTestBase.getInstaneOfTwitterTestBase().getProperties().getProperty("username"), 200);
    }

    public void enterPassword() {
        delayedInput(passwordTextField,
                TwitterTestBase.getInstaneOfTwitterTestBase().getProperties().getProperty("password"), 200);
    }

    public void clickEnter() {
        passwordTextField.sendKeys(Keys.ENTER);
    }

    public void waitForEnablingElement(WebElement webElement){
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(usernameTextField));

    }

}
