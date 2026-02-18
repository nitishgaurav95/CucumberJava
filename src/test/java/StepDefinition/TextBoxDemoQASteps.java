package StepDefinition;

import org.openqa.selenium.chrome.ChromeOptions;

import Base.DriverHelper;
import PageClass.TextBoxDemoQAPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TextBoxDemoQASteps 
{
    private DriverHelper _driverHelper;

    public TextBoxDemoQASteps(DriverHelper driverHelper)
    {
        this._driverHelper = driverHelper;
    }

    TextBoxDemoQAPage textBoxDemoQAPage;

    
    @Given("I launch DemoQA application")
    public void I_launch_DemoQA_application() {
        _driverHelper.getDriver().get("https://demoqa.com");
        _driverHelper.getDriver().manage().window().maximize();
        textBoxDemoQAPage = new TextBoxDemoQAPage(_driverHelper.getDriver());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I enter first name {string}")
    public void I_enter_first_name(String s) {
        textBoxDemoQAPage = new TextBoxDemoQAPage(_driverHelper.getDriver());
        textBoxDemoQAPage.EnterValueInFullName(s);
    }

    @When("I click on the Submit button")
    public void I_click_on_the_Submit_button() {
        textBoxDemoQAPage = new TextBoxDemoQAPage(_driverHelper.getDriver());
        textBoxDemoQAPage.ClickOnSubmitButton();
    }

    @Then("I verify output is displayed with first name {string}")
    public void I_verify_output_is_displayed_with_first_name(String s) {
        textBoxDemoQAPage = new TextBoxDemoQAPage(_driverHelper.getDriver());
        textBoxDemoQAPage.VerifyTextPresentAfterSubmit(s);
    }
       
}
