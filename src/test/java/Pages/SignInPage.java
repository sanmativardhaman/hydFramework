/*	This class contains all the web elements present in sign in page
 * 
 */
package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignInPage
{
	
	/*	Declaration of all the web elements 
	 * @params : Sign in, Email address,
	 * 
	 */
	
	WebDriver driver;
	
	private static String gender="Mr";
	
	@FindBy(xpath="//a[@class='login']")
	private WebElement signInLink;
	
	
	@FindBy(xpath=".//*[@id='email_create']")
	private WebElement emailAddressField;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	private WebElement createAccountButton;
	
	@FindBy(xpath=".//*[@id='noSlide']/h1")
	private WebElement textCreateAccount;
	
	/*****************Your Personal Information *******************************/
	
	@FindBy(xpath=".//*[@value='1']")
	private WebElement maleButton;
	
	
	@FindBy(xpath=".//*[@value='2']")
	private WebElement femaleButton;
	
	@FindBy(xpath=".//*[@id='customer_firstname']")
	private WebElement firstName;
	
	
	@FindBy(xpath=".//*[@id='customer_lastname']")
	private WebElement lastName;
	
	
	@FindBy(xpath=".//*[@id='email']")
	private WebElement emailId;
	
	@FindBy(xpath=".//*[@id='passwd']")
	private WebElement passWord;
	
	@FindBy(xpath=".//*[@id='days']")
	private WebElement day;
	
	@FindBy(xpath=".//*[@id='months']")
	private WebElement month;
	
	@FindBy(xpath=".//*[@id='years']")
	private WebElement year;
	
	/**************** Your Address Web elements*************************/
	
	@FindBy(xpath=".//*[@id='firstname']")
	private WebElement yourFirstName;
	
	@FindBy(xpath=".//*[@id='lastname']")
	private WebElement yourLastName;
	
	@FindBy(xpath=".//*[@id='company']")
	private WebElement yourCompany;
	
	@FindBy(xpath=".//*[@id='address1']")
	private WebElement yourAddress;
	
	@FindBy(xpath=".//*[@id='city']")
	private WebElement yourCity;
	
	@FindBy(xpath=".//select[@id='id_state']")
	private WebElement yourState;
	
	@FindBy(xpath="//*[@name='postcode']")
	private WebElement yourZipCode;

	@FindBy(xpath=".//*[@id='id_country']")
	private WebElement yourCountry;
	
	@FindBy(xpath=".//*[@id='other']")
	private WebElement otherInfo;
	
	@FindBy(xpath=".//*[@id='phone']")
	private WebElement homePhone;
	
	
	@FindBy(xpath=".//*[@id='phone_mobile']")
	private WebElement mobileNumber;
	
		
	@FindBy(xpath=".//*[@value='My address']")
	private WebElement alternateEmailAddress;
	
	@FindBy(xpath=".//*[@id='submitAccount']")
	private WebElement registerButton;
	
	
	//initialization of web elements using constructor
	
	public SignInPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void creatAccount(String gen,String emailAdd,String fName,String lName,String emailOne,String password,String yfName,
			String ylName,String companyName,String address,String adressLine2,String city,String homephone,String alternateAddress) throws Exception
	{
		signInLink.click();
		Thread.sleep(3000);
		
		emailAddressField.sendKeys(emailAdd);		//enter email address 
		Thread.sleep(3000);
		createAccountButton.click();
		Thread.sleep(4000);
		
		if(gender.equalsIgnoreCase(gen))
		{
			maleButton.click();
		}
		else
		{
			femaleButton.click();
		}
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		
		emailId.clear();
		emailId.sendKeys(emailOne);
		passWord.sendKeys(password);
		
		
		Select date=new Select(day);
		date.selectByValue("11");
		Thread.sleep(3000);
		
		Select mon=new Select(month);
		mon.selectByValue("6");
		Thread.sleep(3000);
		
		Select yr=new Select(year);
		yr.selectByValue("1986");
		Thread.sleep(3000);
		
		// ----Your address details ----
		
		yourFirstName.clear();
		yourFirstName.sendKeys(yfName);
		
		yourLastName.clear();
		yourLastName.sendKeys(ylName);
		yourCompany.sendKeys(companyName);
		yourAddress.sendKeys(address);
		yourCity.sendKeys(city);
		
		//Thread.sleep(3000);
		
		//yourState.click();
		Select state1=new Select(yourState);
		state1.selectByValue("1");
		Thread.sleep(3000);
		
		yourZipCode.sendKeys("00000");
		
		Select country=new Select(yourCountry);
		country.selectByValue("21");
		
		otherInfo.sendKeys("this is other info");
		homePhone.sendKeys(homephone);
		mobileNumber.sendKeys("0099999999");
		
		alternateEmailAddress.clear();
		alternateEmailAddress.sendKeys(alternateAddress);
		
		registerButton.click();
		
	}
	
}
