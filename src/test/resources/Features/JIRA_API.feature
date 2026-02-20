Feature: Simple Jira API

@AutomationPractice
Scenario: Validate Jira issue API
  Given I call Jira issue API
  Then status code should be 200