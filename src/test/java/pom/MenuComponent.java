package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuComponent extends BasePOM {
    public By toolbarTitle = By.cssSelector("toolbar h3");
    private String cssSelector;

    public String getTitle() {
        waitForAngularStability(5);
        return BasePOM.getDriver().findElement(toolbarTitle).getText();
    }

    public void navigateFirstLevel(int firstLevel) {
        cssSelector = ".group-items > :nth-child(" + firstLevel + ")";
        waitForVisibilityAndClick(By.cssSelector(cssSelector));
    }

    public void navigateSecondLevel(int secondLevel) {
        cssSelector = cssSelector + " fuse-nav-vertical-collapsable:nth-child(" + secondLevel + ")";
        waitForVisibilityAndClick(By.cssSelector(cssSelector));
    }

    public void navigateThirdLevel(int thirdLevel) {
        cssSelector = cssSelector + " > div > fuse-nav-vertical-item:nth-child("+thirdLevel+") > a";
        waitForVisibilityAndClick(By.cssSelector(cssSelector));
    }
}
