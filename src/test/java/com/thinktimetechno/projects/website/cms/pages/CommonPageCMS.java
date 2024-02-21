package com.thinktimetechno.projects.website.cms.pages;

import com.thinktimetechno.keywords.WebUI;
import org.openqa.selenium.By;

public class CommonPageCMS {

    private By menuProducts = By.xpath("//span[normalize-space()='Products']");

    public void verifyDashboardPageDisplays() {
        WebUI.waitForPageLoaded();
        WebUI.verifyElementPresent(menuProducts, 10, "Login failed. The Dashboard page not displays.");
    }

}
