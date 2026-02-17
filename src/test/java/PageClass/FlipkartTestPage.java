package PageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BasePage;
import org.junit.Assert;


public class FlipkartTestPage extends BasePage {

    public FlipkartTestPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ---------------- LOCATORS ----------------

    @FindBy(xpath = "//input[@class='Vy9RSP']")
    WebElement txtSearchBox;

    @FindBy(xpath = "//button[contains(text(),'✕')]")
    WebElement btnCloseLoginPopup;

    @FindBy(xpath = "//div[contains(@class,'_1YokD2')]")
    WebElement searchResultsContainer;

    @FindBy(xpath = "(//div[contains(@class,'_1AtVbE')]//a)[1]")
    WebElement firstProduct;

    @FindBy(xpath = "//div[contains(text(),'Price -- Low to High')]")
    WebElement sortLowToHigh;

    @FindBy(xpath = "//div[text()='Puma']/preceding-sibling::div")
    WebElement brandPuma;

    @FindBy(xpath = "//div[text()='₹500 to ₹1000']")
    WebElement price500to1000;


    // ---------------- ACTION METHODS ----------------

    public void OpenFlipkart() {
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        CloseLoginPopupIfPresent();
    }

    public void CloseLoginPopupIfPresent() {
        try {
            btnCloseLoginPopup.click();
        } catch (Exception e) {
            // popup not displayed
        }
    }

    public void SearchProduct(String product) {
        txtSearchBox.clear();
        txtSearchBox.sendKeys(product);
        txtSearchBox.submit();
    }

    public void ClickSortLowToHigh() {
        sortLowToHigh.click();
    }

    public void SelectBrandPuma() {
        brandPuma.click();
    }

    public void SelectPriceFilter() {
        price500to1000.click();
    }

    public void ClickFirstProduct() {
        firstProduct.click();
    }

    // ---------------- ASSERTIONS ----------------

    public void VerifySearchResultsDisplayed() {
        Assert.assertTrue(searchResultsContainer.isDisplayed());
    }

    public void VerifyProductPageOpened() {
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("buy"));
    }
}