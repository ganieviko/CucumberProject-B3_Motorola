package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePOM {
    public By username = By.cssSelector("input[formcontrolname='username']");
    public By password = By.cssSelector("input[formcontrolname='password']");
    public By loginButton = By.cssSelector("button[aria-label='LOGIN']");
    public By menu = By.cssSelector("svg[data-icon=\"bars\"]");

    public void fillInUserName(String username) {
        BasePOM.getDriver().findElement(this.username).sendKeys(username);
    }

    public void fillInUserPassword(String password){
        BasePOM.getDriver().findElement(this.password).sendKeys(password);
    }

    public void login(){
        BasePOM.getDriver().findElement(loginButton).click();
    }

    public boolean isLoggedIn() {
        WebDriverWait wait = new WebDriverWait(BasePOM.getDriver(), 5);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(menu));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
