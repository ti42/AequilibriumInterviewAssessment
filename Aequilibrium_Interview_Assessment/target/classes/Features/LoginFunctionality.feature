Feature: This describe the login functionality for Swag Lab
  Description: This explain how various login functionality will work
  # Business Rule:
  # Valid user with valid password will be able to login
  # Invalid user with valid password will not be able to login
  # Valid user with invalid password will not be able to login
  # Blank user and valid password will not be able to login
  # Blank user and password will not be able to login

@Debug
  Scenario: 1. Valid user with valid password will be able to login
    Given not a validated user
    When user browse to the site "https://www.saucedemo.com/index.html"
    When user enter user id "standard_user"
    And user enter password "secret_sauce"
    And user click login button
    And verify new page title

  Scenario: 2. Invalid user with valid password will not be able to login
    Given not a validated user
    When user browse to the site "https://www.saucedemo.com/index.html"
    When user enter user id "invalid@gmail.com"
    And user enter password "secret_sauce"
    And user click login button
    And login error message display

  Scenario: 3. Valid user with invalid password will not be able to login
    Given not a validated user
    When user browse to the site "https://www.saucedemo.com/index.html"
    When user enter user id "standard_user"
    And user enter password "invalid"
    And user click login button
    And login error message display

  Scenario: 4. Blank user name and valid password
      Given not a validated user
      When user browse to the site "https://www.saucedemo.com/index.html"
      When user enter user id ""
      And user enter password "secret_sauce"
      And user click login button
      And login error message display for Blank user name

  Scenario: 5. Blank user name and blank password
    Given not a validated user
    When user browse to the site "https://www.saucedemo.com/index.html"
    When user enter user user id ""
    And user enter password ""
    And user click login button
    And login error message display for Blank user name