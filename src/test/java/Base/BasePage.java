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
<<<<<<< HEAD
      }

  public static String ReadDataFromProperties(String key) throws IOException
    {
    	Properties prop = new Properties();   	
    	File file = new File("src/test/resources/Config.properties");  	
    	FileInputStream fis = new FileInputStream(file); 	
    	prop.load(fis);
    	return prop.getProperty(key);   	
=======
    }
    
    public static String ReadDataFromProperties(String key) throws IOException {

    Properties prop = new Properties();

    FileInputStream fis =
            new FileInputStream("config.properties");

    prop.load(fis);
    return prop.getProperty(key);
>>>>>>> d7135bbe19bcf7b674b8c2298da3ddf2f27c9fc9
    }

}
