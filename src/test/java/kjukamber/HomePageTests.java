package kjukamber;




import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.HomePage;
import testBase.TwitterTestBase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePageTests {
    HomePage homePage;


    @Given("^User is on the home page$")
    public void user_is_on_the_home_page_on_URL_https_twitter_com_explore()  {
        homePage = PageFactory.initElements(
                TwitterTestBase.getInstaneOfTwitterTestBase().getWebDriver(),
                HomePage.class
        );
         homePage.getWebDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         homePage.getWebDriver().get(TwitterTestBase.getInstaneOfTwitterTestBase().getTwitterEndpoints().getProperty("homePage"));
         homePage.getWebDriver().manage().window().maximize();


    }

    @Then("^User clicks home page log in button$")
    public void user_clicks_home_page_log_in_button()  {
        homePage.clickHomePageLoginButton();
    }

    @Then("^User should see log in page$")
    public void user_should_see_log_in_page() {
        String currentUrl = homePage.getWebDriver().getCurrentUrl();
        String expectedUrl = TwitterTestBase.getInstaneOfTwitterTestBase().getTwitterEndpoints().getProperty("logInPage");

        Assert.assertEquals(expectedUrl,currentUrl);
    }


}
