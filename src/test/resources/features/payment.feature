Feature: Make a payment

  Background:
    Given I have logged in
    When I choose make a payment option

  @payment
  Scenario: Make a payment on Eribank app
    And I enter phone, name, country and amount info
    Then I should see my remaining balance on home page

  @paymentforeachcountry
  Scenario Outline: Make a payment for each country on Eribank app
    And I enter phone, name, "<country>" and amount info
    Then I should see my remaining balance
    Examples:
      | country     |
      | India       |
      | USA         |
      | Iceland     |
      | Greenland   |
      | Switzerland |
      | Norway      |
      | New Zealand |
      | Greece      |
      | Italy       |
      | Ireland     |
      | China       |
      | Japan       |
      | France      |
      | Russia      |
      | Australlia  |
      | Canada      |
