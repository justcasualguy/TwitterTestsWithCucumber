package testBase;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class TwitterTestBase {
    private static TwitterTestBase twitterTestBase;
    private WebDriver twitterWebDriver;
    private  Properties properties;
    private  Properties twitterEndpoints;
    private  Properties locators;
    private  String webDriverPath;
    private  String propertiesPath;
    private  String twitterEndpointsPath;
    private  String locatorsPath;

    public TwitterTestBase() {

        properties = new Properties();
        twitterEndpoints = new Properties();
        locators = new Properties();
        webDriverPath = "C:/ChromeDriver/chromedriver.exe";
        propertiesPath = "/default.properties";
        twitterEndpointsPath = "/twitterEndpoints.properties";
        locatorsPath = "/locators.properties";

        System.setProperty("webdriver.chrome.driver",webDriverPath);
        twitterWebDriver = new ChromeDriver();


        setDefaultProperties();

    }

    public static TwitterTestBase getInstaneOfTwitterTestBase() {
        if (twitterTestBase == null)
            twitterTestBase = new TwitterTestBase();
        return twitterTestBase;
    }


    public  void setDefaultProperties() {
        InputStream propStream = TwitterTestBase.class.getResourceAsStream(propertiesPath);
        InputStream endpointsStream = TwitterTestBase.class.getResourceAsStream(twitterEndpointsPath);
        InputStream locatorsStream = TwitterTestBase.class.getResourceAsStream(locatorsPath);

        try {
            properties.load(propStream);

        } catch (IOException e) {
            System.out.println("default.properties file is not found in resources folder");
        }

        try {
            twitterEndpoints.load(endpointsStream);
        } catch (IOException e) {
            System.out.println("twitterEndpoints.properties file not found");
        }

        try {
            locators.load(locatorsStream);
        } catch (IOException e) {
            System.out.println("locators.properties file not found");
        }
    }



    public static void delayedInput(WebElement webElement, String input, long miliseconds) {
        for (int i = 0; i < input.length(); i++) {
            webElement.sendKeys(input.substring(i, i + 1));
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public  WebDriver getWebDriver() {
        return twitterWebDriver;
    }

    public  Properties getLocators() {
        return locators;
    }

    public  Properties getProperties() {
        return properties;
    }

    public  Properties getTwitterEndpoints() {
        return twitterEndpoints;
    }
}
