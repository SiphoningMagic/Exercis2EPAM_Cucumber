package stepDefiniitions;

import TestComponents.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.io.Zip;
import org.testng.Assert;
import pageObjects.CreateAccount;
import pageObjects.HomePage;
import pageObjects.PersonalData;

import java.io.IOException;

public class stepImplementations extends BaseTest {
    CreateAccount createAccount;
    PersonalData personalData;
    HomePage homePage;
    @Given("User is on the {string} page")
    public void user_is_on_the_page(String Website) throws IOException {
    LaunchApplication(Website);
    }
    @Given("User clicks on the Sign in button")
    public void user_clicks_on_the_sign_in_button() {
        landedpage.clickOnSignInBUtton();
        createAccount= new CreateAccount(driver);
        createAccount.getTextboxEmailAddress();
    }
    @When("User provides his email id {string} and hits on the create account button")
    public void user_provides_his_email_id_and_hits_on_the_create_account_button(String EmailIdReceived) {
        personalData=createAccount.EnterEmailANDCreateAccount(EmailIdReceived);
    }
    @And("hit register after providing all the details {string}, {string},{string},{string},{string}, {string},{string} and  {string}")
    public void hitRegisterAfterProvidingAllTheDetailsAnd(String firstName, String LastName, String Password, String Address, String City, String State, String ZipCode, String MobileNo) throws InterruptedException {
        homePage=personalData.addDetailstoformANDclickRegister(firstName,LastName,Password,Address,City,State, ZipCode,MobileNo);
    }
    @Then("Check the user has landed on the Account Page")
    public void check_the_user_has_landed_on_the_account_page() {
    String actVerbiage=homePage.getBtnSignOut().getText();
        Assert.assertEquals(actVerbiage,"Sign out");
        homePage.getBtnSignOut().click();
        driver.close();
    }


    @When("User provides his email id {string} and password as {string}")
    public void userProvidesHisEmailIdAndPasswordAs(String emailID, String Passwd) {
    homePage=createAccount.performSignInOperation(emailID,Passwd);
    }

    @Given("User is on the Login Page of AutomationPractise Website")
    public void userIsOnTheLoginPageOfAutomationPractiseWebsite() throws IOException {
//        LaunchApplication();
        String applicationUrl= getPropertyValue("Url");
        launchApplication(applicationUrl);
        landedpage.clickOnSignInBUtton();
        createAccount= new CreateAccount(driver);
        createAccount.getTextboxEmailAddress();
    }

    @When("User performs the Login operation providing Valid Credentials")
    public void userPerformsTheLoginOperationProvidingValidCredentials() throws IOException {
        String emailID= getPropertyValue("UserName");
        String Passwd= getPropertyValue("Password");
        homePage=createAccount.performSignInOperation(emailID,Passwd);
    }

    @Then("User should land on the Account Page")
    public void userShouldLandOnTheAccountPage() {
        String actVerbiage=homePage.getBtnSignOut().getText();
        Assert.assertEquals(actVerbiage,"Sign out");
//        homePage.getBtnSignOut().click();
        driver.close();
    }

    @Given("User is logged into the application")
    public void userIsLoggedIntoTheApplication() throws IOException {
        String applicationUrl= getPropertyValue("Url");
        launchApplication(applicationUrl);
        landedpage.clickOnSignInBUtton();
        createAccount= new CreateAccount(driver);
        createAccount.getTextboxEmailAddress();
        String emailID= getPropertyValue("UserName");
        String Passwd= getPropertyValue("Password");
        homePage=createAccount.performSignInOperation(emailID,Passwd);
        String actVerbiage=homePage.getBtnSignOut().getText();
        Assert.assertEquals(actVerbiage,"Sign out");
    }

    @When("User clicks performs SignOut operation")
    public void userClicksPerformsSignOutOperation() {
        homePage.getBtnSignOut().click();
    }

    @Then("User should get logged out and land on the Home Page of application.")
    public void userShouldGetLoggedOutAndLandOnTheHomePageOfApplication() {
        String currentTilte=landedpage.getTitleofPage();
        Assert.assertEquals(currentTilte,"Login - My Store");
        driver.close();
    }

    @Given("User is on the Landing Page of the Website")
    public void userIsOnTheLandingPageOfTheWebsite() throws IOException {
        String applicationUrl= getPropertyValue("Url");
        launchApplication(applicationUrl);
    }

    @When("User performs the SignIn Operation")
    public void userPerformsTheSignInOperation() {
        landedpage.clickOnSignInBUtton();
        createAccount= new CreateAccount(driver);
        createAccount.getTextboxEmailAddress();
        personalData=createAccount.SignInByCreatingAnAccount();

    }

    @And("Provides all the necessary Personal details to creates a Account")
    public void providesAllTheNecessaryPersonalDetailsToCreatesAAccount() throws IOException, InterruptedException {
     homePage=personalData.addPersonalData();
    }

    @Then("User should land on their Account Page")
    public void userShouldLandOnTheirAccountPage() {
        String actVerbiage=homePage.getBtnSignOut().getText();
        Assert.assertEquals(actVerbiage,"Sign out");
        homePage.getBtnSignOut().click();
        driver.close();
    }
}
