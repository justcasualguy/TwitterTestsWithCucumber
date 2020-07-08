package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComposeTweetPage {
    WebDriver webDriver;

    @FindBy(xpath = "//div[@role=\"textbox\"]")
    private WebElement tweetTextBox;

    @FindBy(xpath = "//div[@data-testid=\"tweetButton\"]")
    private WebElement publishTweet;

    public ComposeTweetPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickComposeTweetButton(){
        publishTweet.click();
    }

    public void writeTweet(String message){
        tweetTextBox.sendKeys(message);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebElement getTweetTextBox() {
        return tweetTextBox;
    }

    public WebElement getPublishTweet() {
        return publishTweet;
    }
}

