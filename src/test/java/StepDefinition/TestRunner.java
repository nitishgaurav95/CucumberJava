package StepDefinition;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/JIRA_API_Intermediate.feature",
glue= {"StepDefinition", "Utility"},
monochrome = true,
plugin = {"pretty"},
tags="@BDDRestAssuredPracticeIntermediate"
)

public class TestRunner {
}
