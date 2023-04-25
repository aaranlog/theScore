package TestUtils;

import java.util.*;

/**
 * Contains data that can be found across the app
 * 
 * @author Aaran Logeswaran
 * @version 1.0
 *
 */
public class MainDictionary {

	public static String Leagues(String League) {

		HashMap<String, String> Leagues = new HashMap<String, String>();
		Leagues.put("NHL", "NHL");
		Leagues.put("NBA", "NBA");
		Leagues.put("NFL", "NFL");
		Leagues.put("MLB", "MLB");
		Leagues.put("NASCAR", "NASCAR");
		Leagues.put("England Soccer", "EPL");

		if (Leagues.containsKey(League)) {
			return Leagues.get(League);
		} else {
			return "None";
		}

	}
	
	public static String NBATeams(String Team) {

		HashMap<String, String> NBATeams = new HashMap<String, String>();
		NBATeams.put("Hawks", "ATL");
		NBATeams.put("Celtics", "BOS");
		NBATeams.put("Nets", "BKN");
		NBATeams.put("Hornets", "CHA");
		NBATeams.put("Bulls", "CHI");
		NBATeams.put("Cavaliers", "CLE");
		NBATeams.put("Mavericks", "DAL");
		NBATeams.put("Nuggets", "DEN");
		NBATeams.put("Pistons", "DET");
		NBATeams.put("Warriors", "GS");
		NBATeams.put("Rockets", "HOU");
		NBATeams.put("Pacers", "IND");
		NBATeams.put("Clippers", "LAC");
		NBATeams.put("Lakers", "LAL");
		NBATeams.put("Grizzlies", "MEM");
		NBATeams.put("Heat", "MIA");
		NBATeams.put("Bucks", "MIL");
		NBATeams.put("Timberwolves", "MIN");
		NBATeams.put("Pelicans", "NO");
		NBATeams.put("Knicks", "NY");
		NBATeams.put("Thunder", "OKC");
		NBATeams.put("Magic", "ORL");
		NBATeams.put("76ers", "PHI");
		NBATeams.put("Suns", "PHX");
		NBATeams.put("Trail Blazers", "POR");
		NBATeams.put("Kings", "SAC");
		NBATeams.put("Spurs", "SA");
		NBATeams.put("Raptors", "TOR");
		NBATeams.put("Jazz", "UTA");
		NBATeams.put("Wizards", "WSH");


		if (NBATeams.containsKey(Team)) {
			return NBATeams.get(Team);
		} else {
			return "None";
		}

	}
	public static String PlayerInfo(String Stat) {

		HashMap<String, String> PlayerInfo = new HashMap<String, String>();
		PlayerInfo.put("Birth Date", "1");
		PlayerInfo.put("Birth Place", "2");
		PlayerInfo.put("Height", "3");
		PlayerInfo.put("Weight", "4");
		PlayerInfo.put("Draft", "5");
		PlayerInfo.put("School", "6");



		if (PlayerInfo.containsKey(Stat)) {
			return PlayerInfo.get(Stat);
		} else {
			return "None";
		}

	}	

	public static String LeaguesTabs(String Tab) {

		HashMap<String, String> LeaguesTabs = new HashMap<String, String>();
		LeaguesTabs.put("Scores", "1");
		LeaguesTabs.put("News", "2");
		LeaguesTabs.put("Chat", "3");
		LeaguesTabs.put("Standings", "4");
		LeaguesTabs.put("Leaders", "5");
		LeaguesTabs.put("Fixtures", "6");
		LeaguesTabs.put("Table", "6");
		LeaguesTabs.put("Results", "7");



		if (LeaguesTabs.containsKey(Tab)) {
			return LeaguesTabs.get(Tab);
		} else {
			return "None";
		}

	}
	
	public static String SubTabs(String Tab) {

		HashMap<String, String> SubTabs = new HashMap<String, String>();
		SubTabs.put("Playoffs", "1");
		SubTabs.put("Conference", "1");
		SubTabs.put("Division", "1");
		SubTabs.put("Overall", "1");
		if (SubTabs.containsKey(Tab)) {
			return SubTabs.get(Tab);
		} else {
			return "None";
		}

	}

	public static String TeamsTabs(String Tab) {

		HashMap<String, String> TeamsTabs = new HashMap<String, String>();
		TeamsTabs.put("News", "1");
		TeamsTabs.put("Chat", "2");
		TeamsTabs.put("Teams Stats", "3");
		TeamsTabs.put("Schedule", "4");
		TeamsTabs.put("Player Stats", "5");
		TeamsTabs.put("Roster", "6");
		TeamsTabs.put("Info", "7");

		if (TeamsTabs.containsKey(Tab)) {
			return TeamsTabs.get(Tab);
		} else {
			return "None";
		}

	}

	public static String PlayersTabs(String Tab) {

		HashMap<String, String> PlayersTabs = new HashMap<String, String>();
		PlayersTabs.put("News", "1");
		PlayersTabs.put("Stats", "2");
		PlayersTabs.put("Game Log", "3");
		PlayersTabs.put("Info", "4");


		if (PlayersTabs.containsKey(Tab)) {
			return PlayersTabs.get(Tab);
		} else {
			return "None";
		}

	}

}