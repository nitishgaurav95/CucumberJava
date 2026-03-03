package Utility;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass 
{
	private WebDriver driver;

    public UtilityClass(WebDriver driver) {
        this.driver = driver;
    }
    
    public void WaitForElelemtToBeClickable(WebElement element)
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.elementToBeClickable(element));		
    }
}
