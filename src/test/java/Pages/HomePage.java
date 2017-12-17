 package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	/* @params
	 * declaration of all the web elements
	 * 
	 */
	
	WebDriver driver;
	
	@FindBy(xpath=".//*[@id='contact-link']/a")
	private WebElement contactUsLink;
	
	@FindBy(xpath="//a[@class='login']")
	private WebElement singInLink;
	
	@FindBy(xpath="//strong[text()='0123-456-789']")
	private WebElement contactUs;
	
	//Initialization of webelements
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//utilization of webelements
	
	public String clickOnContactUs() throws Exception
	{
		System.out.println("entered clickonContactUs method");
		contactUsLink.click();
		Thread.sleep(3000);
		
		return driver.getTitle();
	}

	public String  clickOnSignInLink() throws Exception
	{
		System.out.println("entered Sign In method");
		singInLink.click();
		Thread.sleep(3000);
		
		return driver.getTitle();
	}
	
	public void verifyContactUsNumber()
	{
		if (contactUs.isDisplayed())
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
}
