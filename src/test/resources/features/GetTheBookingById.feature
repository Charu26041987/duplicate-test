Feature: Retrieve Booking by ID

  @Retrivedata
  Scenario: Get booking details by ID
    Given the booking API is available
    When I send a GET request to retrieve booking with ID 1
    Then I should receive a 200 status code
    And the response should contain the booking details


  @Retrivedata
  Scenario: Get booking details invalid ID
    Given the booking API is available
    When I send a GET request to retrieve booking with ID 78
    Then I should receive a 404 status code
    And the response should contain the booking details