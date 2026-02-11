package StepDefinition;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"@target/failedRerun.txt"}, glue= {"StepDefinition", "Utility"}, monochrome = true,
plugin = {"pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failedRerun.txt",
		"timeline:test-output-thread/"},
tags="@AutomationPractice"
		)
public class FailedCasesRunner {
}
