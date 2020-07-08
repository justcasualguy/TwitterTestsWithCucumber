package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrendsSettingsPage {

    WebDriver webDriver;


    private String trendsButtonXPathShowLocationUnchecked = "//*[@id=\"react-root\"]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[2]/div/div/div[6]/label/div[2]/input";
    private String trendsButtonXPathShowLocationChecked = "//*[@id=\"react-root\"]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[2]/div/div/div[5]/label/div[2]/input";

    private WebElement trendsForYouCheckbox;

    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/label//input[@type=\"checkbox\"]")
    private WebElement showLocationCheckbox;


    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div[1]/div/div")
    private WebElement closeWindowButton;




    private String locationButtonXPath = "//*[@id=\"react-root\"]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]";
    private WebElement locationButton;

    private String exploreLocationsXPath = "//a[@href=\"/settings/explore/location\"]";
    private WebElement exploreLocationsButton;




    public TrendsSettingsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }



    public void clickTrendsForYouCheckbox() {
        if (!showLocationCheckbox.isSelected())
            updateTrendsForYouCheckBoxXPath();
        boolean currentState = trendsForYouCheckbox.isSelected();
        trendsForYouCheckbox.click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementSelectionStateToBe(trendsForYouCheckbox, !currentState));

    }

    public void clickShowLocationCheckbox() {
        boolean currentState = showLocationCheckbox.isSelected();
        showLocationCheckbox.click();
        updateTrendsForYouCheckBoxXPath();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementSelectionStateToBe(showLocationCheckbox, !currentState));

        if(showLocationCheckbox.isSelected()==false)
            exploreLocationsButton = webDriver.findElement(By.xpath(exploreLocationsXPath));
    }

    public void clickExploreLocationsButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(exploreLocationsButton));
        exploreLocationsButton.click();
        locationButton = webDriver.findElement(By.xpath(locationButtonXPath));
    }

    public void clickLocationButton() {
        locationButton.click();
    }


    public void clickCloseWindowButton() {
        closeWindowButton.click();
    }

    public WebElement getTrendsForYouCheckbox() {
        return trendsForYouCheckbox;
    }

    public WebElement getShowLocationCheckbox() {
        return showLocationCheckbox;
    }

    public WebElement getExploreLocationsButton() {
        return exploreLocationsButton;
    }


    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void updateTrendsForYouCheckBoxXPath() {
        if (showLocationCheckbox.isSelected())
            trendsForYouCheckbox = webDriver.findElement(By.xpath(trendsButtonXPathShowLocationChecked));
        else
            trendsForYouCheckbox = webDriver.findElement(By.xpath(trendsButtonXPathShowLocationUnchecked));
    }
}


