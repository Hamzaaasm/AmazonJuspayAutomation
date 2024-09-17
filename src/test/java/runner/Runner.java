package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "feature", glue = "stepdef", dryRun = false, monochrome = true,plugin = {"pretty",
"html:target/index.html"},tags ="@E2E")

public class Runner {

}
