/*
 * 	This class is used to read the data from properties file.
 */

package dataProvider;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();

			pro.load(fis);
		} catch (Exception e) {

			System.out.println("exception is " + e.getMessage());
		}

	}

	// method to get application url from the properties file

	public String getAppURL() {
		return pro.getProperty("url");
	}

	// method to get application fire fox path from the properties file

	public String getFireFoxPath()

	{
		return pro.getProperty("firefoxPath");

	}

	// method to get application url from the properties file

	public String getChromePath() {
		return pro.getProperty("chromePath");
	}

}
