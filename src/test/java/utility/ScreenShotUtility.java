package utility;

import java.io.File;
//import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenShotUtility
{

	  /* This class is used to capture the screenshot 
	 * 
	 */
	
	static SimpleDateFormat format;
		
	public static String captureScreenshot(String name,WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		String destination="C:\\Users\\vvbcf\\hybridFramework\\com.framework.hybdrid\\Screenshots\\"+dateStamp()+"\\"+name+".png";
		
		File dest=new File(destination);
		
		try
		{
			FileUtils.copyFile(source, dest);
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destination ;
		
	}
	
	public static String  dateStamp()
	
	{
		format=new SimpleDateFormat("YYYY-MM-dd");
		
		String todaysDate = format.format(new Date());
		
		return todaysDate ;
		
	}
}
