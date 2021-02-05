package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pom.BasePOM;

public class AfterHooks {
    @After
    public void takeScreenshot(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) BasePOM.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }
}
