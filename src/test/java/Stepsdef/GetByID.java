package Stepsdef;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


public class GetByID {
        private Response response;


        @When("I send a GET request to retrieve booking with ID {int}")
        public void sendGetRequestById(int bookingId) {
            response = given()
                    .baseUri("https://automationintesting.online/booking/123")
                    .header("Accept", "application/json")
                    .get("/booking/" + bookingId);
        }


        @Then("the response should contain the booking details")
        public void validateBookingDetails() {
            String firstname = response.jsonPath().getString("booking.firstname");
            assertNotNull("Firstname should not be null", firstname);
            System.out.println("Booking retrieved for: " + firstname);
        }
    }