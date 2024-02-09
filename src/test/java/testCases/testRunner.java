package testCases;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class testRunner extends  ExtentHTMLReport{

    private AndroidDriver driver;

    @BeforeMethod
    public void setupClass() {
        driver = init.initializeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    ExtentTest test;
    @Test(description = "Player Profile Test Case ", priority = 1)
    public void verifyPlayerProfileSuccessfully() throws IOException, ParseException {
        test = extent.createTest("Test Case 1", "Player Profile Test Case");
        test.info("Player Search end 2 end test case is started");
        final PlayerSearchTest pst = new PlayerSearchTest(driver);
        pst.verifyPlayerProfileSuccessfullyE2E();
        test.pass("Player Search end 2 end test case is Pass");
    }

    @Test(description = "Team Test Case ", priority = 2)
    public void verifyTeamSuccessfully() throws IOException, ParseException {
        test = extent.createTest("Test Case 2", "Team search Test Case");
        test.info("Team search end 2 end test case is started");
        final TeamSearchTest tst = new TeamSearchTest(driver);
        tst.verifyTeamSuccessfullyE2E();
        test.pass("Team Search end 2 end test case is Pass");
    }

}

