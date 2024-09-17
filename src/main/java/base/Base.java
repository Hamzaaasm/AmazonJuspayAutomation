package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base{
	
	public static WebDriver driver;
	public static  Properties prop;
	
	public Base() {
		try {
			prop=new Properties();
			FileInputStream fis = new FileInputStream("/Users/hamza/eclipse-workspace/AmazonAutoJuspay/src/main/java/resources/Data.properties");
			prop.load(fis);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.getMessage();
		}
	}
	
	public static void initializeBrowser() {
		String browser = prop.getProperty("browser");
	
	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "/Users/hamza/eclipse-workspace/AmazonAutoJuspay/drivers/chromedriver-mac-x64/chromedriver");
		driver = new ChromeDriver();
	}
	
	else if(browser.equalsIgnoreCase("firefox")) {
		
		System.setProperty("webdriver.gecko.driver", "/Users/hamza/eclipse-workspace/AmazonAutoJuspay/drivers/edgedriver_mac64_m1/msedgedriver");
		driver = new FirefoxDriver();
		
	}else if(browser.equalsIgnoreCase("edge")) {
		
		System.setProperty("webdriver.msedge.driver", "/Users/hamza/eclipse-workspace/AmazonAutoJuspay/drivers/geckodriver");
		driver = new EdgeDriver();
		
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get(prop.getProperty("url"));
	
	
	}
	
	public static void tearDown() {
		driver.quit();
	}


}
