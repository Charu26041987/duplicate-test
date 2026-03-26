Feature: Negative Booking API Tests

  Scenario: Booking request missing firstname
    Given I set a booking payload missing the "firstname"
    When I send a POST request to create booking
    Then I should receive a 400 status code

  Scenario: Booking request with empty lastname
    Given I set a booking payload with "lastname" as ""
    When I send a POST request to create booking
    Then I should receive a 400 status code

  Scenario: Booking request with malformed checkin date
    Given I set a booking payload with invalid date "2025-13-01"
    When I send a POST request to create booking
    Then I should receive a 400 status code

  Scenario: Booking request with checkout before checkin
    Given I set a booking payload with checkout earlier than checkin
    When I send a POST request to create booking
    Then I should receive a 400 status code


  Scenario: Booking request missing bookingdates
    Given I set a booking payload with no bookingdates
    When I send a POST request to create booking
    Then I should receive a 400 status code

  Scenario: Booking request with invalid email format
    Given I set a booking payload with invalid email "not-an-email"
    When I send a POST request to create booking
    Then I should receive a 400 status code


  Scenario: Booking request with phone number too short
    Given I set a booking payload with phone number "123"
    When I send a POST request to create booking
    Then I should receive a 400 status code
    And the response should contain the error message "Phone number is too short"

  Scenario: Booking request with phone number too long
    Given I set a booking payload with phone number "12345678901234567890"
    When I send a POST request to create booking
    Then I should receive a 400 status code
    And the response should contain the error message "Phone number is too long"