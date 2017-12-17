package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.BaseTest;

public class SignInSignOutPage extends BaseTest
{

	/*
	 * 	This class is used to signIn and signOut
	 */
	
	
	/*
	 * 	@param : email id,password
	 * 
	 */
	
	@FindBy(xpath="//a[@class='login']")
	private WebElement signInLink;
	
	@FindBy(id="email")
	private WebElement emailAddress;
	
	@FindBy(id="passwd")
	private WebElement passwdField;
	
	@FindBy(id="SubmitLogin")
	private WebElement signInButton;
	
	@FindBy(xpath="//a[@class='logout']")
	private WebElement signOutButton;
	
	public SignInSignOutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void loginToApplication(String email,String password)
	{
		signInLink.click();
		waitForPageToLoad();
		emailAddress.sendKeys(email);
		passwdField.sendKeys(password);
		signInButton.click();
		waitForPageToLoad();
	}
	
	public void logoutFromApplicaiton()
	{
		WebElement returnedElement = waitForElementToLoad(signOutButton);
		
		if(returnedElement.isDisplayed())
		{
			signOutButton.click();
		}
	}
	
}

