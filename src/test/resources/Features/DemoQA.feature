Feature: This feature file is created to practice the automation using the Demo QA website.

  Background:
    Given I launch DemoQA application

  @AutomationPractice
  Scenario: 01_Verify user can submit details and see output
    When I click on the Element tiles on the home page
    And I click on the Text Box option
    When I enter first name "John"
    And I click on the Submit button
    Then I verify output is displayed with first name "John"

  @AutomationPractice
  Scenario: 02_Verify Tools QA home page
    Then verify the element present on the home page
