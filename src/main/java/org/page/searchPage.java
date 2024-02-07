package org.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testData.pageTestData;
import utils.basePage;
import utils.logger;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class searchPage extends basePage {

    private final By allowLocation = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/btn_allow']");
    private final By scoresTitle = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/navigation_bar_item_large_label_view']");
    private final By clickOnSearchBar = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/search_bar_text_view']");
    private final By enterOnSearchBar = AppiumBy.xpath("//android.widget.AutoCompleteTextView[@resource-id='com.fivemobile.thescore:id/search_src_text']");
    private final By clickOnSearchText =AppiumBy.xpath("//android.widget.TextView[@index='1']");

    public searchPage(final AndroidDriver driver) {
        super(driver);
    }
    pageTestData td = new pageTestData();

    public boolean enterSearchText() {
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

}
