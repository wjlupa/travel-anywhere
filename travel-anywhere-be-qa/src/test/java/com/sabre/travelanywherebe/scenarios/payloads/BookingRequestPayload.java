package com.sabre.travelanywherebe.scenarios.payloads;

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

    public String getHotelId() {
        return hotelId;
    }

    public BookingRequestPayload setHotelId(String hotelId) {
        this.hotelId = hotelId; return this;
    }

    public String getHotelName() {
        return hotelName;
    }

    public BookingRequestPayload setHotelName(String hotelName) {
        this.hotelName = hotelName; return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public BookingRequestPayload setFirstName(String firstName) {
        this.firstName = firstName; return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BookingRequestPayload setLastName(String lastName) {
        this.lastName = lastName; return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public BookingRequestPayload setBirthDate(String birthDate) {
        this.birthDate = birthDate; return this;
    }

    public String getEmail() {
        return email;
    }

    public BookingRequestPayload setEmail(String email) {
        this.email = email; return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public BookingRequestPayload setStartDate(String startDate) {
        this.startDate = startDate; return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public BookingRequestPayload setEndDate(String endDate) {
        this.endDate = endDate; return this;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public BookingRequestPayload setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
        return this;
    }
}