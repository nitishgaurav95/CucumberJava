package StepDefinition;

import org.openqa.selenium.chrome.ChromeOptions;

import Base.DriverHelper;
import PageClass.DemoQAHomePage;
import PageClass.TextBoxDemoQAPage;
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
    
}
