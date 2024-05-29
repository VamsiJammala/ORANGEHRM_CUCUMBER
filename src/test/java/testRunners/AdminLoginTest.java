package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "FeatureFiles",
		glue = "stepDefinitions",
		dryRun = false,
		tags = "@tag2",
		plugin = {"pretty","html:target/AdminLoginTest.html"}
)
public class AdminLoginTest extends AbstractTestNGCucumberTests{

}
