Feature: Account Creation
  I want to check that the user can create a new account

  Scenario Outline: Account Creation
    Given the user is at the home page
    When the user is in authentication page and enter mail
    And the user enters <firstName> and <lastName> and <password> and <day> and <month> and <year> and <address> and <city> and <state> and <postalCode> and <Country> and <mob> in the account creation page
    Then the account created successfully

    Examples:
    |firstName|lastName|password|day|month|year|address|city|state|postalCode|Country|mob|
    |"test"|"automation"|"password0"|"5"|"2"|"2003"|"New Huston"|"New York"|"New York"|"10001"|"United States"|"648688354"|