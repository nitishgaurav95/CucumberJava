package PageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BasePage;
import org.junit.Assert;


public class DemoQAHomePage extends BasePage {

    public DemoQAHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ---------------- LOCATORS ----------------

    @FindBy(xpath = "//div[@class='card-body']/h5[text()='Elements']")
    WebElement lblElementsTile;

    // -----------------    ACTION METHODS ----------------

    public void VerifyElementsTilePresent() {
        Assert.assertTrue(lblElementsTile.isDisplayed());
    }
}
