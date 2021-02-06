package steps;

import io.cucumber.java.en.When;
import pom.*;

public class NationalitySteps {
    private String savedNationalityName;
    private NationalitiesComponent nationalitiesComponent;
    private BrowserComponent browserComponent = new BrowserComponent(BasePOM.getDriver());;

    @When("I create nationality with name {string}")
    public void iCreateNationality(String name) {
        savedNationalityName = name;
        nationalitiesComponent = new NationalitiesComponent(BasePOM.getDriver());
        nationalitiesComponent.clickOnPlusButton();
        nationalitiesComponent.enterName(name);
        nationalitiesComponent.save();
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
