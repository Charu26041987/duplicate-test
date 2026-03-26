package Stepsdef;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
public class ModifyBooking {

        private String token;
        private Response response;


        @When("I send a PUT request to update booking ID {int}")
        public void updateBooking(int bookingId) {
            JSONObject booking = new JSONObject();
            booking.put("roomid", 1);
            booking.put("firstname", "UpdatedName");
            booking.put("lastname", "UpdatedLast");
            booking.put("depositpaid", false);

            JSONObject dates = new JSONObject();
            dates.put("checkin", "2025-09-01");
            dates.put("checkout", "2025-09-05");
            booking.put("bookingdates", dates);

            response = given()
                    .baseUri("https://automationintesting.online/booking/")
                    .cookie("token", token)
                    .header("Content-Type", "application/json")
                    .body(booking.toString())
                    .put("/booking/" + bookingId);
        }


        @Then("the booking details should be updated")
        public void verifyUpdatedDetails() {
            String firstname = response.jsonPath().getString("booking.firstname");
            assertEquals("UpdatedName", firstname);
            System.out.println("Booking updated for: " + firstname);
        }
    }