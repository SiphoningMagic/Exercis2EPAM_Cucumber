Feature: Validating the registrations and login/Logout functionality on the ecommerce site

  Scenario Outline: Validating the registration feature
    Given User is on the "http://automationpractice.com/" page
    And User clicks on the Sign in button
    When User provides his email id "j12vijassv@gmail.com" and hits on the create account button
    And hit register after providing all the details "<first name>", "<last name>","<password>","<Address>","<City>", "<State>","<ZipCode>" and  "<Mobileno>"
    Then Check the user has landed on the Account Page
Examples:
    |first name| last name| password| Address| City | State| ZipCode| Mobileno|
    |Vijay| Yadav| Merlins@01Sword| PUNE| PUNE | Alaska| 87454| 8689946239|