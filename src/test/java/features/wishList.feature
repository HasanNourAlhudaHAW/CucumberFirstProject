Feature: Wish List Test

  Scenario: Adding Gift Card to WishList Functionality Test

    Given User is logged in with validated email and password
    And  User moves to gift card on the bar
    And  User selects a gift card
    When User enters the recipient's name
    And  user enters the recipient's email
    And  User hits the button Add to wishlist
    Then User should receive the message The product has been added to your wishlist