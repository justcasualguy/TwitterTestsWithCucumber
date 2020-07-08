package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ExploreLocationsPage {

    WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div[1]/div")
    private WebElement closeWindowButton;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[2]/input")
    private WebElement findLocationSearchBar;


    String firstFoundLocationXPath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/div[2]/div/div[1]/div";
    String firstFoundLocationNameXPath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/div[2]/div/div[1]/div/div/span";
    WebElement foundLocation;
    WebElement firstFoundLocationName;

    public ExploreLocationsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void findLocation(String location){
        findLocationSearchBar.sendKeys(location);
    }

    public void clickLocation(String name) {

       foundLocation=webDriver.findElement(By.xpath(String.format("//span[text()='%s']",name)));
       foundLocation.click();

    }

}
