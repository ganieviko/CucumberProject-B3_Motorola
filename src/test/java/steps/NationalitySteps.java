package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.LoginPage;

public class NationalitySteps {
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
    }

    @When("I create nationality")
    public void iCreateNationality() {
    }

    @Then("I see success message {string}")
    public void iSeeSuccessMessage(String arg0) {
    }

    @When("I delete nationality")
    public void iDeleteNationality() {
    }
}
