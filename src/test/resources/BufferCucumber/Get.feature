Feature: quitar en el buffer
  Quita bien o no

  Scenario: Comprueba si quita valores en el buffer
    Given I have a buffer of capacity 4
    When I put one item and then I delete it
    Then Size should be: 0

