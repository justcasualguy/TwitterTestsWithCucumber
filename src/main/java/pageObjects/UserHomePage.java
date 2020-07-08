package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testBase.TwitterTestBase;

public class UserHomePage   {

    private WebDriver webDriver;
    @FindBy(xpath = "//a[@href=\"/compose/tweet\"]")
    private WebElement composeTweetButton;


    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[1]")
    private WebElement homeButton;

    @FindBy(xpath = "//a[@href='/settings/explore']")
    private WebElement trendsSettingsButton;


    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[7]/div/div[2]")
    private WebElement profilePageButton;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[1]/div/div/div/div/div/div[2]")
    private WebElement closeCookiesInfoButton;

    public UserHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;

    }


    public void clickCloseCookiesInfoButton(){
        closeCookiesInfoButton.click();
    }
    public  void clickTrendsSettingsButton(){
      trendsSettingsButton.click();
    }

    public void clickComposeTweetButton(){
        composeTweetButton.click();
    }

    public void clickProfilePageButton(){
        profilePageButton.click();
    }
    public WebElement getTrendsSettingsButton() {
        return trendsSettingsButton;
    }

    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getComposeTweetButton() {
        return composeTweetButton;
    }


}
