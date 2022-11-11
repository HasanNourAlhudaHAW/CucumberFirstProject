
Feature: Register Page Test With Invalid Inputs


  Scenario: Register Page With Invalid Inputs Functionality Test

    Given User have a Chrome browser running

    When  User go to tricentis.com
    And   User clicks on register link button
    And   User enters first name
    And   User enters last name
    And   User enters invalid email format
    And   User tries to enter password
    Then  User should get an error message: Wrong email