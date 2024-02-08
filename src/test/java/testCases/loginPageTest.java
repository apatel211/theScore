package testCases;

import io.appium.java_client.android.AndroidDriver;
import org.page.loginPage;
import org.page.welcomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.logger;

public class loginPageTest{

    private AndroidDriver driver;

    @BeforeMethod
    public void setupClass() {
        driver = init.initializeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(description = "Happy Login Test Case")
    public void verifyLoginSuccessfully() {
        logger.startTestCase("Login test - Successfully started");

        //Get Started Page
        welcomePage wp = new welcomePage(driver);
        Assert.assertTrue(wp.enterWelcomePage(driver));

        //Login using credentials
        loginPage lp = new loginPage(driver);
        Assert.assertTrue(lp.enterEmailID());
        Assert.assertTrue(lp.enterPassword());
        Assert.assertTrue(lp.login());
        logger.info("Login test - Successfully completed");
    }

    @Test(description = "Unhappy Login Test Case ")
    public void verifyLoginUnsuccessfully() {
        logger.startTestCase("Login test failed - Successfully started");

        //Get Started Page
        welcomePage wp = new welcomePage(driver);
        Assert.assertTrue(wp.enterWelcomePage(driver));

        //Login using credentials
        loginPage lp = new loginPage(driver);
        Assert.assertTrue(lp.enterEmailID());
        Assert.assertTrue(lp.enterPasswordWrong());
        Assert.assertTrue(lp.login());
        logger.info("Login test failed - Successfully completed");
    }

}


