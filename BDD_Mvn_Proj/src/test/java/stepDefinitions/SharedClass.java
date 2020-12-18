package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SharedClass {
	WebDriver driver;
	public Properties configProp;
	private static boolean initialized = false;
	
	@Before
	public WebDriver startBrowser() throws IOException {
		configProp = new Properties();
		FileInputStream configProfile = new FileInputStream("config.properties");
		configProp.load(configProfile);

			String browser = configProp.getProperty("browser");
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
				if(driver==null)
				driver= new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
				if(driver==null)
				driver= new ChromeDriver();
			}
		return driver;
	}
	
	@After
	public void closeBrowser() {
		
		driver.close();
		
		driver.quit();
		driver=null;
	}

}
