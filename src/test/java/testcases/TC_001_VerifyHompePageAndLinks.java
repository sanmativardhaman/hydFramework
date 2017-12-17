package testcases;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.ScreenShotUtility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.HomePage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class TC_001_VerifyHompePageAndLinks
{

	WebDriver driver;
	HomePage home;
	ExtentReports report;
	ExtentTest logger;
	
	//@BeforeMethod
	@BeforeClass
	public void setUp()
	{
		report=new ExtentReports("./Reports/VerifyHomePage.html");
		logger=report.startTest("TC_001_VerifyHompePageAndLinks");
		
		driver=BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getAppURL());
		logger.log(LogStatus.INFO, "browser and application launched");
		
		
	}
	
	@Test(priority=1)
	public void verifyhomePage()
	{
		home=PageFactory.initElements(driver, HomePage.class);
		String homePageTitle=home.getPageTitle();
		logger.log(LogStatus.INFO,logger.addScreenCapture(ScreenShotUtility.captureScreenshot("HomePage", driver)));
		
		Assert.assertTrue(homePageTitle.contains("My Store"));
		logger.log(LogStatus.PASS, "title is verified");
		
		//System.out.println("Home page title is verified");
		
	}
	
	@Test(priority=2)
	public void verifyContactUsLink() throws Exception
	{
		home=PageFactory.initElements(driver, HomePage.class);
		String contactTitle=home.clickOnContactUs();
		logger.log(LogStatus.INFO, "contact us title is captured");
		
		Assert.assertTrue(contactTitle.contains("Contact us - My Store"));
		logger.log(LogStatus.PASS, "Contact Us link is verified");
		//System.out.println("Contact us link is verified");
		
		
	}
	
	@Test(priority=3)
	public void verifySingInLink() throws Exception
	{
		home=PageFactory.initElements(driver, HomePage.class);
		String signInTitle=home.clickOnSignInLink();
		logger.log(LogStatus.INFO, "Sign in page title is captured");
		
		Assert.assertTrue(signInTitle.contains("Login - My Store"));
		logger.log(LogStatus.PASS, "Sign in page title is verified");
		//System.out.println("Sign In link is verified");
		
		
	}
	
	//@AfterMethod
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.closeBrowser();
		report.endTest(logger);
		report.flush();
	}
	
}
