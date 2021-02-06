package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pom.*;

public class GenericSteps {
    @Given("I navigate to website {string}")
    public void iNavigateToWebsite(String url) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        BasePOM.setDriver(driver);
        BasePOM.setWait(new WebDriverWait(driver, 5));
    }
    @And("I login using username:{word} and password {string}")
    public void iLoginUsingUsernameAndPassword(String username, String password) {
        LoginPage loginPage = new LoginPage(BasePOM.getDriver());
        loginPage.fillInUserName(username);
        loginPage.fillInUserPassword(password);
        loginPage.login();
        Assert.assertTrue(loginPage.isLoggedIn());
    }

    @Then("I see {word} message {string}")
    public void iSeeSuccessMessage(String type, String arg0) {
        PopupMessageComponent component = new PopupMessageComponent(BasePOM.getDriver());
        component.waitForMessage(arg0);
        if(type.equals("error")) {
            DialogComponent dialogComponent = new DialogComponent(BasePOM.getDriver());
            dialogComponent.closeDialog();
        }
    }

    @And("I go to menu {int} {int} {int}")
    public void iGoToMenu(int firstLevel, int secondLevel, int thirdLevel) {
        MenuComponent menuComponent = new MenuComponent(BasePOM.getDriver());
        menuComponent.navigateFirstLevel(firstLevel);
        menuComponent.navigateSecondLevel(secondLevel);
        menuComponent.navigateThirdLevel(thirdLevel);
    }
}
