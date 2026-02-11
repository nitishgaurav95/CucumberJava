package StepDefinition;

import Base.DriverHelper;
import PageClass.NopCommercePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class NopCommerceSteps 
{
	private DriverHelper _driverHelper;
	
	public NopCommerceSteps(DriverHelper driverHelper)
	{
		this._driverHelper = driverHelper;
	}
	
	NopCommercePage nopCommercePage;
	
	@Given("I launch Nop Commerce application")
	public void i_launch_the_nop_application() {
		_driverHelper.getDriver().get("https://admin-demo.nopcommerce.com/Admin");
	}
	
	@Given("login to the application")
	public void login_to_the_application() {
		nopCommercePage = new NopCommercePage(_driverHelper.getDriver());
		nopCommercePage.EnterUserNameAndPassword();
	}
	
	@Then("I verify Start accepting orders section")
	public void i_verify_start_accepting_orders_section() {
		nopCommercePage = new NopCommercePage(_driverHelper.getDriver());
		nopCommercePage.VerifyStartAcceptingOrderDisplayedOnThePage();
	}

}
