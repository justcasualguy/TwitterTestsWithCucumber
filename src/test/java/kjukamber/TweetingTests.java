package kjukamber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.ComposeTweetPage;
import pageObjects.UserHomePage;
import pageObjects.UserProfilePage;

import testBase.TwitterTestBase;

public class TweetingTests {

    UserHomePage userHomePage;
    ComposeTweetPage composeTweetPage;
    UserProfilePage userProfilePage;

    @Given("^User is on the user home page$")
    public void user_is_on_home_page(){
        userHomePage = PageFactory.initElements(TwitterTestBase.getInstaneOfTwitterTestBase().getWebDriver(),
                UserHomePage.class);

    }

    @Given("^User sees compose Tweet button$")
    public void user_sees_Tweet_text_box() {
        Assert.assertNotEquals(userHomePage.getComposeTweetButton(),null);
    }

    @Given("^User clicks home page Tweet button$")
    public void user_clicks_home_page_Tweet_button() {
        userHomePage.clickComposeTweetButton();
        composeTweetPage = PageFactory.initElements(
                TwitterTestBase.getInstaneOfTwitterTestBase().getWebDriver(),
                ComposeTweetPage.class);
    }

    @Then("^User fills Tweet text box with \"([^\"]*)\"$")
    public void user_fills_Tweet_text_box_with(String arg1)  {
        composeTweetPage.writeTweet(arg1);
    }

    @Then("^User clicks Tweet button$")
    public void user_clicks_Tweet_button()  {
        composeTweetPage.clickComposeTweetButton();
    }

    @Then("^User clicks profile button$")
    public void user_clicks_Profile_button(){
        userHomePage.clickProfilePageButton();
        userProfilePage = PageFactory.initElements(
                TwitterTestBase.getInstaneOfTwitterTestBase().getWebDriver(),
                UserProfilePage.class
        );
    }

    @Then("^User should see #tagged tweets")
    public void user_should_see() {
        Assert.assertNotEquals(userProfilePage.getTaggedTweets().size(),0);
    }

}
