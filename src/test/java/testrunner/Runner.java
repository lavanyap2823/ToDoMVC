package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},  // Path to the feature files
        glue = "steps",  // Path to the step definitions
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-report.html",
                "json:target/cucumber.json", "junit:target/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags="@test"
)
public class Runner {

}
