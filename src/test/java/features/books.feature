Feature: Books

  Scenario: Books order

    Given user navigate to home page
    When user clicks on Books
    And user select a book randomly
    And clicks on Add to cart
    Then the selected book will be added to shopping.cart



  @second
  Scenario: select two Books

    Given user navigate to home page
    When user clicks on Books
    And user adds two books to cart
    And the selected books will be added to shopping cart
    And user clicks on the Agree box
    And user clicks on Checkout button
    And user fills out the required fields
    And user clicks on continue button
    And user clicks in billing address on continue
    And user clicks in Shipping address on continue




