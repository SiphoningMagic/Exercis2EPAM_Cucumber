package pageObjects;

import javaUtility.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount extends ReusableMethods {

    WebDriver driver;
    HomePage homePage;
    PersonalData personalData;
    public CreateAccount(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy(xpath = "//input[@id='email_create']")
    WebElement textboxEmailAddress;
    @FindBy(xpath = "//input[@id='email']")
    WebElement textboxEmailToSign;
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement textboxPassWord;



    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement btnSignIn;
    public WebElement getBtnSignIn() {
        waitForElementsToAcceptClick(btnSignIn);
        return btnSignIn;
    }
    @FindBy(xpath = "//button[@id='SubmitCreate']//span")
    WebElement btnCreateAccount;

    public WebElement getTextboxEmailAddress() {
        waitForElementsToAcceptClick(textboxEmailAddress);
        return textboxEmailAddress;
    }

    public PersonalData EnterEmailANDCreateAccount(String EmailID){
        int count=3;
        String randomvalue=getAlphaNumericString(count);
        getTextboxEmailAddress();
        getTextboxEmailAddress().sendKeys(EmailID+randomvalue);
        btnCreateAccount.click();
       personalData = new PersonalData(driver);
       return personalData;
    }
    public PersonalData SignInByCreatingAnAccount(){
        String EmailID="yd276vijay@gmail.com";
        int count=3;
        String randomvalue=getAlphaNumericString(count);
        getTextboxEmailAddress();
        getTextboxEmailAddress().sendKeys(EmailID+randomvalue);
        btnCreateAccount.click();
        personalData = new PersonalData(driver);
        return personalData;
    }
    public HomePage performSignInOperation(String username, String passwd){
        waitForElementsToAcceptClick(textboxEmailToSign);
        textboxEmailToSign.sendKeys(username);
        waitForElementsToAcceptClick(textboxPassWord);
        textboxPassWord.sendKeys(passwd);
        waitForElementsToAcceptClick(btnSignIn);
        btnSignIn.click();
        homePage= new HomePage(driver);
        return homePage;

    }
}
