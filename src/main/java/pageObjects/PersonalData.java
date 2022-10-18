package pageObjects;

import javaUtility.ExcelReader;
import javaUtility.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.regex.Pattern;

public class PersonalData extends ReusableMethods {
    WebDriver driver;
    HomePage homePage;
    public PersonalData(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//label[@for='customer_firstname']//following-sibling::input")
    WebElement textboxFirstName;
    @FindBy(xpath ="//label[@for='customer_lastname']//following-sibling::input" )
    WebElement textboxLastName;
    @FindBy(xpath = "//label[@for='passwd']//following-sibling::input")
    WebElement textboxPassword;
    @FindBy(xpath = "//label[@for='address1']//following-sibling::input")
    WebElement textboxAddress;
    @FindBy(xpath = "//label[@for='city']//following-sibling::input")
    WebElement textboxCity;
    @FindBy(xpath = "//select[@id='id_state']")
    WebElement drpdownState;
    @FindBy(xpath = "//label[@for='postcode']//following-sibling::input")
    WebElement textBoxZipCode;
    @FindBy(xpath = "//label[@for='phone_mobile']//following-sibling::input")
    WebElement textboxMobilePhone;
    @FindBy(xpath = "//button[@id='submitAccount']//span")
    WebElement btnRegister;
    public HomePage addPersonalData() throws IOException, InterruptedException {
        ExcelReader reader= new ExcelReader();
        waitForElementsToAcceptClick(textboxFirstName);
        textboxFirstName.sendKeys(reader.getData(0,1,0));
        waitForElementsToAcceptClick(textboxLastName);
        textboxLastName.sendKeys(reader.getData(0,1,1));
        waitForElementsToAcceptClick(textboxPassword);
        textboxPassword.sendKeys(reader.getData(0,1,2));
        waitForElementsToAcceptClick(textboxAddress);
        textboxAddress.sendKeys(reader.getData(0,1,3));
        waitForElementsToAcceptClick(textboxCity);
        textboxCity.sendKeys(reader.getData(0,1,4));
        drpdownState.click();
        Select drp= new Select(drpdownState);
        drp.selectByIndex(1);

        waitForElementsToAcceptClick(textBoxZipCode);
        double zipcode=reader.getNumbericData(0,1,6);
        String[] req_code=String.valueOf(zipcode).split(Pattern.quote("."));
        System.out.println(req_code[0]);
        System.out.println(req_code[1]);
        textBoxZipCode.sendKeys(req_code[0]);
        waitForElementsToAcceptClick(textboxMobilePhone);
        textboxMobilePhone.sendKeys(reader.getData(0,1,7));

        waitForElementsToAcceptClick(btnRegister);
        clickUsingJavaScriptExecutor(btnRegister);
        Thread.sleep(2000);

        homePage  = new HomePage(driver);
        return homePage;


    }
    public HomePage addDetailstoformANDclickRegister(String firstName, String LastName, String Password, String Address, String City, String State, String ZipCode, String MobileNo) throws InterruptedException {
        waitForElementsToAcceptClick(textboxFirstName);
        textboxFirstName.sendKeys(firstName);
        waitForElementsToAcceptClick(textboxLastName);
        textboxLastName.sendKeys(LastName);
        waitForElementsToAcceptClick(textboxPassword);
        textboxPassword.sendKeys(Password);
        waitForElementsToAcceptClick(textboxAddress);
        textboxAddress.sendKeys(Address);
        waitForElementsToAcceptClick(textboxCity);
        textboxCity.sendKeys(City);

//        waitForElementsToAcceptClick(drpdownState);
        drpdownState.click();
        Select drp= new Select(drpdownState);
        drp.selectByIndex(1);

        waitForElementsToAcceptClick(textBoxZipCode);
        textBoxZipCode.sendKeys(ZipCode);
        waitForElementsToAcceptClick(textboxMobilePhone);
        textboxMobilePhone.sendKeys(MobileNo);


        waitForElementsToAcceptClick(btnRegister);
        clickUsingJavaScriptExecutor(btnRegister);
        Thread.sleep(2000);

        homePage  = new HomePage(driver);
        return homePage;
    }
}
