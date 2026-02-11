package Utility;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass 
{
	public WebDriver driver;

    public UtilityClass(WebDriver driver) {
        this.driver = driver;
    }
    
    public void WaitForElelemtToBeClickable(WebElement element)
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    	wait.until(ExpectedConditions.visibilityOf(element));		
    }
    
    public void ScrollTheElementIntoView(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
