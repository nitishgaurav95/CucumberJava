package PageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BasePage;
import org.junit.Assert;


public class TextBoxDemoQAPage extends BasePage {

    public TextBoxDemoQAPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ---------------- LOCATORS ----------------

    @FindBy(xpath = "//input[@id='userName']")
    WebElement txtFullName;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement btnSubmit;
    
    @FindBy(xpath = "//*[@id='name']/text()[2]")
    WebElement outputName;

    @FindBy(xpath = "//div[@class='card-body']/h5[text()='Elements']")
    WebElement cardElements;

// ---------------- ACTION METHODS ----------------

public void EnterValueInFullName(String fullName) {
    txtFullName.clear();
    txtFullName.sendKeys(fullName);
}

public void ClickOnSubmitButton() {
    btnSubmit.click();
}

public void VerifyTextPresentAfterSubmit(String expectedName)
{
    String actualName = outputName.getText().trim();
    Assert.assertEquals(expectedName, actualName);
}

}
