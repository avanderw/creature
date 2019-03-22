Feature: Creature
  Scenario: Initialise
    Given I create a creature injector
    When I inject a creature
    Then there are no exceptions

  Scenario: Templating
    Given I create a creature injector
    When I describe the creature
    Then there must be no template code