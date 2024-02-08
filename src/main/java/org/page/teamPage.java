package org.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.basePage;
import utils.logger;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class teamPage extends basePage {
    private final By newsTab= AppiumBy.xpath("//android.widget.TextView[@text='NEWS']");
    private final By playerStatsTab = AppiumBy.xpath("//android.widget.TextView[@text='PLAYER STATS']");
    private final By teamNameText = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/team_name']");
    private final By playerStatsTabText = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/txt_name' and @text='PLAYERS']");

    public teamPage(final AndroidDriver driver) {
        super(driver);
    }

    // Verify team page
    public String verifyTeamPage() {
        final String teamNameTextElement = wait.until(visibilityOfElementLocated(this.teamNameText)).getText();
        wait.until(visibilityOfElementLocated(this.newsTab)).click();
        logger.info("User on team tab successfully");
        return teamNameTextElement;
    }

    // Verify another tab data
    public String verifyTeamPageAnotherTab() {
        wait.until(visibilityOfElementLocated(this.playerStatsTab)).click();
        logger.info("User on player Stats tab successfully");
        final String infoTabTextElement = wait.until(visibilityOfElementLocated(this.playerStatsTabText)).getText();
        logger.info("verify player Stats Tab Text data successfully ");
        return infoTabTextElement;
    }

}


