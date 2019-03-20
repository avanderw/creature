Feature: Describe
  Scenario: Creature
    Given a creature
    When I describe the creature
    Then there must be no template code

  Scenario: Body
    Given a body
    And it has a heart
    And it has skin
    When I describe the body