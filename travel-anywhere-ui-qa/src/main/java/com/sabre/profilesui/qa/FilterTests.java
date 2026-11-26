package com.sabre.profilesui.qa;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.sabre.profilesui.qa.components.PlaywrightRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FilterTests extends PlaywrightRunner {
    @BeforeMethod
    public void clickOnMap() {
        page.navigate("http://localhost:3000/");
        page.locator("div").filter(new Locator.FilterOptions().setHasText("+− Leaflet | © OpenStreetMap")).nth(3).click();
        page.locator(".location").first().waitFor();
    }

    @Test
    void shouldShowOnlyHotels() {
        page.locator("input[name=\"air\"]").uncheck();
        page.locator("input[name=\"rail\"]").uncheck();
        page.locator("input[name=\"car\"]").uncheck();
        for (Locator locator : page.locator(".location").all()) {
            assertThat(locator.locator(".category")).hasText("Category: HOTEL");
            assertThat(locator.locator(".btn")).isVisible();
        }
    }

    @Test
    void shouldShowOnlyAirports() {
        page.locator("input[name=\"hotel\"]").uncheck();
        page.locator("input[name=\"rail\"]").uncheck();
        page.locator("input[name=\"car\"]").uncheck();
        for (Locator locator : page.locator(".location").all()) {
            assertThat(locator.locator(".category")).hasText("Category: AIR");
            assertThat(locator.locator(".btn")).isHidden();
        }
    }

    @Test
    void shouldShowOnlyCarRentals() {
        page.locator("input[name=\"hotel\"]").uncheck();
        page.locator("input[name=\"rail\"]").uncheck();
        page.locator("input[name=\"air\"]").uncheck();
        for (Locator locator : page.locator(".location").all()) {
            assertThat(locator.locator(".category")).hasText("Category: CAR");
            assertThat(locator.locator(".btn")).isHidden();
        }
    }

    @Test
    void shouldShowOnlyRailStations() {
        page.locator("input[name=\"hotel\"]").uncheck();
        page.locator("input[name=\"car\"]").uncheck();
        page.locator("input[name=\"air\"]").uncheck();
        for (Locator locator : page.locator(".location").all()) {
            assertThat(locator.locator(".category")).hasText("Category: RAIL");
            assertThat(locator.locator(".btn")).isHidden();
        }
    }
}
