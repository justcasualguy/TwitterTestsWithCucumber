Feature: Twitter Tests

  In order to test Twitter functionality
  As a logged user
  I want to perform some actions on page

  @homepage
  Scenario: User navigates to home page https://twitter.com/explore
    Given User is on the home page
    Then User clicks home page log in button
    Then User should see log in page


  @login
  Scenario: Succesfull login
    Given User is on the log in page
    When User fills username and password
    And User clicks enter
    Then User should see home button

  @opentrends
  Scenario: Opening trends settings
    Given User is logged in
    And User sees trends settings button
    Then User clicks trends settings button
    Then User should see show location for you checkbox

  @unchecktrends
  Scenario: Trends for you checkbox uncheck
    Given User sees trends settings window
    And Trends for you checkbox is checked
    Then User unchecks trends for you checkbox
    Then Trends for you checkbox is unchecked

  @changelocation
  Scenario: Change location
    Given User sees trends settings window
    And show content in this location checkbox is checked
    Then User unchecks show content in this location checkbox
    Then User should see explore locations button
    Then User clicks explore locations
    Then User should see available locations
    Then User chooses Poland as location
    Then User clicks close window button


  @tweeting
  Scenario Outline: Tweeting
    Given User is on the user home page
    And User sees compose Tweet button
    Then User clicks home page Tweet button
    Then User fills Tweet text box with "<mytweet>"
    Then User clicks Tweet button
    Examples:

      | mytweet                 |
      | #tagged my first tweet  |
      | #tagged my second tweet |

  @checkingtweets
  Scenario:
    Given User is on the user home page
    Then User clicks profile button
    Then User should see #tagged tweets


  @deletingtweets
  Scenario: Deleting tweets
    Given User is on profile page
    And User sees his tagged tweets
    Then User deletes each tagged tweet



