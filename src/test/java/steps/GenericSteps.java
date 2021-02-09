package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pom.*;
import utils.ExcelReader;

import java.io.IOException;
import java.util.Map;

public class GenericSteps {
    @Given("I navigate to website {string}")
    public void iNavigateToWebsite(String url) {
        BasePOM.getDriver().get(url);
    }
    @And("I login using username:{word} and password {string}")
    public void iLoginUsingUsernameAndPassword(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.fillInUserName(username);
        loginPage.fillInUserPassword(password);
        loginPage.login();
        Assert.assertTrue(loginPage.isLoggedIn());
    }

    @Then("I see {word} message {string}")
    public void iSeeSuccessMessage(String type, String arg0) {
        PopupMessageComponent component = new PopupMessageComponent();
        component.waitForMessage(arg0);
        if(type.equals("error")) {
            DialogComponent dialogComponent = new DialogComponent();
            dialogComponent.closeDialog();
        }
    }

    @And("I go to menu {int} {int} {int}")
    public void iGoToMenu(int firstLevel, int secondLevel, int thirdLevel) {
        MenuComponent menuComponent = new MenuComponent();
        menuComponent.navigateFirstLevel(firstLevel);
        menuComponent.navigateSecondLevel(secondLevel);
        menuComponent.navigateThirdLevel(thirdLevel);
    }

    @When("I delete row with name {string}")
    public void iDeleteNationality(String name) {
        BrowserComponent browserComponent = new BrowserComponent();
        browserComponent.deleteRow(name);
    }

    @Given("I navigate and login to website define in excel {string}")
    public void iNavigateAndLoginToWebsiteDefineInExcel(String fileName) throws IOException {
        ExcelReader reader = new ExcelReader("src/test/resources/excels/"+fileName);
        Map<String, String> loginDetails = reader.getMap();
        BasePOM.getDriver().get(loginDetails.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.fillInUserName(loginDetails.get("username"));
        loginPage.fillInUserPassword(loginDetails.get("password"));
        loginPage.login();
        Assert.assertTrue(loginPage.isLoggedIn());
    }
}
