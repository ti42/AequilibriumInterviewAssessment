package com.aequilibrium.assessment.bdd.script;

import Utilities.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class HookStep extends BaseStep {
    @Before
    public void setUp() {
        driver = DriverFactory.getInstance().getDriver();
    }

    /*
        @After
        public void tearDown(){
            DriverFactory.getInstance().quitDriver();
        }*/
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.embed(screenshot, "image/png");
        }
        DriverFactory.getInstance().quitDriver();
    }
}
