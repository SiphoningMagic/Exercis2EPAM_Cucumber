package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import static com.sun.tools.doclint.Entity.or;


@CucumberOptions(
        features = {"src/test/java/featureFiles/Registration.feature"/*,"src/test/java/featureFiles/LoginLogout.feature"*/},
        glue = "stepDefiniitions",
        tags = "@Reg or @Login or @Logout",
        plugin={"pretty","html:target/cucumber-reports/CucumberHTMLReport.html","json:target/cucumber-reports/CucumberJSONReport.json","junit:target/cucumber-reports/CucumberXMLReport.xml"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
