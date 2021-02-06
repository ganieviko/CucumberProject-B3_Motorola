package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DepartmentComponent extends DialogComponent {
    public static By nameInput = By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.NAME']>input");
    public static By codeInput = By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.CODE']>input");

    public void enterName(String name) {
        waitForVisibilityAndClick(nameInput);
        WebElement element = BasePOM.getDriver().findElement(nameInput);
        element.clear();
        element.sendKeys(name);
    }

    public void enterCode(String code) {
        waitForVisibilityAndClick(codeInput);
        WebElement element = BasePOM.getDriver().findElement(codeInput);
        element.clear();
        element.sendKeys(code);
    }
}
