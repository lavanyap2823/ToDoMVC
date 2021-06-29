package com.todomvc.testrunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/featurefiles"
 ,glue={"com.todomvc.stepdefinitions"}, plugin = {
	        "pretty:target/prettyReport.txt", "html:target/cucumber", "json:target/cucumber.json",
	        "junit:target/junit-report.xml" }, monochrome = true, tags = "@CreateTask"
 )

public class TestRunner {


}
