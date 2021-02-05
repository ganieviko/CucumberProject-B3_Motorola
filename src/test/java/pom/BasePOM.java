package pom;

import org.openqa.selenium.WebDriver;

public class BasePOM {
    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }
}
