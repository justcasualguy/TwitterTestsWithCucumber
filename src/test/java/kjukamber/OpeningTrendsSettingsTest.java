package kjukamber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.TrendsSettingsPage;
import pageObjects.UserHomePage;
import testBase.TwitterTestBase;

public class OpeningTrendsSettingsTest {

    UserHomePage userHomePage;
    TrendsSettingsPage trendsSettingsPage;
    @Given("^User is logged in$")
    public void user_is_logged_in() {
        userHomePage = PageFactory.initElements(
                TwitterTestBase.getInstaneOfTwitterTestBase().getWebDriver(),
                UserHomePage.class
        );
        userHomePage.clickCloseCookiesInfoButton();

    }

    @Given("^User sees trends settings button$")
    public void user_sees_trends_settings_button()  {
        Assert.assertNotEquals(userHomePage.getTrendsSettingsButton(),null);
    }

    @Then("^User clicks trends settings button$")
    public void user_clicks_trends_settings_button() {
        userHomePage.clickTrendsSettingsButton();

    }

    @Then("^User should see show location for you checkbox$")
    public void user_should_see_Show_content_in_this_location_checkbox() {
        trendsSettingsPage = PageFactory.initElements(
                TwitterTestBase.getInstaneOfTwitterTestBase().getWebDriver(),
                TrendsSettingsPage.class
        );
        Assert.assertNotEquals(trendsSettingsPage.getShowLocationCheckbox(),null);

    }
}
