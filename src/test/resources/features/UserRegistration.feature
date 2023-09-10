Feature: OpenCart eCommerce Registration, Sign-in, and Sign-out
  Scenario: User Registration
    Given the user is on the OpenCart registration page
    When the user enters valid registration details
    And clicks the Register button
    Then the user should be registered successfully


