Feature: Update Booking

  Scenario: Update an existing booking
    Given I am authenticated with valid credentials
    And a booking exists with ID 1
    When I send a PUT request to update booking ID 1
    Then I should receive a 200 status code
    And the booking details should be updated