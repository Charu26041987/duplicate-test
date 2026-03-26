Feature: Retrieve Bookings

  @Retrivedata
  Scenario: Get all bookings
    Given the booking API is available
    When I send a GET request to retrieve all bookings
    Then I should receive Response
    And the response should contain a list of bookings

