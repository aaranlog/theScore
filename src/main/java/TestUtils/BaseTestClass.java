package TestUtils;

import org.testng.Assert;
import AppPages.*;

/**
 * This is the Basetestclass that configures the appium server/client
 * while initialing the associated app page elements
 * 
 * @author Aaran Logeswaran
 * @version 1.0
 *
 */

public class BaseTestClass{
	protected static RegisterPage registerPage;
	protected static HomePage homePage;
	protected static PlayerPage playerPage;
	protected static TeamPage teamPage;
	protected static LeaguePage leaguePage;




	public static void SetUpAppium() throws Exception

	{
		try {

			AppiumController.KillAllNode("Kill Appium");
			if (System.getProperty("os.name").contains("Windows")) {
				System.out.println("Starting Appium in Windows");
				AppiumController.StartWindowsServer();
			} else if (System.getProperty("os.name").contains("Linux")) {
				System.out.println("Starting Appium in Linux");
				AppiumController.StartLinuxServer();

			} else {
				throw new Exception("Appium Server Did not start Driver");
			}

			AppiumController.StartClientSession();
			Thread.sleep(2000);
			System.out.println(AppiumController.executionOS);
			switch (AppiumController.executionOS) {
			case ANDROID:
				registerPage = new RegisterPage(AppiumController.driver);
				homePage = new HomePage(AppiumController.driver);
				playerPage = new PlayerPage(AppiumController.driver);
				teamPage = new TeamPage(AppiumController.driver);
				leaguePage = new LeaguePage(AppiumController.driver);

				break;

			}
		} catch (Exception e) {
			Assert.fail();
		}
	}

	public static void tearDown() throws Exception {
		try {
			Thread.sleep(500);
			AppiumController.StopClientSession();
			AppiumController.KillAllNode("Kill Appium");
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}

}
