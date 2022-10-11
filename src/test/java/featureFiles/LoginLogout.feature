Feature: Validating the Login and Logout feature on site
  Scenario: Validating the login and logout feature
    Given User is on the "http://automationpractice.com/" page
    And User clicks on the Sign in button
    When User provides his email id "vj276yadav@gmail.com" and password as "Merlins@01Sword"
    Then Check the user has landed on the Account Page