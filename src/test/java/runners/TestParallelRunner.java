package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import pom.BasePOM;

@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"steps", "hooks"},
        plugin = {"pretty", "html:target/report/index.html"}
)
public class TestParallelRunner extends AbstractTestNGCucumberTests {
    @AfterMethod
    public void setUpDriver() {
        BasePOM.getDriver().quit();
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
