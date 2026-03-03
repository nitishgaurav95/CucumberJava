Feature: Intermediate Jira API

@BDDRestAssuredPracticeIntermediate
Scenario: 01_Verify user cannot create issue without mandatory fields
    Given I call Jira missing mandatory fields API
    Then the status code should be 400
    
@BDDRestAssuredPracticeIntermediate
Scenario: 02_Verify user cannot fetch issue with invalid key
    Given I call Jira invalid API for issue with "INVALID-KEY"
    Then the status code should be 404
  
@BDDRestAssuredPracticeIntermediate
Scenario: 03_Verify user can assign issue to another user   
    Given I call Jira assign API for issue with "SCRUM-2" to user "aparna"
    Then the status code should be 204

@BDDRestAssuredPracticeIntermediate
Scenario: 04_Verify user can transition issue status
    Given I call Jira transition issue API for issue with "SCRUM-2" to status "To Do"
    Then the status code should be 200
    Then I should see the transition status as "To Do"

@BDDRestAssuredPracticeIntermediate
Scenario: 05_Verify user cannot update issue without permission
    Given I call Jira update issue API for issue with "SCRUM-2" without proper authentication
    Then the status code should be 404
    Then I should see the error message as "Issue does not exist or you do not have permission to see it."
