package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.BaseTest;
import Pages.SignInPage;
import Pages.SignInSignOutPage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class TC_002_SignIn_Page extends  BaseTest
{

	
	WebElement element;
	SignInPage sPage;
	SignInSignOutPage page;
	@BeforeTest
	public void setUp()
	{
		initMethod("chrome");
		
		
	}
	
	@Test
	public void registerNewUser() throws Exception
	{
		
		sPage=PageFactory.initElements(driver,SignInPage.class);
	    page=PageFactory.initElements(driver,SignInSignOutPage.class );
		
		String emailAdd=DataProviderFactory.getExcel().getData("UserDetails",1,0);
		String fName=DataProviderFactory.getExcel().getData("UserDetails", 1,1);
		String lName=DataProviderFactory.getExcel().getData("UserDetails", 1,2);
		String emailOne=DataProviderFactory.getExcel().getData("UserDetails", 1,3);
		String password=DataProviderFactory.getExcel().getData("UserDetails", 1,4);
		String yfName=DataProviderFactory.getExcel().getData("UserDetails", 1,5);
		String ylName=DataProviderFactory.getExcel().getData("UserDetails", 1,6);
		String companyName=DataProviderFactory.getExcel().getData("UserDetails", 1,7);
		String address=DataProviderFactory.getExcel().getData("UserDetails", 1,8);
		String adressLine2=DataProviderFactory.getExcel().getData("UserDetails", 1,9);
		String city=DataProviderFactory.getExcel().getData("UserDetails", 1,10);
		String homePhone=DataProviderFactory.getExcel().getData("UserDetails", 1,11);
		//String mobileNumber=DataProviderFactory.getExcel().getData("UserDetails", 1,12);
		String alternateAddress=DataProviderFactory.getExcel().getData("UserDetails", 1,13);
		
		sPage.creatAccount("mr",emailAdd,fName,lName,emailOne,password,yfName,ylName,companyName,address,adressLine2,city,homePhone,alternateAddress);
		
		element=driver.findElement(By.xpath("//h1[text()='My account']"));
		
		Assert.assertTrue(element.isDisplayed());
		System.out.println("Sign was successful");
		
		page.logoutFromApplicaiton();
		System.out.println("logout was successful");		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser();
	}
}
