package org.page;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import testData.pageTestData;
import utils.basePage;
import utils.logger;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class loginPage extends basePage {
    private final By enterEmail = AppiumBy.xpath("//android.widget.EditText[@resource-id='com.fivemobile.thescore:id/email_input_edittext']");
    private final By enterPassword = AppiumBy.xpath("//android.widget.EditText[@resource-id='com.fivemobile.thescore:id/password_input_edittext']");
    private final By clickLoginButton = AppiumBy.xpath("//android.view.ViewGroup[@resource-id='com.fivemobile.thescore:id/login_button']");

    public loginPage(final AndroidDriver driver) {
        super(driver);
    }
    pageTestData td = new pageTestData();

    // Verify user is able to Login successfully using correct email and password
    public boolean enterLoginPage() {
        final boolean clickLoginButtonElement = wait.until(visibilityOfElementLocated(this.clickLoginButton)).isDisplayed();
        wait.until(visibilityOfElementLocated(this.enterEmail)).sendKeys(td.email);
        logger.info("Email ID entered successfully");
        wait.until(visibilityOfElementLocated(this.enterPassword)).sendKeys(td.password);
        logger.info("Password entered successfully");
        wait.until(visibilityOfElementLocated(this.clickLoginButton)).click();
        logger.info("Clicked on login button successfully");
        return clickLoginButtonElement;
    }

}

