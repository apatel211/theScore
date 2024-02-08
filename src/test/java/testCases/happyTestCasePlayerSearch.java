package testCases;

import io.appium.java_client.android.AndroidDriver;
import org.page.*;
import org.testng.Assert;
import testData.pageTestData;
import org.page.basePage;
import utils.logger;

public class happyTestCasePlayerSearch extends basePage {

    public happyTestCasePlayerSearch(AndroidDriver driver) {
        super(driver);
    }

    pageTestData td = new pageTestData();

    public void verifyPlayerProfileSuccessfully() {

        logger.startTestCase("Player profile verification test - Successfully started");

        //Get Started Page
        final welcomePage wp = new welcomePage(driver);
        Assert.assertTrue(wp.enterWelcomePage(driver));

        //Login using credentials
        final loginPage lp = new loginPage(driver);
        Assert.assertTrue(lp.enterLoginPage());

        // Search player name
        final searchPage sp = new searchPage(driver);
        Assert.assertTrue(sp.enterSearchPlayerName());

        // Verify player page information
        final playerPage pp = new playerPage(driver);
        Assert.assertEquals(td.playerName,pp.verifyPlayerPage());
        Assert.assertEquals(td.playerInfo,pp.verifyPlayerPageAnotherTab());

        // Navigate back to home screen
        Assert.assertTrue(sp.verifyBackTabToSearchList());
        Assert.assertTrue(sp.verifyBackTabToHomePage());

        logger.info("Player profile verification test - Successfully completed");
    }

}

