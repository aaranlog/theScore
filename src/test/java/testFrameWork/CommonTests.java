package testFrameWork;

import org.testng.annotations.*;
import TestUtils.*;
import AppPages.*;

/**
 * This contains the Common tests  
 * 
 * @author Aaran Logeswaran
 * @version 1.0
 *
 */


public class CommonTests {

	/**
	 * Test that Initializes the Appium Session
	 * @throws Exception
	 */

	@Test
	public void AppiumSetUp() throws Exception {

		try {
			BaseTestClass.SetUpAppium();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to Set Appium");
		}
	}

	/**
	 * Test that first time configures the app
	 * @param FAVOURITE_TEAM team used to configure personal profile
	 * @throws Exception
	 */
	
	@Parameters("FAVOURITE_TEAM")
	@Test
	public void CreatePersonalProfile(String Favourite_Team) throws Exception {

		try {
			RegisterPage.CreateProfile(Favourite_Team);
			HomePage.ClosePopup();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to Set Appium");
		}
	}
	
	/**
	 * 
	 * A test that searches for a Team, Player or League 
	 * @param VALUE: The name that is to be searched, ie "Toronto Maple leafs" OR "Pascal Siakam" OR "MLB"
	 * @param TYPE:  The descriptor of the provided VALUE, ie "Teams", OR "Players" OR "LEAGUES"
	 * @throws Exception
	 */

	@Parameters({ "VALUE", "TYPE" })
	@Test
	public void Search(String Value, String Type) throws Exception {
		try {
			HomePage.UseSearch(Value, Type);
			if ((Type.equals("Players")) && (!PlayerPage.IsPlayer(Value))) {
				throw new Exception("Search Did Not Return Player!");
			} else if ((Type.equals("Teams")) && (!TeamPage.IsTeam(Value))) {
				throw new Exception("Search Did Not Return Team!");
			} else if (Type.equals("Leagues") && (!LeaguePage.IsLeague(Value))) {
				throw new Exception("Search Did Not Return League!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to Set Appium");
		}
	}

	/**
	 * 
	 * A test that enters a spsecified sub tab 
	 * @param VALUE: The name that is to be searched, ie "Toronto Maple leafs" OR "Pascal Siakam" OR "MLB"
	 * @param TYPE:  The descriptor of the provided VALUE, ie "Teams", OR "Players" OR "LEAGUES"
	 * @throws Exception
	 */

	@Parameters({"TYPE", "TAB"})
	@Test
	public void EnterTab(String Type, String Tab) throws Exception {
		try {
			if (Type.equals("Players")) {
				PlayerPage.EnterPlayerTab(Tab);
			} else if (Type.equals("Teams"))  {
				TeamPage.EnterTeamTab(Tab);
			} else if (Type.equals("Leagues"))  {
				LeaguePage.EnterLeagueTab(Tab);
			}else {
				throw new Exception("Invalid Tab " + Tab + " for Type " + Type);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to Enter Tab " + Tab);
		}
	}
	
	/**
	 * 
	 * A test that enters a spsecified sub tab 
	 * @param VALUE: The name that is to be searched, ie "Toronto Maple leafs" OR "Pascal Siakam" OR "MLB"
	 * @param TYPE:  The descriptor of the provided VALUE, ie "Teams", OR "Players" OR "LEAGUES"
	 * @throws Exception
	 */

	
	@Test
	public void CheckPlayerInfo() throws Exception {
		try {
			PlayerPage.VerifyPlayerDetails();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to Confirm Player Details!");
		}
	}
	/**
	 * 
	 * A test that searches for a Team, Player or League 
	 * @param VALUE: The name that is to be searched, ie "Toronto Maple leafs" OR "Pascal Siakam" OR "MLB"
	 * @param TYPE:  The descriptor of the provided VALUE, ie "Teams", OR "Players" OR "LEAGUES"
	 * @throws Exception
	 */

	
	/**
	 * 
	 * A test that returns the app to a usable state for new tests to be run
	 * 
	 * 
	 * @throws Exception
	 */

	@Test
	public void Cleanup() throws Exception {
		try {
			HomePage.NavigateHome();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to Tear Down");
		}
	}

	/**
	 * Tear down Appium sessions
	 * 
	 * @throws Exception
	 */
	@Test
	public void TearDownAppium() throws Exception {
		try {
			BaseTestClass.tearDown();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to Tear Down");
		}
	}

}
