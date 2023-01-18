Feature: As User I should be able to create new account and purchase shoes


  @eCommerce
  Scenario: As user i should be able to purchase shoes

    Given the user is in the "eCommerce" app
    When  the user select "Belgium"
    When  the user write "Janeth"
    When  the user select "Female" gender
    Then  the user select Let's Shop
    Then  the user add to cart "Jordan 6 Rings"
    Then  the user clicks on Shopping cart icon
    Then  the user verifies shoes "Jordan 6 Rings" are in the shopping cart
    Then  the user verifies total amount is "$165.0"
    And   the user complete the purchase