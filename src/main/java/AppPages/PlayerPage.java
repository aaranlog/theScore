package AppPages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import TestUtils.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PlayerPage extends AppiumController {

	@AndroidFindBy(id = "com.fivemobile.thescore:id/txt_player_name")
	static MobileElement playerName;
	@AndroidFindBy(id = "com.fivemobile.thescore:id/detail_subtitle")
	static MobileElement playerDetails;

	public PlayerPage(AndroidDriver<?> appiumDriver) {
		AppiumController.adriver = appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}

	@SuppressWarnings("finally")
	public static boolean IsPlayer(String Player) throws Exception {
		boolean isPlayer = false;
		try {
			if ((playerName.getText()).contains(Player)) {
				System.out.println("found player!");
				isPlayer = true;
			}

		} catch (NoSuchElementException e) {
			System.out.println("Not On a Player Page!");

		} finally {
			return isPlayer;
		}
	}

	public static void EnterPlayerTab(String Tab) throws Exception {
		try {
			if (MainDictionary.PlayersTabs(Tab) != "None") {
				if ((driver.findElementByAccessibilityId(Tab)).isDisplayed()) {
					System.out.println("Going into Tab!");
					(driver.findElementByAccessibilityId(Tab)).click();

				}
			} else {
				throw new Exception("Tab " + Tab + " not Supported Under Players!");
			}

		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Invalid Player Tab Option!");

		}

	}

	public static void VerifyPlayerDetails() throws Exception {
		try {
			List<AndroidElement> playerInfoList = driver.findElementsById("com.fivemobile.thescore:id/title");
			for (AndroidElement info : playerInfoList) {
				String stat = info.getText();
				if (MainDictionary.PlayerInfo(stat).equals("None")) {
					throw new Exception("Found Stat not Supported Under Player Info!");
				}
			}

		} catch (Exception e) {

		}
	}

}