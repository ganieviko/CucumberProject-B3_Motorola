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

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInUserName(String username) {
        driver.findElement(this.username).sendKeys(username);
    }

    public void fillInUserPassword(String password){
        driver.findElement(this.password).sendKeys(password);
    }

    public void login(){
        driver.findElement(loginButton).click();
    }

    public boolean isLoggedIn() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(menu));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
