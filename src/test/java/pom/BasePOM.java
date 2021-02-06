package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BasePOM {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public static void setDriver(WebDriver driver) {
        BasePOM.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void setWait(WebDriverWait wait) {
        BasePOM.wait = wait;
    }

    protected void waitForVisibilityAndClick(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            Assert.fail("Waited for visibility of " + locator.toString(), e);
        }
        driver.findElement(locator).click();
    }

    protected void waitForAngularStability(int seconds) {
        waitForAngularStability(seconds, "Waited " + seconds + " seconds for angular to be stable, but failed!");
    }
    protected void waitForAngularStability(int seconds, String message) {
        try {
            ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor) driver)
                    .executeScript("return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1").toString());
            wait.withTimeout(Duration.of(seconds, ChronoUnit.SECONDS)).until(angularLoad);
        } catch (TimeoutException e) {
            Assert.fail(message, e);
        }
    }
}
