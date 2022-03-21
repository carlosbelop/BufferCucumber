Feature: Is the method creating good buffers?
  We want to check whether the method create buffers or returning exceptions.

  Scenario Outline: Comprueba el constructor
    Given I want to create a buffer
    When I do it with capacity <a>
    Then it should return <result>

    Examples: 
      | a  | result                     |
      |  0 | "Ilegal"                   |
      | -1 | "Ilegal"                   |
      | -0 | "Ilegal"                   |
      |  8 | "Creado satisfactoriamente" |
