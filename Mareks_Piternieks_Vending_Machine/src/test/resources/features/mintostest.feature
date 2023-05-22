Feature: Smoke tests for imaginary vending machine.

  Scenario: User inserts money into machine and returns it
    Given User inserts <2>€ in vending machine
    When User validates that <2>€ has been inserted into vending machine
    When User selects <"return coins"> option
    Then User validates <2>€ have been returned
    And User validates total amount of inserted money becomes zero

  Scenario: Selecting and buying a product
    Given Vending machine has products available
    Then User inserts <1>€ in vending machine
    When User validates that <1>€ has been inserted into vending machine
    When User selects <"productNumber"> option
    Then User validates that correct <"productNumber"> is returned

  Scenario: User inserts coins into machine, waits, gets reminder and stops shopping
    Given User inserts <1>€ in vending machine
    When User waits <60> seconds
    When User validates that he receives reminder
    Then User selects <"cancel"> option
    And User validates <1>€ have been returned

  Scenario: Inserting coins
    Given User inserts a coins of 5ȼ, 10ȼ, 20ȼ, 50ȼ, 1€, and 2€
    Then User validates the total amount of inserted money is updated accordingly





