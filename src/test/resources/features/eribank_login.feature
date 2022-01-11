Feature: Login

  @login
  Scenario: Login to Eribank with valid credentials
    Given I am on the application main page
    When I enter valid credentials
    Then I should be logged in successfully