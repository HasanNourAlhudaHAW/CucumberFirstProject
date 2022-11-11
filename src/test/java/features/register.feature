Feature: Register

  Scenario: Shop Register Functionality Test

    Given user is on Demo home page
    When user clicks on register link
    And user fills out the fields and clicks on register
    Then user should gets Your registration completed
    Then user should be able to press continue

