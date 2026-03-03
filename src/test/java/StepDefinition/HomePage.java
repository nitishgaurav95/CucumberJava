package StepDefinition;
import Base.DriverHelper;

import PageClass.HomePageTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage {

    private DriverHelper _driverHelper;

    public HomePage(DriverHelper driverHelper)
    {
        this._driverHelper = driverHelper;
    }

    HomePageTest homePage;

    @Given("I launch DemoQA application")
    
    public void i_launch_demo_qa_application()
    {
        _driverHelper.getDriver().get("https://demoqa.com/");
        _driverHelper.getDriver().manage().window().maximize();
   }
    @When("I navigate to the Home Page")
    public void i_navigate_to_the_home_page() {
        HomePageTest homePage = new HomePageTest(_driverHelper.getDriver());
        homePage.OpenDemoQA();
    }

    @Then("the title of the Home Page should be {string}")
    public void the_title_of_the_Home_Page_should_be(String s) throws Exception {
        HomePageTest homePage = new HomePageTest(_driverHelper.getDriver());
        homePage.verifyHomePageTitle();
    }
    @Then("I should see the Elements, Forms, Alerts, Frame & Windows cards")
    public void i_should_see_the_elements_forms_alerts_frame_windows_cards() {
        HomePageTest homePage = new HomePageTest(_driverHelper.getDriver());
        assert homePage.elementsCard.isDisplayed();
        assert homePage.formsCard.isDisplayed();
        assert homePage.alertsFrameWindowsCard.isDisplayed();
    }
    @When("I click on the Elements card")
    public void i_click_on_the_elements_card() {
        HomePageTest homePage = new HomePageTest(_driverHelper.getDriver());
        homePage.elementsCard.click();
    }
    @Then("I should be navigated to the Elements Page")
    public void i_should_be_navigated_to_the_elements_page() {
        String expected = "https://demoqa.com/elements";
        String actual = _driverHelper.getDriver().getCurrentUrl();
        assert expected.equals(actual);
    }  
    @Then("I should see the Text Box option")
    public void i_should_see_the_text_box_option() {
        HomePageTest homePage = new HomePageTest(_driverHelper.getDriver());
        assert homePage.textBoxOption.isDisplayed();
    }
    @Then("I should see the Check Box option")
    public void i_should_see_the_check_box_option() {
        HomePageTest homePage = new HomePageTest(_driverHelper.getDriver());
        assert homePage.checkBoxOption.isDisplayed();
    }
    @Then("I should see the Radio Button option")
    public void i_should_see_the_radio_button_option() {
        HomePageTest homePage = new HomePageTest(_driverHelper.getDriver());
        assert homePage.radioButtonOption.isDisplayed();
    }
    @Then("navigate back to the Home Page")
    public void navigate_back_to_the_home_page() throws InterruptedException {
        Thread.sleep(2000); // Optional: wait for 2 seconds before navigating back
        _driverHelper.getDriver().navigate().back();
    }
    @Then("I should be navigated to the Forms Page")
    public void i_should_be_navigated_to_the_forms_page() {
        String expected = "https://demoqa.com/forms";
        String actual = _driverHelper.getDriver().getCurrentUrl();
        assert actual.startsWith(expected);
    }
    @When("I click on the Forms card")
    public void i_click_on_the_forms_card() {
        HomePageTest homePage = new HomePageTest(_driverHelper.getDriver());
        homePage.formsCard.click();
    }
    @When("I click on the Alerts, Frame & Windows card")
    public void i_click_on_the_alerts_frame_windows_card() {
        HomePageTest homePage = new HomePageTest(_driverHelper.getDriver());
        homePage.alertsFrameWindowsCard.click();
    }
    @Then("I should be navigated to the Alerts, Frame & Windows page")
    public void i_should_be_navigated_to_the_alerts_frame_windows_page() {
        String expected = "https://demoqa.com/alertsWindows";
        String actual = _driverHelper.getDriver().getCurrentUrl();
        assert expected.equals(actual);
    }
    @Then("I should see the Practice Form option")
    public void i_should_see_the_practice_form_option() {
        HomePageTest homePage = new HomePageTest(_driverHelper.getDriver());
        assert homePage.practiceFormOption.isDisplayed();
    }
    @Then("I should see the Browser Windows option")
    public void i_should_see_the_browser_windows_option() {
        HomePageTest homePage = new HomePageTest(_driverHelper.getDriver());
        assert homePage.browserWindowsOption.isDisplayed();
    }
}