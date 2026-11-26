package com.sabre.profilesui.qa;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.sabre.profilesui.qa.components.PlaywrightRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BasicTests extends PlaywrightRunner {
    @BeforeMethod
    public void openReservationForm() {
        page.navigate("http://localhost:3000/");
        page.locator("div").filter(new Locator.FilterOptions().setHasText("+− Leaflet | © OpenStreetMap")).nth(3).click();
        page.locator(".btn").first().click();
    }

    @Test
    public void shouldCreateBooking() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First name")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First name")).fill("First Name");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last name")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last name")).fill("LastName");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Birth Date")).fill("2008-01-01");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).fill("ala@ma.kota");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Start Date")).fill("2028-01-01");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("End Date")).fill("2028-05-05");
        page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Number Of Guests")).click();
        page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Number Of Guests")).fill("5");
        String hotelName = page.locator(".hotelName").textContent();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
        assertThat(page.locator(".hotelName")).hasText(hotelName);
    }

    @Test
    public void shouldShowValidationFailureAtNegativeGuests() {
        page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Number Of Guests")).fill("-5");
        assertThat(page.locator(".numberOfGuestsGroup").locator(".invalid-feedback")).hasText("At least one guest is required");
    }
}