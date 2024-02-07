package org.page;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.helper;
import utils.logger;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class welcomePage extends basePage {
    private final By welcomeText = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/txt_welcome']");
    private final By clickLoginUrl = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/txt_sign_in']");

    public welcomePage(final AndroidDriver driver) {
        super(driver);
    }

    // Verify welcome page and click on login url
    public boolean enterWelcomePage(final AndroidDriver driver) {
        final boolean welcomeTextElement = wait.until(visibilityOfElementLocated(this.welcomeText)).isDisplayed();
        final WebElement clickLoginUrlTap= wait.until(visibilityOfElementLocated(this.clickLoginUrl));
        logger.info("Clicked on home Page successfully ");
        helper.tap(driver, clickLoginUrlTap);
        logger.info("Enter email ID and password ");
        return welcomeTextElement;
    }


}
