package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class helper {

    public static void tap(final AndroidDriver driver, WebElement element) {

        Point location = element.getLocation();
        Dimension size = element.getSize();

        Point centerOfElement = getSideXOfElement(location, size);
        PointerInput fingure1 = new PointerInput(PointerInput.Kind.TOUCH, "fingure1");
        Sequence sequence = new Sequence(fingure1, 1)
                .addAction(fingure1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(fingure1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(fingure1, Duration.ofMillis(200)))
                .addAction(fingure1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

    private static Point getSideXOfElement(Point location, Dimension size) {
        return new Point(location.getX() + 200 + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
    }

}

