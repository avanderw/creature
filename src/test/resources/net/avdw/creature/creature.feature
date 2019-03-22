Feature: Creature
  Background:
    Given I create a creature injector

  Scenario: Description consistency
    Given I create a creature
    And I create a  describer
    When I describe creature 0 using  describer 0
    Then description 0 for the heart will represent creature 0 heart

  Scenario:  describer consistency
    Given I create a creature
    And I create a  describer
    When I describe creature 0 using  describer 0
    And I describe creature 0 using  describer 0
    Then description 0 and description 1 will be equal

  Scenario: Different  describers
    Given I create a creature
    And I create a  describer
    And I create a  describer
    When I describe creature 0 using  describer 0
    And I describe creature 0 using  describer 1
    Then description 0 and description 1 will not be equal
    And description 0 will not have the same structure to description 1

  Scenario: Different creatures
    Given I create a creature
    And I create a creature
    And I create a  describer
    When I describe creature 0 using  describer 0
    And I describe creature 1 using  describer 0
    Then description 0 and description 1 will be equal
    And description 0 will have the same structure to description 1