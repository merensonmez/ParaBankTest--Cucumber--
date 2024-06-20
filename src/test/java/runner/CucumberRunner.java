package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@ParaBank",
        glue = "stepdefs",
        features ="src/test/resources/feature/parabank.feature",
        dryRun = false

)
public class CucumberRunner {

}