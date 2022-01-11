Feature: Make a payment

  @payment
  Scenario: Make a payment on Eribank app
    Given I have logged in
    When I click on make a payment button
    And I enter phone, name, country and amount info
    Then I should see my balance
