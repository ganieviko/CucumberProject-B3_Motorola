package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"steps", "hooks"},
        plugin = {"pretty", "html:target/report/index.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
