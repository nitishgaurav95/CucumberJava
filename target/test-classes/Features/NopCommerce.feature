Feature: NopCommerce
  Automate Demo QA website - Alerts Frame & Windows  page to practice selenium

  Background: 
    Given I launch Nop Commerce application
    And login to the application

  @AutomationPractice
  Scenario: I verify the field present on the Dashboard page
    Then I verify Start accepting orders section