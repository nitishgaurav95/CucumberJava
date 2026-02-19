package PageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BasePage;
import Utility.UtilityClass;
import java.lang.Thread;

import org.junit.Assert;


public class DemoQAHomePage extends BasePage {

    public DemoQAHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    UtilityClass utilityClass = new UtilityClass(driver);

    // ---------------- LOCATORS ----------------

    @FindBy(xpath = "//div[@class='card-body']/h5[text()='Elements']")
    WebElement lblElementsTile;

    @FindBy(xpath = "//span[text()='Text Box']")
    WebElement lblTextBox;

    // -----------------    ACTION METHODS ----------------

    public void VerifyElementsTilePresent() {
        Assert.assertTrue(lblElementsTile.isDisplayed());
    }

    public void ClickOnElementsTile()  {
        utilityClass.WaitForElelemtToBeClickable(lblElementsTile);
        lblElementsTile.click();
    }   

    public void ClickOnTextBoxOption() {
        lblTextBox.click();
    }
}
