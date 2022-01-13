
Feature: Payment for different clients on Eribank app

  @paymentforthree

  Scenario: Make a payment for three different clients on Eribank app
    Given I have logged in on Eribank
    When I choose make a payment option for the first client
    And I enter phone, name, country and amount info of the first client
    Then I should see my remaining balance after first payment
    When I choose make a payment option for the second client
    And I enter phone, name, country and amount info of the second client
    Then I should see my remaining balance after second payment
    When I choose make a payment option for the third client
    And I enter phone, name, country and amount info of the third client
    Then I should see my remaining balance after third payment


