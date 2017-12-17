package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BrowserFactory;
import factory.DataProviderFactory;

public class BaseTest
{

	public WebDriver driver;
	
	// Method to use thread.sleep
	public  void waitForPageToLoad()
	{
		try
		{
			Thread.sleep(3000);
		} 
		catch (Exception e)
		{
			
			System.out.println("exception occured is "+e.getMessage());
	
		}
	}
	
	//explicit wait method
	public  WebElement waitForElementToLoad(WebElement element)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, 3000);
		WebElement foundElement = wait.until(ExpectedConditions.visibilityOf(element));
		return foundElement;
	}
	
	public void initMethod(String browser)
	{
		driver=BrowserFactory.getBrowser(browser);
		driver.get(DataProviderFactory.getConfig().getAppURL());
		driver.manage().window().maximize();
	}
}
