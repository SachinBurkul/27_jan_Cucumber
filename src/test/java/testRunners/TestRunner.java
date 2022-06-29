package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/org/features"},	//LoginPage.feature"},
		glue = {"stepDefinitions","applicationHooks"},
		monochrome = true,
		dryRun = false,
		//tags = "@Smoke or @Regression",
		plugin = {
				"pretty",
				"junit:target/junit_report/junit_report.xml",
				"json:target/json_report/json_report.json",
				"html:target/html_report/cucumber_report.html"
		}
		)
public class TestRunner {

}