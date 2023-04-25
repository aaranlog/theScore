package AppPages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import TestUtils.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * This contains the elements and functions related to the first time install of
 * theScore app
 * 
 * @author Aaran Logeswaran
 * @version 1.0
 *
 */

public class RegisterPage extends AppiumController {

	@AndroidFindBy(id = "com.fivemobile.thescore:id/action_button_text")
	static MobileElement button;
	@AndroidFindBy(id = "com.fivemobile.thescore:id/btn_allow")
	static MobileElement allowButton;
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	static MobileElement allowPermission;
	@AndroidFindBy(id = "com.fivemobile.thescore:id/search_bar_placeholder")
	static MobileElement searchBar;
	@AndroidFindBy(id = "com.fivemobile.thescore:id/search_src_text")
	static MobileElement searchBarText;
	@AndroidFindBy(id = "com.fivemobile.thescore:id/empty_state_title")
	static MobileElement emptyPage;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.ImageView[2]")
	static MobileElement favouriteTeam;
	@AndroidFindBy(id = "com.fivemobile.thescore:id/dismiss_modal")
	static MobileElement closePopup;
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	static MobileElement newAllowLocation;

	public RegisterPage(AndroidDriver<?> appiumDriver) {
		AppiumController.adriver = appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}

	public static void CreateProfile(String Favourite_Team) throws Exception {
		try {
			if (button.getText().equals("Get Started")) {
				UpdatePageStates(driver.getPageSource());
				button.click();
			} else {
				Assert.fail("Did not Find Get Started Button");
			}
			if (button.getText().equals("Continue")) {
				UpdatePageStates(driver.getPageSource());
				button.click();

			} else {
				Assert.fail("Did not Find Continue Button");
			}
			UpdatePageStates(driver.getPageSource());
			allowButton.click();
			UpdatePageStates(driver.getPageSource());
			if (prop.getProperty("Platform_Version").equals("9")) {
				allowPermission.click();
			} else {
				newAllowLocation.click();
			}
			UpdatePageStates(driver.getPageSource());
			searchBar.click();
			UpdatePageStates(driver.getPageSource());
			searchBarText.sendKeys(Favourite_Team);
			if (emptyPage.isDisplayed()) {
				System.out.println("Invalid Entry!");
			}

		} catch (NoSuchElementException e) {
			System.out.println("Valid Team!");
		} finally {
			favouriteTeam.click();
			UpdatePageStates(driver.getPageSource());
			if (button.getText().equals("Continue")) {
				button.click();
				UpdatePageStates(driver.getPageSource());
			} else {
				Assert.fail("Did not Find Continue Button");
			}
			if (button.getText().equals("Done")) {
				button.click();
				UpdatePageStates(driver.getPageSource());
				if (!(prop.getProperty("Platform_Version").equals("9"))) {
					allowPermission.click();
					UpdatePageStates(driver.getPageSource());
				}
			} else {
				Assert.fail("Did not Find Continue Button");
			}

		}
	}
}