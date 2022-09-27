Feature: Add Candidate

  Scenario: Successful Add new candidate for recruitment
    Given User is logged in
    When User navigates to Recruitment page and clicks on add button
    And User enters candidate details and click save button
    Then New candidate is added