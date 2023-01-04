Feature: F03_currency  user swtich between currencies
  Scenario: Dollar currency is selected by default

    When user check currency list
    Then Dollar selected by default


    Scenario: user could select Euro

      When user select euro