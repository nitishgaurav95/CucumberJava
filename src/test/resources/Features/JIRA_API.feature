Feature: Simple Jira API

@AutomationPractice
Scenario: 01_Validate Jira issue API
  Given I call Jira issue API for issue "TES-7"
  Then status code should be 200

@AutomationPractice
Scenario: 02_Verify user can create a new Jira issue
  Given I call Jira create issue API
  Then status code should be 201

@AutomationPractice
Scenario: 03_Verify user can add comment to Jira issue
  Given I add comment "Comment added from Cucumber API automation" to Jira issue "TES-7"
  Then status code should be 201
  And comment response should contain issue key "TES-7", id and self URL
