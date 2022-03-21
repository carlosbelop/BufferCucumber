Feature: buffer lleno o no
  Devuelve si está lleno y no deja meter más

  Scenario: Comprueba si el buffer está lleno y no deja meter más si es el caso
    Given I have a buffer of capacity 4
    When I put four items
    Then I add one and I get "Lleno"