Feature: Delete Booking

  Scenario: Delete an existing booking
    Given I am authenticated with valid credentials
    And a booking exists with ID 1
    When I send a DELETE request for booking ID 1
    Then I should receive a 200 status code
    And the booking should no longer exist