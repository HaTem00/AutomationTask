package runner;

import base.BaseTests;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = {"steps"}, plugin = {"pretty", "html:target/cucumber-html-report.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
