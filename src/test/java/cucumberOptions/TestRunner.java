package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/featureFiles/Registration.feature","src/test/java/featureFiles/LoginLogout.feature"},
        glue = "stepDefiniitions"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
