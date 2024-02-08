package org.page;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import utils.BasePage;
import utils.JsonParser;
import utils.logger;

import java.io.IOException;


import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginPage extends BasePage {
    private final By enterEmail = AppiumBy.xpath("//android.widget.EditText[@resource-id='com.fivemobile.thescore:id/email_input_edittext']");
    private final By enterPassword = AppiumBy.xpath("//android.widget.EditText[@resource-id='com.fivemobile.thescore:id/password_input_edittext']");
    private final By clickLoginButton = AppiumBy.xpath("//android.view.ViewGroup[@resource-id='com.fivemobile.thescore:id/login_button']");

    public LoginPage(final AndroidDriver driver) {
        super(driver);
    }

    // Verify user is able to Login successfully using correct email and password
    public boolean enterEmailID() throws IOException, ParseException {
        final boolean emailIDElement = wait.until(visibilityOfElementLocated(this.enterEmail)).isDisplayed();
        wait.until(visibilityOfElementLocated(this.enterEmail)).sendKeys(JsonParser.getTestData("email"));
        logger.info("Email ID entered successfully");
        return emailIDElement;
    }

    public boolean enterPassword() throws IOException, ParseException {
        final boolean passwordElement = wait.until(visibilityOfElementLocated(this.enterPassword)).isDisplayed();
        wait.until(visibilityOfElementLocated(this.enterPassword)).sendKeys(JsonParser.getTestData("correctPassword"));
        logger.info("Password entered successfully");
        return passwordElement;
    }

    public boolean enterIncorrectPassword() throws IOException, ParseException {
        final boolean passwordElement = wait.until(visibilityOfElementLocated(this.enterPassword)).isDisplayed();
        wait.until(visibilityOfElementLocated(this.enterPassword)).sendKeys(JsonParser.getTestData("incorrectPassword"));
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

