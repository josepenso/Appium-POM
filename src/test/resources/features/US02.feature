Feature: As a user I should be able to purchase an order

  @eCommerce2
  Scenario Outline:
    Given the user is in the "eCommerce" app
    When  the user select "<country>"
    When  the user write "<name>"
    When  the user select "<gender>" gender
    Then  the user select Let's Shop
    Then  the user add to cart "<shoes>"
    Then  the user clicks on Shopping cart icon
    Then  the user verifies shoes "<shoes>" are in the shopping cart
    Then  the user verifies total amount is "<price>"
    And   the user complete the purchase
    Examples:
    | country   | name   | gender | shoes               | price   |
    | Argentina | Janeth | Female | Air Jordan 9 Retro  | $170.97 |
    | Belgium   | Alex   | Male   | Jordan 6 Rings      | $165.0  |
    | Slovenia  | Ada    | Female | Jordan Lift Off     | $115.0  |
    | Colombia  | Sandra | Female | PG 3                | $110.0  |
    | Maldives  | Ana    | Female | Nike SFB Jungle     | $116.97 |
