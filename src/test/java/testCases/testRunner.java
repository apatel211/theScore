package testCases;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testRunner{

    private AndroidDriver driver;

    @BeforeMethod
    public void setupClass() {
        driver = init.initializeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(description = "Player Profile Test Case ", priority = 1)
    public void verifyPlayerProfileSuccessfully() {
        final PlayerSearchTest pst = new PlayerSearchTest(driver);
        pst.verifyPlayerProfileSuccessfullyE2E();
    }

    @Test(description = "Team Test Case ", priority = 2)
    public void verifyTeamSuccessfully() {
        final TeamSearchTest tst = new TeamSearchTest(driver);
        tst.verifyTeamSuccessfullyE2E();
    }

}

