Feature: Flipkart Search, Filter and Product Validation

  Background:
    Given I launch Flipkart application

 @AutomationPractice
  Scenario: Verify search functionality
    When I search for product "iPhone 14"
    Then I verify search results are displayed

@AutomationPractice
  Scenario: Verify sorting functionality
    When I search for product "Laptop"
    And I sort results by low to high price
    Then I verify search results are displayed

@AutomationPractice
  Scenario: Verify brand filter functionality
    When I search for product "Running Shoes"
    And I select Puma brand filter
    Then I verify search results are displayed

@AutomationPractice
  Scenario: Verify price filter functionality
    When I search for product "Headphones"
    And I select price filter
    Then I verify search results are displayed

@AutomationPractice
  Scenario: Verify product page navigation
    When I search for product "Samsung Mobile"
    And I click first product
    Then I verify product page is opened