package com.sabre.travelanywherebe.scenarios;

import com.sabre.travelanywherebe.scenarios.payloads.BookingRequestPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BookingApiTests {

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
