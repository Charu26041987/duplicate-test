Feature: Booking
  @booking
  Scenario: Create a booking
    Given I set the booking
    When I send a POST request to create booking
    Then I should receive a 200 status code