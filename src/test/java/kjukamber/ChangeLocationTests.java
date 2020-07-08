package kjukamber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.ExploreLocationsPage;
import pageObjects.TrendsSettingsPage;
import testBase.TwitterTestBase;

public class ChangeLocationTests {

    TrendsSettingsPage trendsSettingsPage;
    ExploreLocationsPage exploreLocationsPage;

    @Given("^show content in this location checkbox is checked$")
    public void show_content_in_this_location_checkbox_is_checked()  {
        trendsSettingsPage= PageFactory.initElements(TwitterTestBase.getInstaneOfTwitterTestBase().getWebDriver(),
            TrendsSettingsPage.class
                );
        if(!trendsSettingsPage.getShowLocationCheckbox().isSelected())
            trendsSettingsPage.clickShowLocationCheckbox();
    }

    @Then("^User unchecks show content in this location checkbox$")
    public void user_unchecks_show_content_in_this_location_checkbox() {
            trendsSettingsPage.clickShowLocationCheckbox();
    }

    @Then("^User should see explore locations button$")
    public void user_should_see_explore_locations_button(){
        Assert.assertNotEquals(trendsSettingsPage.getExploreLocationsButton(),null);
    }

    @Then("^User clicks explore locations$")
    public void user_clicks_explore_locations()  {
        trendsSettingsPage.clickExploreLocationsButton();
    }


    @Then("^User should see available locations$")
    public void user_should_see_available_locations()  {
        Assert.assertEquals(trendsSettingsPage.getWebDriver().getCurrentUrl(),
                TwitterTestBase.getInstaneOfTwitterTestBase().getTwitterEndpoints().getProperty("changeLocationPage"));
        exploreLocationsPage= PageFactory.initElements(
                TwitterTestBase.getInstaneOfTwitterTestBase().getWebDriver(),
                ExploreLocationsPage.class
        );
    }

    @Then("^User chooses Poland as location$")
    public void user_chooses_location(){
        exploreLocationsPage.findLocation("Polska");
        exploreLocationsPage.clickLocation("Polska");
    }



    @Then("^User clicks close window button$")
    public void user_clicks_close_window_button() {
        trendsSettingsPage.clickCloseWindowButton();
    }




}
