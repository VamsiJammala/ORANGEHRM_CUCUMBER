package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "FeatureFiles/AddEmployee.feature",
		glue = "stepDefinitions",
		tags = "@tag3",
		dryRun = false,
		plugin = {"pretty","html:target/AddEmployee.html"}
		)
public class AddEmployeeTest extends AbstractTestNGCucumberTests {

}
