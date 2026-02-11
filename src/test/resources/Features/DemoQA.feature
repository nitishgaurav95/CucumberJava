Feature: DemoQA
  Automate Demo QA website - Alerts Frame & Windows  page to practice selenium

Background:
Given I launch Demo QA the application

  @AutomationPractice
  Scenario: Practice switching to New Tab, New Window and New Window Message on DemoQA website.
    When I click on Alerts, Frame & Windows link on home page
    Then I verify the functionality of New Tab
    And I verify the functionality of New Window