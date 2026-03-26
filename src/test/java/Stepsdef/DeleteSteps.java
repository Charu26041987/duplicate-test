package Stepsdef;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
public class DeleteSteps {

        private String token;
        private Response response;

        @Given("I am authenticated with valid credentials")
        public void authenticate() {
            String authPayload = "{ \"username\": \"admin\", \"password\": \"password\" }";

            response = given()
                    .baseUri("https://automationintesting.online/booking/")
                    .header("Content-Type", "application/json")
                    .body(authPayload)
                    .post("/auth/login");

            token = response.getCookie("token");
            assertNotNull("Auth token should not be null", token);
        }

        @Given("a booking exists with ID {int}")
        public void bookingExists(int bookingId) {
            response = given()
                    .baseUri("https://automationintesting.online/booking/")
                    .cookie("token", token)
                    .get("/booking/" + bookingId);

            assertEquals(200, response.getStatusCode());
        }

        @When("I send a DELETE request for booking ID {int}")
        public void deleteBooking(int bookingId) {
            response = given()
                    .baseUri("https://automationintesting.online/booking/")
                    .cookie("token", token)
                    .delete("/booking/" + bookingId);
        }


        @Then("the booking should no longer exist")
        public void verifyBookingDeleted() {
            response = given()
                    .baseUri("https://automationintesting.online/booking/")
                    .cookie("token", token)
                    .get("/booking/1");

            assertEquals(404, response.getStatusCode());
        }
    }