package helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper
{
   
   /**
    * getProperty - Gets property from the settings file. 
    * @param key Key of the property to look for.
    * @return A string with the actual value for this particular key.
    */
   public static String getProperty(String key)
	{
		return getProperty("settings.properties", key);
	}
	
	/**
	 * getProperty Gets the property from a properties file, given the fileName.
	 * @param fileName The name of the properties file to read from.
	 * @param key Key of the property to look for.
	 * @return A string with the actual value for this particular key.
	 */
	public static String getProperty(String fileName, String key)
	{
		Properties prop = new Properties();
		try
		{
		   InputStream inputStream = PropertiesHelper.class.getClassLoader().getResourceAsStream(fileName);
			prop.load(inputStream);
			return prop.getProperty(key);
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
