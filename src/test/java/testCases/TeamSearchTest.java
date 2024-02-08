package testCases;

import io.appium.java_client.android.AndroidDriver;
import org.json.simple.parser.ParseException;
import org.page.*;
import org.testng.Assert;
import testData.PageTestData;
import utils.BasePage;
import utils.logger;

import java.io.IOException;

public class TeamSearchTest extends BasePage {

    public TeamSearchTest(AndroidDriver driver) {
        super(driver);
    }

    PageTestData td = new PageTestData();

    public void verifyTeamSuccessfullyE2E() throws IOException, ParseException {

        logger.startTestCase("Team verification test - Successfully started");

        //Get Started Pages
        WelcomePage wp = new WelcomePage(driver);
        Assert.assertTrue(wp.enterWelcomePage(driver));

        //Login using credentials
        LoginPage lp = new LoginPage(driver);
        Assert.assertTrue(lp.enterEmailID());
        Assert.assertTrue(lp.enterPassword());
        Assert.assertTrue(lp.login());

        // Search player name
        final SearchPage sp = new SearchPage(driver);
        Assert.assertTrue(sp.enterSearchTeamName());

        // Verify team page information
        final TeamPage tp = new TeamPage(driver);
        Assert.assertEquals(td.teamName,tp.verifyTeamPage());
        Assert.assertEquals(td.teamInfo,tp.verifyTeamPageAnotherTab());

        // Navigate back to home screen
        Assert.assertTrue(sp.verifyBackTabToSearchList());
        Assert.assertTrue(sp.verifyBackTabToHomePage());

        logger.info("Team test - Successfully completed");
    }

}




