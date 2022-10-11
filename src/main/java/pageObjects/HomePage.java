package pageObjects;

import javaUtility.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ReusableMethods {

    WebDriver driver;
    public HomePage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "(//a[contains(text(),'Sign out')])[1]")
    WebElement btnSignOut;
    public WebElement getBtnSignOut() {
        waitForElementsToAcceptClick(btnSignOut);
        return btnSignOut;
    }

}
