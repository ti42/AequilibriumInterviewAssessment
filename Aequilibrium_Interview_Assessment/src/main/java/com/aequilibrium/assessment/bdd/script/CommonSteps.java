package com.aequilibrium.assessment.bdd.script;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class CommonSteps extends BaseStep {

    @Given("not a validated user")
    public void not_a_validated_user() {
        driver.manage().deleteAllCookies();
    }

    @When("user browse to the site {string}")
    public void user_browse_to_the_site(String url) {
        driver.navigate().to(url);
    }

    @Then("home page should display")
    public void home_page_should_display() {
        String expectedPageTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedPageTitle,actualTitle);

    }

    @When("user enter user id {string}")
    public void userEnterUserId(String userid) {
        WebElement user = driver.findElement(By.xpath("//input[@id='user-name']"));
        user.click();
        user.sendKeys(userid);
        delayFor(2000);
    }


    @When("user enter password {string}")
    public void user_enter_password(String password) {
        WebElement loginpassword = driver.findElement(By.xpath("//input[@id='password']"));
        loginpassword.click();
        loginpassword.sendKeys(password);
        delayFor(2000);
    }

    @When("user click login button")
    public void user_click_login_button() {
        driver.findElement(By.xpath("//input[@class='btn_action']")).click();
    }



    @Then("login error message display")
    public void login_error_message_display() {
        WebElement error_message = driver.findElement(By.xpath("//h3[1]"));
        String actual_error_message = error_message.getText();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", actual_error_message);
    }

    @And("login error message display for Blank user name")
    public void loginErrorMessageDisplayForBlankUserName() {
        WebElement error_message = driver.findElement(By.xpath(" //h3[1]"));
        String actual_error_message = error_message.getText();
        Assert.assertEquals("Epic sadface: Username is required", actual_error_message);
    }


    @When("user enter user user id {string}")
    public void userEnterUserUserId(String arg0) {

    }

    @And("verify new page title")
    public void verifyNewPageTitle() {
        String expectedPageTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedPageTitle,actualTitle);
    }
}
