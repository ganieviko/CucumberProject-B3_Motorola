package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PopupMessageComponent extends BasePOM {
    public static By alert = By.cssSelector("div[role='alertdialog']");

    public PopupMessageComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForMessage(String message) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(alert, message));
        } catch (TimeoutException e) {
            Assert.fail("Waited for message: " + message, e);
        }
    }
}
