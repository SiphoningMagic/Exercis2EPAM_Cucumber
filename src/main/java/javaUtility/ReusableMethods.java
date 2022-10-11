package javaUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReusableMethods {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    public ReusableMethods(WebDriver driver){
        this.driver=driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        js= (JavascriptExecutor)driver;
    }
    public void clickOnElement(WebElement element) {
        js.executeScript("arguments[0].click();",element);
    }

    public void waitForElementsToAcceptClick(WebElement findBy){
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }

    public void waitforElementToVanish(WebElement findBy){
        wait.until(ExpectedConditions.invisibilityOf(findBy));
    }
    public void waitTillVisisbilityOfElement(WebElement findBy){
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void clickUsingJavaScriptExecutor(WebElement element){
        js.executeScript("arguments[0].click();",element);
    }

    public void sendDataUsingJavScriptExecutor(String valuetoSend,WebElement element){
        js.executeScript("arugments[0].value='"+valuetoSend+"';",element);
    }


    // function to generate a random string of length n
    public static String getAlphaNumericString(int n)
    {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }


}
