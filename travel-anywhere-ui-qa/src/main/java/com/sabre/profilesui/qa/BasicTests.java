package com.sabre.profilesui.qa;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BasicTests {
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
    @Test
    public void test1() {
        page.navigate("http://localhost:3000/");
        page.locator("div").filter(new Locator.FilterOptions().setHasText("+− Leaflet | © OpenStreetMap")).nth(3).click();
        page.locator(".btn").first().click();
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
    public void test_first_name_length_validator() {
        page.navigate("http://localhost:3000/");
        page.locator("div").filter(new Locator.FilterOptions().setHasText("+− Leaflet | © OpenStreetMap")).nth(3).click();
        page.locator(".btn").first().click();


        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
        assertThat(page.locator(".firstNameGroup").locator(".invalid-feedback")).hasText("Required");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First name")).fill("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
        assertThat(page.locator(".firstNameGroup").locator(".invalid-feedback")).hasText("Max 40 characters");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First name")).fill("Adam");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
        assertThat(page.locator(".firstNameGroup").locator(".invalid-feedback")).isEmpty();
    }
    @AfterClass
    public void tearDown() {
        page.close();
        browser.close();
        playwright.close();
    }
}