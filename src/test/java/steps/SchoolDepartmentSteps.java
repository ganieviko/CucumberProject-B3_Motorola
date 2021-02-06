package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pom.BasePOM;
import pom.BrowserComponent;
import pom.DepartmentComponent;
import pom.NationalitiesComponent;

import java.util.List;
import java.util.Random;

public class SchoolDepartmentSteps {
    private int numberOfRowsBeforeSave;
    private String randomName;
    private String randomCode;
    private DepartmentComponent departmentComponent = new DepartmentComponent();

    @When("I create department with name {string} and code {string}")
    public void iCreateDepartmentWithNameAndCode(String name, String code) {
        departmentComponent.clickOnPlusButton();
        departmentComponent.enterName(name);
        departmentComponent.enterCode(code);
        departmentComponent.save();
    }


   @When("I create department with name random and code random")
    public void iCreateDepartmentWithRandomNameAndCode() {
        Random random = new Random();
        randomName = "random name " + random.nextInt();
        randomCode = "random code " + random.nextInt();

       departmentComponent.clickOnPlusButton();
       departmentComponent.enterName(randomName);
       departmentComponent.enterCode(randomCode);
       departmentComponent.save();
    }

    @When("I delete the department with name random and code random")
    public void iDeleteTheDepartmentWithRandomNameAndCode() {
        BrowserComponent browserComponent = new BrowserComponent();
        browserComponent.deleteRow(randomName);
    }

    @When("I create department with name {string} and code {string} without saving")
    public void iCreateDepartmentWithNameAndCodeWithoutSaving(String name, String code) {
        departmentComponent.clickOnPlusButton();
        departmentComponent.enterName(name);
        departmentComponent.enterCode(code);
    }

    @And("I click on department save button")
    public void iClickOnDepartmentSaveButton() {
        departmentComponent.save();
    }

}
