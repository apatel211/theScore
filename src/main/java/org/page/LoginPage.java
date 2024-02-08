package org.page;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import testData.PageTestData;
import utils.BasePage;
import utils.JsonParser;
import utils.logger;

import java.io.IOException;
import java.text.ParseException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginPage extends BasePage {
    private final By enterEmail = AppiumBy.xpath("//android.widget.EditText[@resource-id='com.fivemobile.thescore:id/email_input_edittext']");
    private final By enterPassword = AppiumBy.xpath("//android.widget.EditText[@resource-id='com.fivemobile.thescore:id/password_input_edittext']");
    private final By clickLoginButton = AppiumBy.xpath("//android.view.ViewGroup[@resource-id='com.fivemobile.thescore:id/login_button']");

    public LoginPage(final AndroidDriver driver) {
        super(driver);
    }
    PageTestData td = new PageTestData();

    // Verify user is able to Login successfully using correct email and password
    public boolean enterEmailID() {
        final boolean emailIDElement = wait.until(visibilityOfElementLocated(this.enterEmail)).isDisplayed();
        wait.until(visibilityOfElementLocated(this.enterEmail)).sendKeys(td.email);
        logger.info("Email ID entered successfully");
        return emailIDElement;
    }

    public boolean enterPassword() {
        final boolean passwordElement = wait.until(visibilityOfElementLocated(this.enterPassword)).isDisplayed();
        wait.until(visibilityOfElementLocated(this.enterPassword)).sendKeys(td.password);
        logger.info("Password entered successfully");
        return passwordElement;
    }

    public boolean enterPasswordWrong() throws IOException, ParseException, org.json.simple.parser.ParseException {
        final boolean passwordElement = wait.until(visibilityOfElementLocated(this.enterPassword)).isDisplayed();
        wait.until(visibilityOfElementLocated(this.enterPassword)).sendKeys(JsonParser.getTestData("password"));
        logger.info("Password entered successfully");
        return passwordElement;
    }

    public boolean login() {
        final boolean clickLoginButtonElement = wait.until(visibilityOfElementLocated(this.clickLoginButton)).isDisplayed();
        wait.until(visibilityOfElementLocated(this.clickLoginButton)).click();
        logger.info("Clicked on login button successfully");
        return clickLoginButtonElement;
    }

}

