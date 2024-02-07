package test;

import io.appium.java_client.android.AndroidDriver;
import org.page.*;
import org.testng.Assert;
import utils.basePage;
import utils.logger;

public class happyCoverage extends basePage {

    public happyCoverage (AndroidDriver driver) {
        super(driver);
    }

    public void verifyPlayerProfileSuccessfully() {

        logger.startTestCase("Happy Test - Successfully started");

        final welcomePage wp = new welcomePage(driver);
        Assert.assertTrue(wp.enterWelcomePage(driver));

        final loginPage lp = new loginPage(driver);
        Assert.assertTrue(lp.enterLoginPage());

        final searchPage sp = new searchPage(driver);
        Assert.assertTrue(sp.enterSearchText());

        logger.info("Happy Test - Successfully completed");
    }

}

