Feature: Creature
  Scenario: Initialise
    Given I create a creature injector
    When I inject a creature
    Then there are no exceptions

  Scenario: Templating
    Given I create a creature injector
    When I describe the creature
    Then there must be no template code

  Scenario: Consistency
    Given I create a creature
    And I create a descriptor
    When I describe creature 0 using the descriptor 0
    And I describe creature 0 using the descriptor 0
    Then the description 0 and description 1 will be equal

  Scenario: Different descriptors
    Given I create a creature
    And I create a descriptor
    And I create a descriptor
    When I describe creature 0 using the descriptor 0
    And I describe creature 0 using the descriptor 1
    Then description 0 and description 1 will not be equal
    And description 0 will not have the same structure to description 1

  Scenario: Different creatures
    Given I create a creature
    And I create a creature
    And I create a descriptor
    When I describe creature 0 using the descriptor 0
    And I describe creature 1 using the descriptor 0
    Then the description 0 and description 1 will be equal
    And description 0 will have the same structure to description 1