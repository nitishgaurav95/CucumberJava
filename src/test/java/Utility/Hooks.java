package Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void tearDown()
    {
    	_driverHelper.getDriver().quit();
    }
}
