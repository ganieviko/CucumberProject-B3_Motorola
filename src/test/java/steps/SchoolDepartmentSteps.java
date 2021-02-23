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

import java.sql.*;
import java.util.List;
import java.util.Random;

public class SchoolDepartmentSteps {
    private int numberOfRowsBeforeSave;
    private String randomName;
    private String randomCode;
    private DepartmentComponent departmentComponent = new DepartmentComponent();
    private String departmentName;

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

    @When("I create department with name and code from row {int}")
    public void iCreateDepartmentWithNameFromRow(int rowIndex) throws SQLException {
        String url = "jdbc:mysql://test.medis.mersys.io:33306";
        String user = "technostudy";
        String password = "zhTPis0l9#$&";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM ts_test_data_b3.departments;");
        resultSet.absolute(rowIndex);
        // get row from mysql
        departmentComponent.clickOnPlusButton();
        departmentName = resultSet.getString("department_name");
        departmentComponent.enterName(departmentName);
        String rowCode = resultSet.getString("department_code");
        departmentComponent.enterCode(rowCode);
        departmentComponent.save();
    }

    @When("I delete row with name from mysql")
    public void iDeleteRowWithNameFromRowRow() throws SQLException {
        BrowserComponent browserComponent = new BrowserComponent();
        browserComponent.deleteRow(departmentName);
    }

}
