package updateConfigurationFile;

import org.testng.annotations.Test;
import Config.UpdateConfigurationProperties;

/**
 * 
 *
 */
public class UpdateConfigProperties {

	String phoneUdid = System.getProperty("Phone_Udid");
	String platformVersion = System.getProperty("Platform_Version");

	/**
	 * 
	 * @throws Exception
	 */
	@Test(description = "This test will update Config.properties")
	public void Update_Config_Prop() throws Exception {
		try {
			if (phoneUdid == null) {
				phoneUdid = "1";
			}
			if (platformVersion == null) {
				platformVersion = "9";
			}

			UpdateConfigurationProperties.set_config_values(phoneUdid, platformVersion);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}