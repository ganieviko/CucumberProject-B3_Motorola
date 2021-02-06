package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NationalitiesComponent extends DialogComponent {
    public static By nameInput = By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.NAME']>input");

    public void enterName(String name) {
        waitForVisibilityAndClick(nameInput);
        WebElement element = BasePOM.getDriver().findElement(nameInput);
        element.clear();
        element.sendKeys(name);
    }
}
