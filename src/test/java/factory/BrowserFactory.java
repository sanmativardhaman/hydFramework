package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import dataProvider.ConfigDataProvider;

public class BrowserFactory
{

	static WebDriver driver;
	
	public static WebDriver getBrowser(String browser)
	{
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			//ConfigDataProvider config=new ConfigDataProvider();
			System.setProperty("webdriver.gecko.driver", DataProviderFactory.getConfig().getFireFoxPath());
			driver=new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("chrome"))
		{
			//ConfigDataProvider config=new ConfigDataProvider();
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
			driver=new ChromeDriver();
		}
		
		return driver;
	}
	
	public static void closeBrowser()
	{
		driver.quit();
	}
}
