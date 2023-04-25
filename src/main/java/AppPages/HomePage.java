package AppPages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import TestUtils.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * This contains the elements and functions related that can
 * be performed from the starting page on the app
 * 
 * @author Aaran Logeswaran
 * @version 1.0
 *
 */

public class HomePage extends AppiumController {

	@AndroidFindBy(id = "com.fivemobile.thescore:id/dismiss_modal")
	static MobileElement closePopup;
	@AndroidFindBy(id = "com.fivemobile.thescore:id/search_bar_text_view")
	static MobileElement searchBar;
	@AndroidFindBy(id = "com.fivemobile.thescore:id/search_src_text")
	static MobileElement searchBarText;
	@AndroidFindBy(id = "com.fivemobile.thescore:id/empty_state_title")
	static MobileElement emptyPage;
	@AndroidFindBy(id = "com.fivemobile.thescore:id/txt_name")
	static MobileElement searchResult;
	@AndroidFindBy(accessibility = "Navigate up")
	static MobileElement backButton;

	public HomePage(AndroidDriver<?> appiumDriver) {
		AppiumController.adriver = appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}

	public static void ClosePopup() throws Exception {
		try {
			if (closePopup.isDisplayed()) {
				closePopup.click();
			}
		} catch (NoSuchElementException e) {
			System.out.println("No Pop-Up to Close!");

		}
	}

	public static void UseSearch(String Value, String Type) throws Exception {
		AndroidElement league = null;
		boolean notLeague = false;
		try {
			if (Type.equals("Leagues")) {
				notLeague =MainDictionary.Leagues(Value).equals("None");
				if (notLeague) {
					System.out.println("Invalid League!");
				} else {
					UpdatePageStates(driver.getPageSource());
					driver.findElementByAccessibilityId(Type).click();
					league = driver.findElementByAndroidUIAutomator(
							"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
									+ Value + "\").instance(0))");
				}
			} else {
				UpdatePageStates(driver.getPageSource());
				searchBar.click();
				searchBarText.sendKeys(Value);
				if ((driver.findElementByAccessibilityId(Type)).isDisplayed()) {
					System.out.println("Going into Tab!");
					(driver.findElementByAccessibilityId(Type)).click();
					UpdatePageStates(driver.getPageSource());
				}
				if (emptyPage.isDisplayed()) {
					throw new Exception(Value + " is Not Found Under " + Type);
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("Valid Entry!");

		} finally {
			if (Type.equals("Leagues")) {
				if (!notLeague) {
					league.click();
					UpdatePageStates(driver.getPageSource());
				}
			} else if (searchResult.getText().contains(Value)) {
				searchResult.click();
				UpdatePageStates(driver.getPageSource());
			} else {
				Assert.fail("Search Returned Unexpected Result!");
			}
		}
	}
	public static void NavigateBack() throws Exception {
		try {	
			backButton.click();
			System.out.println("PREV: " + PreviousPage);
			System.out.println("CUR: " + driver.getPageSource());

			if(driver.getPageSource() != PreviousPage) {
				System.out.println("Doesnt Work!");
			}else {
				System.out.println("Work!");

			}
			UpdatePageStates(driver.getPageSource());
			
		} catch (NoSuchElementException e) {
		}
	}
	
	public static void NavigateHome() throws Exception {
		try {
			while (backButton.isDisplayed()) {
				backButton.click();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Returned Home!");
		}
	}

}