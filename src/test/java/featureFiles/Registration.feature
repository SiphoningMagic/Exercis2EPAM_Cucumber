Feature: Validating the registrations and login/Logout functionality on the ecommerce site
@Reg
  Scenario: Validating the Registration Feature
  Given User is on the Landing Page of the Website
  When User performs the SignIn Operation
  And Provides all the necessary Personal details to creates a Account
  Then User should land on their Account Page

#  @Registration
#  Scenario Outline: Validating the registration feature
#    Given User is on the "http://automationpractice.com/" page
#    And User clicks on the Sign in button
#    When User provides his email id "j12vijassv@gmail.com" and hits on the create account button
#    And hit register after providing all the details "<first name>", "<last name>","<password>","<Address>","<City>", "<State>","<ZipCode>" and  "<Mobileno>"
#    Then Check the user has landed on the Account Page
#Examples:
#    |first name| last name| password| Address| City | State| ZipCode| Mobileno|
#    |Vijay| Yadav| Merlins@01Sword| PUNE| PUNE | Alaska| 87454| 8689946239|

#
#    Drive the URL from a Global Properties file   - Done
#    Drive the username and password from the Global Properties file    - Done
#    Drive relevant details like the personal details from an excel/Json/csv file and dont have it under the Features file   -Done
#    Make the feature file more readable and aligned with EndUser project statements  -Done
#    Add Cucumber Reports to the Framework  -Done
#    remove all the console print statements.  -Done
#  Make sure you use Logging in framework [PENDING (Not required for the Assignment)]
#    Add Cucumber Pico dependency injection in your project.
#
#






