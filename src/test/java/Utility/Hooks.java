package Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Base.DriverHelper;
// import io.cucumber.java.After;
// import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
    
    private DriverHelper _driverHelper;

    public Hooks(DriverHelper driverHelper) {
        this._driverHelper = driverHelper;
    }

  //  @Before
    public void InitializeBrowser() {

           WebDriverManager.chromedriver().setup();
        
        WebDriver driver = new ChromeDriver();
        _driverHelper.setDriver(driver);
    }
    
 //   @After
    public void TearDown() {
        System.setProperty("webdriver.chrome.driver", "C:\\CucumberJava\\CucumberJava\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        _driverHelper.setDriver(driver);
    }

}