package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pom.*;

public class NationalitySteps {
    private String savedNationalityName;
    private NationalitiesComponent nationalitiesComponent;
    private BrowserComponent browserComponent = new BrowserComponent(BasePOM.getDriver());;

    @Given("I navigate to website")
    public void iNavigateToWebsite() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://test.campus.techno.study/");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.fillInUserName("daulet2030@gmail.com");
        loginPage.fillInUserPassword("TechnoStudy123@");
        loginPage.login();
        Assert.assertTrue(loginPage.isLoggedIn());
    }

    @And("I go to nationality menu")
    public void iGoToNationalityMenu() {
        MenuComponent menuComponent = new MenuComponent(BasePOM.getDriver());
        menuComponent.setWait(new WebDriverWait(BasePOM.getDriver(), 5));
        menuComponent.navigateToSetup();
        menuComponent.navigateToParametersMenu();
        menuComponent.navigateToNationalityMenu();

        Assert.assertEquals(menuComponent.getTitle(), "Nationalities");
    }

    @When("I create nationality with name {string}")
    public void iCreateNationality(String name) {
        savedNationalityName = name;
        nationalitiesComponent = new NationalitiesComponent(BasePOM.getDriver());
        nationalitiesComponent.clickOnPlusButton();
        nationalitiesComponent.enterName(name);
        nationalitiesComponent.save();
    }

    @Then("I see {word} message {string}")
    public void iSeeSuccessMessage(String type, String arg0) {
        PopupMessageComponent component = new PopupMessageComponent(BasePOM.getDriver());
        component.waitForMessage(arg0);
        if(type.equals("error")) {
            nationalitiesComponent.closeDialog();
        }
    }

    @When("I delete nationality with name {string}")
    public void iDeleteNationality(String name) {
        browserComponent.deleteRow(name);
    }

    @When("I delete saved nationality")
    public void iDeleteSavedNationality() {
        BrowserComponent component = new BrowserComponent(BasePOM.getDriver());
        component.deleteRow(savedNationalityName);
    }

    @When("I edit nationality with name {string} to {string}")
    public void iEditNationalityWithNameTo(String oldName, String newName) {
        browserComponent.clickOnEdit(oldName);
        nationalitiesComponent.enterName(newName);
        nationalitiesComponent.save();
    }
}
