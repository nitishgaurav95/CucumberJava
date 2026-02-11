package PageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Base.BasePage;
import Utility.UtilityClass;

public class DemoQA_Page extends BasePage
{
    public DemoQA_Page(WebDriver driver) {
		super(driver);
	}
    
    UtilityClass utilityClass;
    
	@FindBy(xpath = "//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindowsTile;
	
	@FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement menuItemBrowserWindows;
    
	public void ClickOnAlertsFrameWindowsTile() {
		utilityClass = new UtilityClass(driver);
		utilityClass.ScrollTheElementIntoView(alertsFrameWindowsTile);
		utilityClass.WaitForElelemtToBeClickable(alertsFrameWindowsTile);
		alertsFrameWindowsTile.click();
	}
}
