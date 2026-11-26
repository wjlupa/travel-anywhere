package com.sabre.profilesui.qa.components;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class PlaywrightRunner {
    static String atkToken = System.getProperty("atkToken");

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeClass(alwaysRun = true)
    public void initializePlaywrightAndLogin() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        page = browser.newContext().newPage();

        page.navigate("http://localhost:3000/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("ATK Token")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("ATK Token")).fill(atkToken);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        page.close();
        browser.close();
        playwright.close();
    }
}
