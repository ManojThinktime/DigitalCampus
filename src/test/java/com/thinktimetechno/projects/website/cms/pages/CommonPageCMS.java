package com.thinktimetechno.projects.website.cms.pages;
import com.thinktimetechno.projects.website.cms.pages.LoginPage;
import com.thinktimetechno.keywords.WebUI;
import org.openqa.selenium.By;

public class CommonPageCMS {
    private LoginPage loginPage;
    private By menuProducts = By.xpath("//span[normalize-space()='Products']");

    public void verifyDashboardPageDisplays() {
        WebUI.waitForPageLoaded();
        WebUI.verifyElementPresent(menuProducts, 10, "Login failed. The Dashboard page not displays.");
    }
    public LoginPage getLoginPageCMS() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

}
