Feature: meter en el buffer
  Introduce bien o no

  Scenario: Comprueba si introduce valores en el buffer
    Given I have a buffer of capacity 4
    When I put one item
    Then Size should be: 1

