Feature: Simple Jira API

@BDDRestAssuredPractice
Scenario: 01_Validate Jira issue API
  Given I call Jira issue API for issue with "SCRUM-1"
  Then status code should be 200
  Then I should see the issue as "My First Task in this jira board"

@BDDRestAssuredPractice
Scenario: 02_Verify user can create a new Jira issue
  Given I call Jira create issue API
  Then status code should be 201
  
@BDDRestAssuredPractice
Scenario: 03_Verify user can fetch Jira issue by issue key
  Given I call Jira issue API for issue with "SCRUM-2"
  Then status code should be 200
  Then I should see the reporter as "aparna"

@BDDRestAssuredPractice
Scenario: 04_Verify user can fetch Jira issue by issue key
  Given I call Jira issue API for issue with "SCRUM-2"
  Then status code should be 200

@BDDRestAssuredPractice
Scenario: 05_Verify user can add comment to Jira issue
  Given I call Jira add comment API for issue with "SCRUM-2"
  Then status code should be 201
  Then I should see the comment as "Comment added via API"

@BDDRestAssuredPractice
Scenario: 06_Verify user can update issue summary
  Given I call Jira update API for issue with "SCRUM-2"
  Then status code should be 204
  Then I should see the issue summary as "Updated summary via API" from "SCRUM-2"
  