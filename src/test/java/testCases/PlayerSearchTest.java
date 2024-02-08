package testCases;

import io.appium.java_client.android.AndroidDriver;
import org.page.*;
import org.testng.Assert;
import testData.PageTestData;
import utils.BasePage;
import utils.logger;

public class PlayerSearchTest extends BasePage {

    public PlayerSearchTest(AndroidDriver driver) {
        super(driver);
    }

    PageTestData td = new PageTestData();

    public void verifyPlayerProfileSuccessfullyE2E() {

        logger.startTestCase("Player profile verification test - Successfully started");

        //Get Started Page
        final WelcomePage wp = new WelcomePage(driver);
        Assert.assertTrue(wp.enterWelcomePage(driver));

        //Login using credentials
        final LoginPage lp = new LoginPage(driver);
        Assert.assertTrue(lp.enterEmailID());
        Assert.assertTrue(lp.enterPassword());
        Assert.assertTrue(lp.login());

        // Search player name
        final SearchPage sp = new SearchPage(driver);
        Assert.assertTrue(sp.enterSearchPlayerName());

        // Verify player page information
        final PlayerPage pp = new PlayerPage(driver);
        Assert.assertEquals(td.playerName,pp.verifyPlayerPage());
        Assert.assertEquals(td.playerInfo,pp.verifyPlayerPageAnotherTab());

        // Navigate back to home screen
        Assert.assertTrue(sp.verifyBackTabToSearchList());
        Assert.assertTrue(sp.verifyBackTabToHomePage());

        logger.info("Player profile verification test - Successfully completed");
    }

}

