package TestUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public abstract class AppiumBaseClass {


	
	public static	Properties prop = new Properties();
	
	public AppiumBaseClass() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") 
					+ "/src/main/java/Config/config.properties");
			prop.load(fis);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static String Primary_IP;
	public static String RF_Transmitter_IP;
	public static String filePath = System.getProperty("user.dir") + "/src";
	private static AppiumDriverLocalService server;
	public static String SWFromPanel;
	public static String FILE_LOCATION;
	public static String FILE_SEPARATOR;
	public static String FILE_ABSOLUTE_PATH;
	


}
