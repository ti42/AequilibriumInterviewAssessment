package com.aequilibrium.assessment.bdd.script;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
          //dryRun = true,
        tags = { "@Debug" },

        features = "src/main/resources/Features/",
        glue = {"com.aequilibrium.assessment.bdd.script"},
        plugin={
                "junit:target/cucumber-report/xml/test-report.xml",
                "json:target/cucumber-report/json/cucumber-report.json",
                "html:target/cucumber-report/html"
        }


)

public class BddRunner {
}
