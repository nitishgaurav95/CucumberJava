package StepDefinition;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Jira_Advanced.feature",
glue= {"StepDefinition", "Utility"},
monochrome = true,
plugin = {"pretty"},
tags="@Advanced"
)

public class TestRunner {
}