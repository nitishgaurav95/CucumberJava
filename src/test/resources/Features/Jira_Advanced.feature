Feature: Jira Advanced API Testing

@Advanced
Scenario Outline: Verify user can create multiple Jira issues
  Given I create a Jira issue with summary "<summary>" and description "<description>"
  Then status code of the response should be 201
  And the issue key should be generated

Examples:
  | summary            | description           |
  | API Test Issue 1   | First dataset         |
  | API Test Issue 2   | Second dataset        |
  | API Test Issue 3   | Third dataset         |

@Advanced
Scenario: Verify create issue → add comment → transition → close workflow
    Given I create a Jira issue with summary "Workflow Issue" and description "Workflow test"
    Then status code of the response should be 201
    When I add a comment "This is a workflow comment" to the created issue
    Then status code of the response should be 201
    When I transition the created issue to "Done"
    Then status code of the response should be 204
    When I get the created issue
    Then the issue status should be "Done"

@Advanced
Scenario: Verify user can upload attachment to Jira issue
    Given I create a Jira issue with summary "Attachment Issue" and description "Attachment test"
    Then status code of the response should be 201
    When I upload attachment "jiraAttachment.png"
    Then status code of the response should be 200
    And attachment name should be "jiraAttachment.png"

@Advanced
Scenario: Verify Jira issue response matches expected JSON schema
    Given I create a Jira issue with summary "Schema Issue" and description "Schema test"
    Then status code of the response should be 201
    When I get the created issue
    Then response should match JSON schema "issue-schema.json"

@Advanced
Scenario: Verify API response time is within threshold
    Given I create a Jira issue with summary "Performance Issue" and description "Performance test"
    Then status code of the response should be 201
    When I get the created issue
    Then response time should be less than "2000" milliseconds