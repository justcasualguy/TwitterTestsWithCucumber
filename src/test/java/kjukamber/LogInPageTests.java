package kjukamber;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.LoginPage;
import pageObjects.UserHomePage;
import testBase.TwitterTestBase;

public class LogInPageTests {
    LoginPage loginPage;
    UserHomePage userHomePage;

    @Given("^User is on the log in page$")
    public void user_is_on_the_log_in_page()  {
        loginPage=PageFactory.initElements(
                TwitterTestBase.getInstaneOfTwitterTestBase().getWebDriver(),
                LoginPage.class
        );

    }

    @When("^User fills username and password$")
    public void user_fills_username_and_password()  {
        loginPage.enterUsername();
        loginPage.enterPassword();
    }

    @When("^User clicks enter$")
    public void user_clicks_enter() {
        loginPage.clickEnter();
    }

    @Then("^User should see home button$")
    public void user_should_see_home_button() {
        userHomePage = PageFactory.initElements(
                TwitterTestBase.getInstaneOfTwitterTestBase().getWebDriver(),
                UserHomePage.class);
        Assert.assertNotEquals(userHomePage.getHomeButton(),null);
    }



}
