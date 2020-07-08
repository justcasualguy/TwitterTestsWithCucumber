package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class UserProfilePage {

    WebDriver webDriver;
    //div[contains(@class,"css-1dbjc4n") and contains(.//a,'#moj')]
    @FindBy(xpath = "//div[@data-testid=\"tweet\" ][.//a[contains(text(),\"#tagged\")]]")
    List<WebElement> taggedTweets;
    @FindBy(xpath = "//div[@data-testid=\"tweet\" ][.//a[contains(text(),\"#tagged\")]]//div[@data-testid=\"caret\"]")
    List<WebElement> taggedTweetsCarretButtons;

    String deleteButtonXPath= "//*[@id=\"react-root\"]/div/div/div[1]/div[2]/div/div/div/div[2]/div[3]/div/div/div/div[1]";

    WebElement deleteButton;

    WebElement deleteConfirmButton;

    public UserProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public void deleteTweet(){
        WebElement tweet;

        if(!taggedTweetsCarretButtons.isEmpty()) {
            tweet = taggedTweetsCarretButtons.get(0);
            tweet.click();
            deleteButton = webDriver.findElement(By.xpath(deleteButtonXPath));
            taggedTweetsCarretButtons.remove(tweet);
            deleteButton.click();
            deleteConfirmButton=webDriver.findElement(By.xpath("//div[@data-testid=\"confirmationSheetConfirm\"]"));
            deleteConfirmButton.click();
        }
    }

    public void deleteTweets(){
        for(WebElement carretButton:taggedTweetsCarretButtons)
            deleteTweet();
    }

    public List<WebElement> getTaggedTweets() {
        return taggedTweets;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
