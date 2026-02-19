package StepDefinition;

import org.openqa.selenium.chrome.ChromeOptions;

import Base.DriverHelper;
import PageClass.DemoQAHomePage;
import PageClass.TextBoxDemoQAPage;
import Utility.UtilityClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoQAHomeSteps 
{
    private DriverHelper _driverHelper;

    public DemoQAHomeSteps(DriverHelper driverHelper)
    {
        this._driverHelper = driverHelper;
    }

    DemoQAHomePage demoQAHomePage;

    @Then("verify the element present on the home page")
    public void verify_the_element_present_on_the_home_page() {
        demoQAHomePage = new DemoQAHomePage(_driverHelper.getDriver());
        demoQAHomePage.VerifyElementsTilePresent();
    }

    @When("I click on the Element tiles on the home page")
    public void I_click_on_the_Element_tiles_on_the_home_page() {
        demoQAHomePage = new DemoQAHomePage(_driverHelper.getDriver());
        demoQAHomePage.ClickOnElementsTile();
    }

    @When("I click on the Text Box option")
    public void I_click_on_the_Text_Box_option() {
        demoQAHomePage = new DemoQAHomePage(_driverHelper.getDriver());
        demoQAHomePage.ClickOnTextBoxOption();
    }
    
}
