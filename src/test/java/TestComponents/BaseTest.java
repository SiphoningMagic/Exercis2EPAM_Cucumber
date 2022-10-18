package TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pageObjects.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public WebDriver driver;
    public LandingPage landedpage;
    public Properties prop;

    public String getPropertyValue(String RequiredPropertyName) throws IOException {
        Properties prop= new Properties();
        FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/GlobalProperty.properties");
        prop.load(fis);
        return prop.getProperty(RequiredPropertyName);

    }
    public WebDriver initializeDriver() throws IOException {

        prop= new Properties();
        FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/GlobalProperty.properties");
        prop.load(fis);
        String browserName=System.getProperty("BrowserName")!=null ? System.getProperty("BrowserName"): getPropertyValue("BrowserName");
//        String browserName= prop.getProperty("BrowserName");

        if(browserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("EDGE")) {
            System.setProperty("webdriver.edge.driver","edge.exe");
            driver= new EdgeDriver();
        }
        else{
            System.out.println("Please check the Browser value in GLobal propertied file!! Something seems wrong with value");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver  LaunchApplication(String websiteToLaunch) throws IOException {
        driver= initializeDriver();
        System.out.println("inside the new implementation");
        driver.get(websiteToLaunch);
        landedpage= new LandingPage(driver);
        return driver;
    }

    public WebDriver launchApplication(String applicationUrl) throws IOException {
        driver=initializeDriver();
        System.out.println("inside the new implementation");
        driver.get(applicationUrl);
        landedpage= new LandingPage(driver);
        return driver;
    }

    public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
        this.driver=driver;
        TakesScreenshot ts= (TakesScreenshot) driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        File file= new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
    }
}

