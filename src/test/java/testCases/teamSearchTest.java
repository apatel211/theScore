package testCases;

import io.appium.java_client.android.AndroidDriver;
import org.page.*;
import org.testng.Assert;
import testData.pageTestData;
import utils.basePage;
import utils.logger;

public class teamSearchTest extends basePage {

    public teamSearchTest(AndroidDriver driver) {
        super(driver);
    }

    pageTestData td = new pageTestData();

    public void verifyTeamSuccessfullyE2E() {

        logger.startTestCase("Team verification test - Successfully started");

        //Get Started Page
        final welcomePage wp = new welcomePage(driver);
        Assert.assertTrue(wp.enterWelcomePage(driver));

        //Login using credentials
        final loginPage lp = new loginPage(driver);
        Assert.assertTrue(lp.enterEmailID());
        lp.enterPassword();

        // Search player name
        final searchPage sp = new searchPage(driver);
        Assert.assertTrue(sp.enterSearchTeamName());

        // Verify team page information
        final teamPage tp = new teamPage(driver);
        Assert.assertEquals(td.teamName,tp.verifyTeamPage());
        Assert.assertEquals(td.teamInfo,tp.verifyTeamPageAnotherTab());

        // Navigate back to home screen
        Assert.assertTrue(sp.verifyBackTabToSearchList());
        Assert.assertTrue(sp.verifyBackTabToHomePage());

        logger.info("Team test - Successfully completed");
    }

}




