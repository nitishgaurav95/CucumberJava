package StepDefinition;
import Base.*;
import PageClass.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoQASteps
{
	private DriverHelper _driverHelper;
	
	private DemoQA_Page demoQAPage;

    public DemoQASteps(DriverHelper driverHelper)
    {
    	this._driverHelper = driverHelper;
    }
    
	@Given("I launch Demo QA the application")
	public void i_launch_the_application() {
		_driverHelper.getDriver().get("https://demoqa.com/");
	}

	@And("I click on Alerts, Frame & Windows link on home page")
	public void i_click_on_alerts_frame_windows_link_on_home_page() {
		demoQAPage = new DemoQA_Page(_driverHelper.getDriver());
		demoQAPage.ClickOnAlertsFrameWindowsTile(); 
	}

	@Then("I verify the functionality of New Tab")
	public void i_verify_the_functionality_of_new_tab() {
		System.out.print("This is test");
	}

	@When("I verify the functionality of New Window")
	public void i_verify_the_functionality_of_new_window() {
		System.out.print("This is test");
	}

}
