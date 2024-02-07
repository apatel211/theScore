package org.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import testData.pageTestData;
import utils.logger;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class searchPage extends basePage {

    //private final By allowLocation = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/btn_allow']");
    private final By scoresTitle = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/navigation_bar_item_large_label_view']");
    private final By clickOnSearchBar = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/search_bar_text_view']");
    private final By enterOnSearchBar = AppiumBy.xpath("//android.widget.AutoCompleteTextView[@resource-id='com.fivemobile.thescore:id/search_src_text']");
    private final By clickOnSearchText =AppiumBy.xpath("//android.widget.TextView[@index='1']");

    private final By backButton =AppiumBy.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");

    private final By searchList =AppiumBy.xpath("//android.widget.LinearLayout[@content-desc='All']");
    public searchPage(final AndroidDriver driver) {
        super(driver);
    }
    pageTestData td = new pageTestData();

    // Verify user is able to search using player name
    public boolean enterSearchPlayerName() {
        final boolean scoresTitleElement = wait.until(visibilityOfElementLocated(this.scoresTitle)).isDisplayed();
        logger.info("scores title is displayed");

//        wait.until(visibilityOfElementLocated(this.allowLocation)).click();
//        logger.info("Click on allow location successfully");
//        if (wait.until(ExpectedConditions.alertIsPresent())!= null ) {
//            Alert alert = driver.switchTo().alert();
//            alert.accept();
//            System.out.println("Alert is not present");
//        } else{
//            System.out.println("Alert is not present");
//        }

        wait.until(visibilityOfElementLocated(this.clickOnSearchBar)).click();
        wait.until(visibilityOfElementLocated(this.enterOnSearchBar)).sendKeys(td.playerName);

        logger.info("Player name entered successfully");
        wait.until(visibilityOfElementLocated(this.clickOnSearchText)).click();
        logger.info("Welcome to player profile");
        return scoresTitleElement;
    }



    // Verify user is able to search using team name
    public boolean enterSearchTeamName() {
        final boolean scoresTitleElement = wait.until(visibilityOfElementLocated(this.scoresTitle)).isDisplayed();
        logger.info("scores title is displayed");

//        wait.until(visibilityOfElementLocated(this.allowLocation)).click();
//        logger.info("Click on allow location successfully");
//        if (wait.until(ExpectedConditions.alertIsPresent())!= null ) {
//            Alert alert = driver.switchTo().alert();
//            alert.accept();
//            System.out.println("Alert is not present");
//        } else{
//            System.out.println("Alert is not present");
//        }

        wait.until(visibilityOfElementLocated(this.clickOnSearchBar)).click();
        wait.until(visibilityOfElementLocated(this.enterOnSearchBar)).sendKeys(td.teamName);

        logger.info("team name entered successfully");
        wait.until(visibilityOfElementLocated(this.clickOnSearchText)).click();
        logger.info("Welcome to team profile");
        return scoresTitleElement;
    }

    // Verify user is navigate back to search list
    public boolean verifyBackTabToSearchList() {
        wait.until(visibilityOfElementLocated(this.backButton)).click();
        logger.info("Clicked on back button successfully");
        final boolean searchListElement = wait.until(visibilityOfElementLocated(this.searchList)).isDisplayed();
        logger.info("scores title is displayed");
        return searchListElement;
    }

    // Verify user is navigate back to home page
    public boolean verifyBackTabToHomePage() {
        wait.until(visibilityOfElementLocated(this.backButton)).click();
        logger.info("Clicked on back button successfully");
        final boolean scoresTitleElement = wait.until(visibilityOfElementLocated(this.scoresTitle)).isDisplayed();
        logger.info("scores title is displayed");
        return scoresTitleElement;
    }
}
