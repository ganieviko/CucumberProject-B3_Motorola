package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;

public class MenuComponent extends BasePOM {
    public By setupMenu = By.cssSelector(".group-items > :nth-child(1)");
    public By parametersMenu = By.cssSelector(".group-items > :nth-child(1) fuse-nav-vertical-collapsable:nth-child(1)");
    public By nationalitiesMenu = By.cssSelector(".group-items > :nth-child(1) fuse-nav-vertical-collapsable:nth-child(1) > div > fuse-nav-vertical-item:nth-child(4) > a");
    public By toolbarTitle = By.cssSelector("toolbar h3");

    public MenuComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToSetup() {
        waitForVisibilityAndClick(setupMenu);
    }

    public void navigateToParametersMenu() {
        waitForVisibilityAndClick(parametersMenu);
    }

    public void navigateToNationalityMenu() {
        waitForVisibilityAndClick(nationalitiesMenu);
    }

    public String getTitle() {
        waitForAngularStability(5);
        return driver.findElement(toolbarTitle).getText();
    }
}
