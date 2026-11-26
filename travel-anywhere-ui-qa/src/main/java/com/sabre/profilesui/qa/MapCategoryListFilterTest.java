package com.sabre.profilesui.qa;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Locator;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MapCategoryListFilterTest {

    static String atkToken = System.getProperty("atkToken");
    private Playwright playwright;
    private Browser browser;
    private Page page;
    @BeforeClass
    public void setUp() {
        System.err.println(atkToken.length()); // fails fast if token is null
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newContext().newPage();
        page.navigate("http://localhost:3000/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("ATK Token")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("ATK Token")).fill(atkToken);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

    }
    @BeforeMethod
    void clickOnMapAndDeselect() {
        page.navigate("http://localhost:3000/");
        page.locator("div").filter(new Locator.FilterOptions().setHasText("+− Leaflet | © OpenStreetMap")).nth(3).click();
        String[] categories = {"hotel", "air", "rail", "car"};
        for (String category : categories) {
            Locator checkbox = page.locator("input[name='" + category + "']");
            if (checkbox.isChecked()) {
                checkbox.uncheck();
            }
        }
    }
    @Test
    public void shouldFilterMapByHotelCategoryAndOneElementBeVisible() {
        page.locator("input[name='hotel']").uncheck();
        assertThat(page.getByText("MapBookingsSign out+− Leaflet")).isVisible();
        page.locator("input[name='hotel']").check();
        assertThat(page.locator("body")).containsText("Category: HOTEL");
    }

    @Test
    public void shouldFilterMapByAirCategoryAndOneElementBeVisible() {
        page.locator("input[name='air']").check();
        assertThat(page.locator("body")).containsText("Category: AIR");
    }

    @Test
    public void shouldFilterMapByRailCategoryAndOneElementBeVisible() {
        page.locator("div")
                .filter(new Locator.FilterOptions()
                        .setHasText(Pattern.compile("^rail$")))
                .click();
        page.locator("input[name='rail']").check();
        assertThat(page.locator("body")).containsText("Category: RAIL");
    }

    @Test
    public void shouldFilterMapByCarCategoryAndOneElementBeVisible() {
        page.locator("input[name='car']").check();
        assertThat(page.locator("body")).containsText("Category: CAR");
    }

    @Test
    public void shouldChangeMapCategoryWhenSelectingDifferentFilters() {
        page.locator("input[name='air']").check();
        assertThat(page.locator("body")).containsText("Category: AIR");
        page.locator("input[name='air']").uncheck();
        page.locator("input[name='rail']").check();
        assertThat(page.locator("body")).containsText("Category: RAIL");
        page.locator("input[name='rail']").uncheck();
        page.locator("input[name='car']").check();
        assertThat(page.locator("body")).containsText("Category: CAR");
    }
}

