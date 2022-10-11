package pageObjects;

import javaUtility.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends ReusableMethods {

    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement btnSignIn;

    public void clickOnSignInBUtton(){
        waitForElementsToAcceptClick(btnSignIn);
        clickUsingJavaScriptExecutor(btnSignIn);
    }


}
