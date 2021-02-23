package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import pom.BasePOM;

@CucumberOptions(
        features = {"src/test/resources/schoolDepartmentMySQL.feature"},
        glue = {"steps", "hooks"},
        plugin = {"pretty", "html:target/report/index.html"}
)
public class TestParallelRunnerDepartment extends AbstractTestNGCucumberTests {
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
