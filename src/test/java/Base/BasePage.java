package Base;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected Properties properties;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
      }

  public static String ReadDataFromProperties(String key) throws IOException
    {
    	Properties prop = new Properties();   	
    	File file = new File("src/test/resources/Config.properties");  	
    	FileInputStream fis = new FileInputStream(file); 	
    	prop.load(fis);
    	return prop.getProperty(key);   	
    }
}
