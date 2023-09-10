package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/LoginUser.feature", // Path to your feature file
        glue = "stepDef", // Package containing your step definitions
        plugin = {"pretty", "html:target/cucumber-reports"} // You can customize the reporting format
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
