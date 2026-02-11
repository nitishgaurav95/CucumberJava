package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Base.BasePage;
import org.junit.Assert;

public class NopCommercePage extends BasePage {
	public NopCommercePage(WebDriver driver) {
		super(driver);
	}
    
	@FindBy(xpath = "//input[@class='email input-validation-error']")
    WebElement email;
	
	@FindBy(xpath = "//input[@class='password")
    WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath = "//h3[normalize-space()='Start accepting orders']")
	WebElement startAcceptingOrder;
	
	public void EnterUserNameAndPassword()
	{
		email.sendKeys("admin@yourstore.com");
		password.sendKeys("admin");
		btnSubmit.click();
	}
	
	public void VerifyStartAcceptingOrderDisplayedOnThePage()
	{
		Assert.assertTrue(startAcceptingOrder.isDisplayed());
	}

}
