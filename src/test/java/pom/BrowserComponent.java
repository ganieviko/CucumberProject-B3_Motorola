package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class BrowserComponent extends BasePOM {
    public static By browserTableRows = By.cssSelector("ms-browse-table tr");
    public static By trashButton = By.cssSelector("ms-delete-button");
    public static By confirmYes = By.cssSelector("button[type='submit']");
    public static By editButton = By.cssSelector("ms-edit-button");;

    public BrowserComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void deleteRow(String name) {
        waitForAngularStability(5);
        List<WebElement> rows = driver.findElements(browserTableRows);
        boolean found = false;
        for (WebElement row : rows) {
            if (row.getText().contains(name)) {
                found = true;
                row.findElement(trashButton).click();
            }
        }
        Assert.assertTrue(found, "The row with " + name + "not found");

        waitForVisibilityAndClick(confirmYes);
    }

    public void clickOnEdit(String oldName) {
        waitForAngularStability(5);
        List<WebElement> rows = driver.findElements(browserTableRows);
        boolean found = false;
        for (WebElement row : rows) {
            if (row.getText().contains(oldName)) {
                found = true;
                row.findElement(editButton).click();
            }
        }
        Assert.assertTrue(found, "The row with " + oldName + "not found");
    }
}
