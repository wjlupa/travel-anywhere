package com.sabre.profilesui.qa;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Locator;

import java.util.List;

public class MapCategoryListFilterTest extends PlaywrightRunner {
    MainPage mainPage;
    @BeforeClass
    void setUpMainPage() {
        mainPage = new MainPage(page);
        mainPage.open();
    }
    @BeforeMethod
    void clickOnMapAndDeselect() {
        mainPage.clickOnMap();
        mainPage.deselectCheckBoxes();
    }
    public void shouldAllLocationsHaveText(String expectedCategoryText) {
        List<Locator> locationsLocators = page.locator(".location").all();
        for (Locator locator : locationsLocators) {
            assertThat(locator).containsText(expectedCategoryText);
        }
    }
    @Test
    public void shouldFilterMapByHotelCategoryAndOneElementBeVisible() {
        page.locator("input[name='hotel']").check();
        shouldAllLocationsHaveText("Category: HOTEL");
    }

    @Test
    public void shouldFilterMapByAirCategoryAndOneElementBeVisible() {
        page.locator("input[name='air']").check();
        shouldAllLocationsHaveText("Category: AIR");
    }

    @Test
    public void shouldFilterMapByRailCategoryAndOneElementBeVisible() {
        page.locator("input[name='rail']").check();
        shouldAllLocationsHaveText("Category: RAIL");
    }

    @Test
    public void shouldFilterMapByCarCategoryAndOneElementBeVisible() {
        page.locator("input[name='car']").check();
        shouldAllLocationsHaveText("Category: CAR");
    }
}

