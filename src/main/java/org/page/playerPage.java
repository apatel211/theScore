package org.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import testData.pageTestData;
import utils.basePage;
import utils.logger;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class playerPage extends basePage {
    private final By newsTab= AppiumBy.xpath("//android.widget.LinearLayout[@content-desc='News']");
    private final By infoTab = AppiumBy.xpath("//android.widget.TextView[@text='INFO']");
    private final By playerNameText = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/txt_player_name']");
    private final By infoTabText = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/title' and @text='Birth Date']");

    public playerPage(final AndroidDriver driver) {
        super(driver);
    }

    // Verify player page
    public String verifyPlayerPage() {
        final String playerNameTextElement = wait.until(visibilityOfElementLocated(this.playerNameText)).getText();
        wait.until(visibilityOfElementLocated(this.newsTab)).click();
        logger.info("User on news tab successfully");
        return playerNameTextElement;
    }

    // Verify another tab data
    public String verifyPlayerPageAnotherTab() {
        wait.until(visibilityOfElementLocated(this.infoTab)).click();
        logger.info("User on info tab successfully");
        final String infoTabTextElement = wait.until(visibilityOfElementLocated(this.infoTabText)).getText();
        logger.info("verify info tab data successfully ");
        return infoTabTextElement;
    }

}
