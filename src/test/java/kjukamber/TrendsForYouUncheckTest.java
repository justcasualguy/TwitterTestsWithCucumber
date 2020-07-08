package kjukamber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.TrendsSettingsPage;
import testBase.TwitterTestBase;
public class TrendsForYouUncheckTest {

    TrendsSettingsPage trendsSettingsPage;

    @Given("^User sees trends settings window$")
    public void user_sees_trends_settings_window() {
        trendsSettingsPage = PageFactory.initElements(
                TwitterTestBase.getInstaneOfTwitterTestBase().getWebDriver(),
                TrendsSettingsPage.class
        );
    trendsSettingsPage.updateTrendsForYouCheckBoxXPath();

    }

    @Given("^Trends for you checkbox is checked$")
    public void trends_for_you_checkbox_is_checked() {
        if(!trendsSettingsPage.getTrendsForYouCheckbox().isSelected())
            trendsSettingsPage.clickTrendsForYouCheckbox();
    }

    @Then("^User unchecks trends for you checkbox$")
    public void user_unchecks_trends_for_you_checkbox()  {
        trendsSettingsPage.clickTrendsForYouCheckbox();
    }

    @Then("^Trends for you checkbox is unchecked$")
    public void trends_for_you_checkbox_is_unchecked()  {
        Assert.assertEquals(trendsSettingsPage.getTrendsForYouCheckbox().isSelected(),
                false);
    }







}
