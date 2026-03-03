package StepDefinition;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
<<<<<<< HEAD
@CucumberOptions(features="src/test/resources/Features/JIRA_API_Intermediate.feature",
glue= {"StepDefinition", "Utility"},
monochrome = true,
plugin = {"pretty"},
tags="@BDDRestAssuredPracticeIntermediate"
)

=======
@CucumberOptions(features="src/test/resources/Features/JIRA_API.feature", glue= {"StepDefinition", "Utility"}, monochrome = true,
plugin = {"pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failedRerun.txt",
		"timeline:test-output-thread/"},
tags="@AutomationPractice"
		)
>>>>>>> d7135bbe19bcf7b674b8c2298da3ddf2f27c9fc9
public class TestRunner {
}