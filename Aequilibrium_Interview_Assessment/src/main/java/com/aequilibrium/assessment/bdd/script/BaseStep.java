package com.aequilibrium.assessment.bdd.script;

import Utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseStep {
    protected WebDriver driver = DriverFactory.getInstance("Chrome").getDriver();;

    public void delayFor(int timeInMili){
        try {
            Thread.sleep(timeInMili);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}