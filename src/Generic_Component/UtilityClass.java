package Generic_Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UtilityClass {
	public static String Reading_Properties(String skey) throws IOException
	{
		FileInputStream fis = new FileInputStream("actitime.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(skey);
		
	}

}
