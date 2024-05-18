Feature: Leaves functionality test cases

  @web @draftLeave
  Scenario: Employee user should be able to create a draft leave
    When User enters email "employeeEmail" in logIn Screen
    And  User enters password "employeePassword" in logIn Screen
    And  User clicks on the login button
    And User landed to the quick access page
    And User clicks on the quick access - leaves card
    Then Validate that URL contains "leavesURL" text
    When User clicks on plus button for requesting the leave
    Then Validate that URL contains "newLeavesRequestURL" text
    And Request new leave modal should be displayed
    And Select a date for the request a leave
    Then Validate before and after leaves should be matched
    And User clicks on the save draft button
    Then Validate that alert should be displayed with the "Draft request has been created" text


  @web @requestLeave
  Scenario: Employee should be able to create a request for the leaves
    When User enters email "employeeEmail" in logIn Screen
    And  User enters password "employeePassword" in logIn Screen
    And  User clicks on the login button
    And User landed to the quick access page
    And User clicks on the quick access - leaves card
    Then Validate that URL contains "leavesURL" text
    When User selects the first draft leave request
    And User clicks on the request leave and confirm button
    Then Validate that alert should be displayed with the "Request has been submitted" text


  @web @requestLeave
  Scenario: Manager should be able to reject the leave request
    When User enters email "managerEmail" in logIn Screen
    And  User enters password "managerPassword" in logIn Screen
    And  User clicks on the login button
    And User landed to the quick access page
    And User selects the approval menu in the left sidebar
    Then User landed to the reviewer listing page
    And Validate that URL contains "reviewerListingURL" text
    When User clicks on the first leave that required the approval
    And User clicks on the reject button in the right side-bar
    And Submit the leave rejection note|reason "Testing: leave rejection"
    Then Validate that alert should be displayed with the "Review step has been rejected." text
