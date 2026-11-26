package com.sabre.travelanywherebe.scenarios;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class BookingRequestPayload {

    private String hotelId;
    private String hotelName;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String email;
    private String startDate;
    private String endDate;
    private Integer numberOfGuests;

    public BookingRequestPayload() {
    }

    public static BookingRequestPayload defaultValidPayload() {
        return new BookingRequestPayload()
                .setHotelId("100126882")
                .setHotelName("Studio Krakow Lea by Renters")
                .setFirstName("Sabre")
                .setLastName("Academy")
                .setBirthDate("2025-06-10")
                .setEmail("academy@sabre.com")
                .setStartDate("2026-12-16")
                .setEndDate("2026-12-26")
                .setNumberOfGuests(2);
    }

    public BookingRequestPayload setHotelId(String hotelId) {
        this.hotelId = hotelId;
        return this;
    }

    public BookingRequestPayload setHotelName(String hotelName) {
        this.hotelName = hotelName;
        return this;
    }

    public BookingRequestPayload setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public BookingRequestPayload setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BookingRequestPayload setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public BookingRequestPayload setEmail(String email) {
        this.email = email;
        return this;
    }

    public BookingRequestPayload setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public BookingRequestPayload setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public BookingRequestPayload setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
        return this;
    }
}