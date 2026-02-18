package StepDefinition;

import Base.DriverHelper;
import PageClass.FlipkartTestPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartTestSteps 
{
    private DriverHelper _driverHelper;

    public FlipkartTestSteps(DriverHelper driverHelper)
    {
        this._driverHelper = driverHelper;
    }

    FlipkartTestPage flipkartHomePage;

    @Given("I launch Flipkart application")
    public void i_launch_flipkart_application() 
    {
        _driverHelper.getDriver().get("https://www.flipkart.com/");
        _driverHelper.getDriver().manage().window().maximize();
        flipkartHomePage = new FlipkartTestPage(_driverHelper.getDriver());
        flipkartHomePage.CloseLoginPopupIfPresent();
    }

    @When("I search for product {string}")
    public void i_search_for_product(String product) 
    {
        flipkartHomePage = new FlipkartTestPage(_driverHelper.getDriver());
        flipkartHomePage.SearchProduct(product);
    }

    @When("I sort results by low to high price")
    public void i_sort_results_low_to_high() 
    {
        flipkartHomePage = new FlipkartTestPage(_driverHelper.getDriver());
        flipkartHomePage.ClickSortLowToHigh();
    }

    @When("I select Puma brand filter")
    public void i_select_puma_brand_filter() 
    {
        flipkartHomePage = new FlipkartTestPage(_driverHelper.getDriver());
        flipkartHomePage.SelectBrandPuma();
    }

    @When("I select price filter")
    public void i_select_price_filter() 
    {
        flipkartHomePage = new FlipkartTestPage(_driverHelper.getDriver());
        flipkartHomePage.SelectPriceFilter();
    }

    @When("I click first product")
    public void i_click_first_product() 
    {
        flipkartHomePage = new FlipkartTestPage(_driverHelper.getDriver());
        flipkartHomePage.ClickFirstProduct();
    }

    @Then("I verify search results are displayed")
    public void i_verify_search_results() 
    {
        flipkartHomePage = new FlipkartTestPage(_driverHelper.getDriver());
        flipkartHomePage.VerifySearchResultsDisplayed();
    }

    @Then("I verify product page is opened")
    public void i_verify_product_page() 
    {
        flipkartHomePage = new FlipkartTestPage(_driverHelper.getDriver());
        flipkartHomePage.VerifyProductPageOpened();
    }
  
}