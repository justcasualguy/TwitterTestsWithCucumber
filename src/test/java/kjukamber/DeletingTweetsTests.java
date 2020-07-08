package kjukamber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.UserHomePage;
import pageObjects.UserProfilePage;
import testBase.TwitterTestBase;

public class DeletingTweetsTests {
    UserHomePage userHomePage;
    UserProfilePage userProfilePage;


    @Given("^User is on profile page$")
    public void user_is_on_profile_page(){
        userProfilePage = PageFactory.initElements(
                TwitterTestBase.getInstaneOfTwitterTestBase().getWebDriver(),
                UserProfilePage.class
                );
        userProfilePage.getWebDriver().navigate().refresh();

    }
    @Then("^User sees his tagged tweets$")
    public void user_sees_his_marked_tweets()  {
        Assert.assertNotEquals(userProfilePage.getTaggedTweets().size(),0);
    }



    @Then("^User deletes each tagged tweet$")
    public void user_deletes_tweets()  {
        userProfilePage.deleteTweets();
    }



}
