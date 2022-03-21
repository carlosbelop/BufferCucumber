Feature: comprobar el tamaño
  Cambia los tamaños

  Scenario: Comprueba si cambia el size conforme se meten o quitan valores
    Given I have a buffer of capacity 4
    When I put one item
    Then Size should be: 1

  Scenario: Comprueba si cambia el size conforme se meten o quitan valores
    Given I have a buffer of capacity 4
    When I put four items
    Then Size should be: 4

  Scenario: Comprueba si cambia el size conforme se meten o quitan valores
    Given I have a buffer of capacity 4
    When I put four items and I delete two
    Then Size should be: 2
