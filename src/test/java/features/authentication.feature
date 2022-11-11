Feature: Login Test


  Scenario Outline: Login Successful Functionality Test

    Given user navigates to demo shop site
    And   user hits Log in link
    When  user enters Email as "<email>" and Password as "<password>"
    Then  login should be successful


    Examples:
      | email                | password |
      | HasanNour8@gmail.com | 123456   |


  Scenario: Register For Newsletters Functionality Test

    Given user navigates to demo shop site
    When  User enters an email address in the Subscribe field
    And   User hits the Subscribe button for newsletters
    Then  User should be subscribed and get message Thank you for signing up!


  @second
  Scenario: Log Out Functionality Test

    Given User is logged in with a validated email and password

    When  User hits the Log out button
    Then  User should be logged out


  Scenario Outline: Login Unsuccessful Functionality Test

    Given user navigates to demo shop site
    And   user hits Log in link
    When  user enters Email as "<email>" and Password as "<password>"
    Then  login should be unsuccessful


    Examples:
      | email                   | password |
      | HasanNour8453@gmail.com | 123456   |









