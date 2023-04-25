package TestUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * This contains the setup methods to configure the appium session
 * 
 * 
 * @author Aaran Logeswaran
 * @version 1.0
 *
 */
public class AppiumController {

	public static OS executionOS = OS.ANDROID;
	private static AppiumDriverLocalService server;
	public static Properties prop = new Properties();

	public enum OS {
		ANDROID,
		IOS
	}

	public static AndroidDriver<AndroidElement> driver;
	public static AndroidDriver<?> adriver;
	public static String CurrentPage = "";
	public static String PreviousPage = "";

	public static void StartClientSession() throws Exception {

		if ((AppiumController.driver != null)) {
			System.out.println("Session is Active for All Devices!");
			return;
		}

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/Config/config.properties");
			prop.load(fis);
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("udid", prop.getProperty("Phone_Udid"));
			capabilities.setCapability("platformVersion", prop.getProperty("Platform_Version"));
			capabilities.setCapability("appPackage", "com.fivemobile.thescore");
			capabilities.setCapability("appActivity", "com.fivemobile.thescore.ui.MainActivity");
			capabilities.setCapability("automationName", "UiAutomator2");
			capabilities.setCapability("appium:noSign", true);
			capabilities.setCapability("newCommandTimeout", 5000);
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("unicodeKeyboard", false);
			AppiumController.driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),
					capabilities);
			AppiumController.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} catch (Exception e) {
			throw new Exception("Unable to Create New Session");
		}
	}

	public static void UpdatePageStates(String Page) throws Exception {
		try {
			PreviousPage = CurrentPage;
			CurrentPage = Page;
		} catch (Exception e) {

		}
	}

	public static void StopClientSession() {
		System.out.println("*************************************************************");
		System.out.println("Stopping Appium Server");
		if (AppiumController.driver != null) {
			AppiumController.driver.quit();
			AppiumController.driver = null;
			System.out.println("Stopped Phone Instance");
			System.out.println("*************************************************************");

		}

	}

	public static void StartWindowsServer() {
		String appiumDir = System.getenv("APPDATA");
		String programFileDir = System.getenv("ProgramFiles");
		String nodeJSPath = programFileDir + File.separator + "nodejs" + File.separator + "node.exe";
		// System.out.println("NODE PATH:: " + nodeJSPath);
		String appiumJSPath = appiumDir + File.separator + "npm" + File.separator + "node_modules" + File.separator
				+ "appium" + File.separator + "build" + File.separator + "lib" + File.separator + "main.js";
		// System.out.println("APP PATH:: " + appiumJSPath);
		AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
		serviceBuilder.usingPort(4723);
		HashMap<String, String> environment = new HashMap<String, String>();
		serviceBuilder.usingDriverExecutable(new File(nodeJSPath));
		serviceBuilder.withAppiumJS(new File(appiumJSPath));
		environment.put(nodeJSPath, appiumJSPath);
		serviceBuilder.withEnvironment(environment);
		server = AppiumDriverLocalService.buildService(serviceBuilder);
		server.clearOutPutStreams();
		server.start();

	}

	public static void StartLinuxServer() {
		AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
		serviceBuilder.usingPort(4723);
		HashMap<String, String> environment = new HashMap<String, String>();
		String nodeJSPath = "/usr/local/bin/node";
		String appiumJSPath = "/usr/local/lib/node_modules/appium/build/lib/main.js";
		serviceBuilder.usingDriverExecutable(new File(nodeJSPath));
		serviceBuilder.withAppiumJS(new File(appiumJSPath));
		environment.put(nodeJSPath, appiumJSPath);
		serviceBuilder.withEnvironment(environment);
		server = AppiumDriverLocalService.buildService(serviceBuilder);
		server.clearOutPutStreams(); // will stops printing logs to console
		server.start();
		System.out.println("Appium Server started");
	}

	public static void KillAllNode(String CommandName) throws Exception {
		Runtime rt = Runtime.getRuntime();
		String runningCommand = "";
		if (System.getProperty("os.name").contains("Windows")) {
			runningCommand = "taskkill /F /IM node.exe";
		} else {
			System.out.println("Killing All Appium Nodes ");

			runningCommand = "killall node";
		}
		Process proc = rt.exec(runningCommand);
		Thread.sleep(5000);
		BufferedReader stdInput1 = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		BufferedReader stdError1 = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
		String s = null;
		Thread.sleep(4000);
		while ((s = stdInput1.readLine()) == null) {
			System.out.println(s);
			System.out.println("Nodes are still running " + s);
			System.out.println("Retrying again");
			proc = rt.exec(runningCommand);
			Thread.sleep(500);
			System.out.println("Killed All nodes");
			break;
		}

//
		while ((s = stdError1.readLine()) != null) {
			System.out.println("output line is " + s);
			if (s.equalsIgnoreCase("node: no process found")
					|| s.equalsIgnoreCase("ERROR: The process \"node.exe\" not found.")) {
				System.out.println(CommandName + "  Command Successfully executed " + s);
			}
			System.out.println("Killed All Appium Nodes");
			System.out.println("*************************************************************");
		}

	}

}
