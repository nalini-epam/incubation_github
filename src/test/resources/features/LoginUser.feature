Feature: User Login
  Scenario: User Login with Valid Credentials
    Given the user is on the OpenCart login page
    When the user enters valid login credentials
    And clicks the Login button
    Then the user should be logged in successfully





