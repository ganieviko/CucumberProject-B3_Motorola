package pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BasePOM {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();;

    public static void setDriver(WebDriver driver) {
        BasePOM.driver.set(driver);
    }
    public static void setWait(WebDriverWait wait) {
        BasePOM.wait.set(wait);
    }

    public static WebDriver getDriver() {
        if(driver.get() == null) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            BasePOM.driver.set(driver);
            BasePOM.wait.set(new WebDriverWait(driver, 5));
        }
        return driver.get();
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }


    protected void waitForVisibilityAndClick(By locator) {
        try {
            wait.get().until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            Assert.fail("Waited for visibility of " + locator.toString(), e);
        }
        driver.get().findElement(locator).click();
    }

    protected void waitForAngularStability(int seconds) {
        waitForAngularStability(seconds, "Waited " + seconds + " seconds for angular to be stable, but failed!");
    }
    protected void waitForAngularStability(int seconds, String message) {
        try {
            ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor) driver)
                    .executeScript("return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1").toString());
            wait.get().withTimeout(Duration.of(seconds, ChronoUnit.SECONDS)).until(angularLoad);
        } catch (TimeoutException e) {
            Assert.fail(message, e);
        }
    }
}
