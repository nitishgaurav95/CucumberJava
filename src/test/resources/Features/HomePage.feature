Feature: DemoQA Application

  Background:
    Given I launch DemoQA application

    @BDDPractice
      Scenario: Verify the title of the Home Page
        When I navigate to the Home Page
        Then the title of the Home Page should be "ToolsQA"
        Then I should see the Elements, Forms, Alerts, Frame & Windows cards

    @BDDPractice
    Scenario: Verify that the user can click on the "Elements" card and navigate to the Elements Page
        When I click on the Elements card
        Then I should be navigated to the Elements Page
        Then I should see the Text Box option
        Then I should see the Check Box option
        Then I should see the Radio Button option
        Then navigate back to the Home Page

    @BDDPractice
    Scenario: Verify that the user can click on the "Forms" card and navigate to the Forms Page
        When I click on the Forms card
        Then I should be navigated to the Forms Page
        Then I should see the Practice Form option
        Then I should see the Browser Windows option
        Then navigate back to the Home Page

    @BDDPractice
    Scenario: Verify that the user click on the "Alerts, Frame & Windows" card and navigate to the Alerts, Frame & Windows Page
        When I click on the Alerts, Frame & Windows card
        Then I should be navigated to the Alerts, Frame & Windows page
        Then navigate back to the Home Page



    