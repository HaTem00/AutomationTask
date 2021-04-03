Feature: Cart Checkout
  I want to check that the user can create checkout the cart

  Scenario: Cart Checkout
    Given the user is in the home page
    When the user sign in
    And the user select Blouses Subcategory in Women Category
    And the user Select resulted product
    And the user select White colour and M size
    And the user follow checkout procedure
    And the user confirm order by selecting bank wire option
    Then the order was placed and found in order history page