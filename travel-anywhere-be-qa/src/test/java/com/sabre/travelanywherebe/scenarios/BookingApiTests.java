package com.sabre.travelanywherebe.scenarios;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BookingApiTests {

    @Test
    public void testCreateBookingHappyPath() {
        String requestBody = "{\n" +
                             "  \"hotelId\": \"100126882\",\n" +
                             "  \"hotelName\": \"Studio Krakow Lea by Renters\",\n" +
                             "  \"firstName\": \"Sabre\",\n" +
                             "  \"lastName\": \"Academy\",\n" +
                             "  \"birthDate\": \"2025-06-10\",\n" +
                             "  \"email\": \"academy@sabre.com\",\n" +
                             "  \"startDate\": \"2027-12-16\",\n" +
                             "  \"endDate\": \"2027-12-26\",\n" +
                             "  \"numberOfGuests\": 2\n" +
                             "}";
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("http://localhost:8080/booking");
        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("Booking created successfully"));
    }

    @DataProvider(name = "invalidEmailProvider")
    public Object[][] invalidEmailProvider() {
        return new Object[][] {
                { null, "email is null" },
                { "", "empty email string" },
                { "plainaddress", "missing @ and domain" },
                { "@missingusername.com", "missing username before @" },
                { "username@.com", "domain starts with a dot" },
                { "username@domain", "missing top-level domain" },
                { "username@domain..com", "double dot in domain" },
                { "username with spaces@domain.com", "email contains spaces" }
        };
    }

    @Test(dataProvider = "invalidEmailProvider")
    public void testCreateBookingWithInvalidEmailShouldFail(String invalidEmail, String description) {
        BookingRequestPayload payload = BookingRequestPayload.defaultValidPayload()
                .setEmail(invalidEmail);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/booking");

        assertEquals(response.getStatusCode(), 400,
                "Expected status 400 for invalid email case: " + description);
    }


    @Test
    public void testGetBookings() {
        Response response = RestAssured.get("http://localhost:8080/booking");
        assertEquals(200, response.getStatusCode());
    }
}
