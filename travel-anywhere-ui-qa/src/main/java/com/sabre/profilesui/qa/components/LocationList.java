package com.sabre.profilesui.qa.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;

public class LocationList extends ArrayList<Locator> {
    public LocationList(Page page) {
        this.addAll(page.locator(".location").all());
    }
}
