package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import Pages.SignInSignOutPage;
import utility.BaseTest;

public class TC_003_SampleSignInandSignOut extends BaseTest
{

	@BeforeMethod
	public void setUp()
	{
		initMethod("chrome");
	}
	
	@Test
	public void loginIntoApp()
	{
		
		SignInSignOutPage page=PageFactory.initElements(driver, SignInSignOutPage.class);
		page.loginToApplication("testabc3@gmail.com", "Enstage-123");
		System.out.println("Login Successful");
		
		page.logoutFromApplicaiton();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser();
	}
	
}
