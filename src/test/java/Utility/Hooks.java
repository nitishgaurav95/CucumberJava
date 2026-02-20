package Utility;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Base.DriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import io.cucumber.java.Scenario;

public class Hooks {

    private DriverHelper _driverHelper;

    public Hooks(DriverHelper driverHelper) {
        this._driverHelper = driverHelper;
    }

    @Before
    public void InitializeBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\CucumberJava\\CucumberJava\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        _driverHelper.setDriver(driver);
    }

    @After
    public void tearDown()
    {
    	_driverHelper.getDriver().quit();
    }
    
    @AfterStep
    public void takeScreensotOnFailure(Scenario scenario)    
    {
    	if (scenario.isFailed()) 
    	{
    		byte[] screenshot = ((TakesScreenshot)_driverHelper.getDriver()).getScreenshotAs(OutputType.BYTES);
    		scenario.attach(screenshot, "image/png", "screenshot");
    	}
    }
}
