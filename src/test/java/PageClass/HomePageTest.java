package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BasePage;
import org.junit.Assert;

public class HomePageTest extends BasePage {

    public HomePageTest(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // -----------------Loactors-----------------

    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elementsCard;

    @FindBy(xpath = "//h5[text()='Forms']")
    public WebElement formsCard;

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertsFrameWindowsCard;

    @FindBy(xpath = "//span[text()='Text Box']")
    public WebElement textBoxOption;

    @FindBy(xpath = "//span[text()='Check Box']")
    public WebElement checkBoxOption;

    @FindBy(xpath = "//span[text()='Radio Button']")
    public WebElement radioButtonOption;    

    @FindBy(xpath = "//span[text()='Practice Form']")
    public WebElement practiceFormOption;

    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browserWindowsOption;

    //------------------Actions-----------------

     public void OpenDemoQA() {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    //------------------Verifications-----------------

    public void verifyHomePageTitle() throws Exception {
        String expectedTitle = ReadDataFromProperties("homePageTitle");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
}
