package AppPages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import TestUtils.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * This contains the elements and functions that can be performed
 * when on a defined league page 
 * 
 * @author Aaran Logeswaran
 * @version 1.0
 *
 */
public class LeaguePage extends AppiumController {

	// Define UI Elements Unique to the Leagues Page
	@AndroidFindBy(id = "com.fivemobile.thescore:id/titleTextView")
	static MobileElement leagueName;
	@AndroidFindBy(id = "com.fivemobile.thescore:id/viewPager")
	static MobileElement leagueTable;
	static String Table = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]";

	public LeaguePage(AndroidDriver<?> appiumDriver) {
		AppiumController.adriver = appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}

	@SuppressWarnings("finally")
	public static boolean IsLeague(String League) throws Exception {
		boolean isLeague = false;
		try {

			if ((leagueName.getText()).contains(League)) {
				isLeague = true;
			}

		} catch (NoSuchElementException e) {
			System.out.println("Not On a League Page!");

		} finally {
			return isLeague;
		}
	}

	public static void EnterLeagueTab(String Tab) throws Exception {
		try {
			if (MainDictionary.LeaguesTabs(Tab) != "None") {
				if ((driver.findElementByAccessibilityId(Tab)).isDisplayed()) {
					System.out.println("Going into Tab!");
					(driver.findElementByAccessibilityId(Tab)).click();

				}
			} else {
				throw new Exception("Tab " + Tab + " not Supported Under Leagues!");
			}

		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Invalid Team Tab Option!");

		}
	}

	public static void EnterSubTab(String Tab) throws Exception {
		try {
			if (MainDictionary.SubTabs(Tab) != "None") {
				if ((driver.findElementByAccessibilityId(Tab)).isDisplayed()) {
					System.out.println("Going into Sub Tab!");
					(driver.findElementByAccessibilityId(Tab)).click();

				}
			} else {
				throw new Exception("Tab " + Tab + " not Supported Under Leagues!");
			}

		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Invalid Team Tab Option!");

		}
	}

}