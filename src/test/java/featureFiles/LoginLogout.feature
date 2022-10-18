Feature: Validating the Login and Logout feature on site

#  Scenario: Validating the login and logout feature
#    Given User is on the "http://automationpractice.com/" page
#    And User clicks on the Sign in button
#    When User provides his email id "vj276yadav@gmail.com" and password as "Merlins@01Sword"
#    Then Check the user has landed on the Account Page

    @Login
    Scenario: Check user is able to login into an application with valid Credentials
      Given User is on the Login Page of AutomationPractise Website
      When User performs the Login operation providing Valid Credentials
      Then User should land on the Account Page

    @Logout
    Scenario: Check user is able to logout of the application
      Given User is logged into the application
      When User clicks performs SignOut operation
      Then User should get logged out and land on the Home Page of application.