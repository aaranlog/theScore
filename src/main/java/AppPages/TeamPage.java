package AppPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import TestUtils.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TeamPage extends AppiumController {

	@AndroidFindBy(accessibility = "News")
	static MobileElement newsTab;
	@AndroidFindBy(accessibility = "Team Stats")
	static MobileElement statsTab;
	@AndroidFindBy(accessibility = "Schedule")
	static MobileElement gameLogTab;
	@AndroidFindBy(accessibility = "Info")
	static MobileElement infoTab;
	@AndroidFindBy(id = "com.fivemobile.thescore:id/team_name")
	static MobileElement teamName;

	public TeamPage(AndroidDriver<?> appiumDriver) {
		AppiumController.adriver = appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}

	@SuppressWarnings("finally")
	public static boolean IsTeam(String Team) throws Exception {
		boolean isTeam = false;
		try {
			if ((teamName.getText()).contains(Team)) {
				isTeam = true;
			}

		} catch (NoSuchElementException e) {
			System.out.println("Not On a Player Page!");

		} finally {
			return isTeam;
		}
	}

	public static void EnterTeamTab(String Tab) throws Exception {
		try {
			if (driver.findElement(By.name(Tab)).isDisplayed()) {
				driver.findElement(By.name(Tab)).click();
			}
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Invalid Team Tab Option!");

		}
	}

}