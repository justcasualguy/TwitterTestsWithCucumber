import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import testBase.TwitterTestBase;

@CucumberOptions(
        features={"src/test/resources/"},
        glue="kjukamber",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"

        },
        dryRun = false
)

public class TestRunner extends AbstractTestNGCucumberTests {
        @AfterSuite
        public void close(){
                TwitterTestBase.getInstaneOfTwitterTestBase().getWebDriver().close();
        }

}
