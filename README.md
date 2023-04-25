# theScore
Automation suite used to test theScore mobile app

## Installation/Prerequisites 
- In order to use the framework we need to have the latest app installed from the playstore, https://play.google.com/store/apps/details?id=com.fivemobile.thescore&hl=en_CA&gl=US
- ANDROID_HOME system variable is mapped
- Appium 1.22
- Maven 3.8.1
- Java 11

## Usage
First you must configure the properties with your phone udid and android version run the command. Assuming you are in the project directory run,
  - mvn -e -Dtest=UpdateConfigProperties -DPhone_Udid={udid} -DPlatform_Version{version}
Next run the test,
  - mvn clean test -Dsurefire.suiteXmlFiles=.\src\test\resources\FindPlayer.xml


## Current Coverage
- [x] Create first time profile on install
- [x] Conduct Searches for players, teams and leagues
- [x] Navigate to any specified sub-category in player, team or league pages
- [x] Monitor previous and current page states
- [x] Verify headers associated to personal info of players 

## Motive 
Test automation is a fundamental componment of the software delivery cycle. Fast, low cost and effective automated tests that are continuosly being run increase confidence in the quality of the product being released. Having these tests starts with developing a framework that embodies this which I believe I have begun. Clutter is something I hate, and having common tests that can be used to test different features acheives this. Data driven tests allow us to increase the coverage and parameterizing the tests achieves this. XMLs were used with the vision of eventually listing a suite of XMLs in a JSON that can be used to run on a schedule.  

### Note
- Only tested against 2 android versions (9 and 13)
- Tested with real devices
- Framework currently does not support IOS
- Framework was developed and tested in Windows (no Linux environment available to test)
- Looking to update the MainDictionary with some JSON database

