package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import pom.BasePOM;

@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"steps", "hooks"},
        plugin = {"pretty", "html:target/report/index.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        BasePOM.setDriver(driver);
        BasePOM.setWait(new WebDriverWait(driver, 5));
    }
}
