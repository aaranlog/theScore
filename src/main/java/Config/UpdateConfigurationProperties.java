package Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 *
 */

public class UpdateConfigurationProperties {

	
	public static void set_config_values(String phoneUdid, String platformVersion) { //

		File configFile = new File("src/main/java/Config/config.properties");

		try {

			FileReader reader = new FileReader(configFile);
			Properties props = new Properties();
			props.load(reader);
			reader.close();
			props.setProperty("Phone_Udid", phoneUdid);
			props.setProperty("Platform_Version", platformVersion);
			FileWriter writer = new FileWriter(configFile);
			props.store(writer, "update settings");
			writer.close();

		} catch (FileNotFoundException ex) {
			System.out.println("Error" + ex.getMessage());

		} catch (IOException ex) {

			System.out.println("Error" + ex.getMessage());
		}
	}
}