package testCases;

import io.appium.java_client.android.AndroidDriver;
import org.json.simple.parser.ParseException;
import org.page.LoginPage;
import org.page.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.logger;

import java.io.IOException;

public class LoginPageTest {

    private AndroidDriver driver;

    @BeforeMethod
    public void setupClass() {
        driver = init.initializeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    WelcomePage wp ;
    LoginPage lp ;

    @Test(description = "Happy Login Test Case")
    public void verifyLoginSuccessfully() throws IOException, ParseException {
        logger.startTestCase("Login test - Successfully started");

        //Get Started Page
         wp = new WelcomePage(driver);
        Assert.assertTrue(wp.enterWelcomePage(driver));

        //Login using credentials
        lp = new LoginPage(driver);
        Assert.assertTrue(lp.enterEmailID());
        Assert.assertTrue(lp.enterPassword());
        Assert.assertTrue(lp.login());
        logger.info("Login test - Successfully completed");
    }

    @Test(description = "Unhappy Login Test Case ")
    public void verifyLoginUnsuccessfully() throws IOException, ParseException {
        logger.startTestCase("Login test failed - Successfully started");

        //Get Started Page
        wp = new WelcomePage(driver);
        Assert.assertTrue(wp.enterWelcomePage(driver));

        //Login using credentials
        lp = new LoginPage(driver);
        Assert.assertTrue(lp.enterEmailID());
        Assert.assertTrue(lp.enterIncorrectPassword());
        Assert.assertTrue(lp.login());
        logger.info("Login test failed - Successfully completed");
    }

}


