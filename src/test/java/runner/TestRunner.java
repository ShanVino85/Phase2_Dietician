package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber.json" }, features = {
        "src/test/resources/Feature/" }, glue = { "classpath:" }, tags = { "@YourTagName" })
public class TestRunner {

}
