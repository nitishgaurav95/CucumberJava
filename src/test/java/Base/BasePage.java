package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public String ReadDataFromProperties(String key) throws IOException
    {
    	Properties prop = new Properties();   	
    	File file = new File("properties");  	
    	FileInputStream fis = new FileInputStream(file); 	
    	prop.load(fis);
    	return prop.getProperty(key);   	
    }
}
