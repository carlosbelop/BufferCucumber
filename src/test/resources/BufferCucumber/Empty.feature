Feature: buffer vacio o no
  Devuelve si está vacio y no deja meter más

  Scenario: Comprueba si el buffer está vacio y no deja meter más si es el caso
    Given I have a buffer of capacity 4
    When I put four items
    Then I delete all and I get "Vacio"
