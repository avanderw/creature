Feature: Creature
  Background:
    Given I create a creature injector

  Scenario: Description consistency
    Given I create a creature
    When I describe creature 0
    Then description 0 for the heart will represent creature 0 heart

  Scenario:  describer consistency
    Given I create a creature
    When I describe creature 0
    And I describe creature 0
    Then description 0 and description 1 will be equal

  Scenario: Different creatures
    Given I create a creature
    And I create a creature
    When I describe creature 0
    And I describe creature 1
    Then description 0 and description 1 will not be equal