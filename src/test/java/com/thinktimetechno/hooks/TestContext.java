package com.thinktimetechno.hooks;

import com.thinktimetechno.driver.DriverManager;
import com.thinktimetechno.driver.TargetFactory;
import com.thinktimetechno.projects.website.cms.pages.CommonPageCMS;
import com.thinktimetechno.projects.website.cms.pages.LoginPage;
import com.thinktimetechno.utils.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {

    private WebDriver driver;

    public TestContext() {
//        System.setProperty("webdriver.http.factory", "jdk-http-client");
//        driver = ThreadGuard.protect(new TargetFactory().createInstance());
//        driver.manage().window().maximize();
//        DriverManager.setDriver(driver);
//        LogUtils.info("Driver in TestContext: " + getDriver());
    }

    private LoginPage loginPage;
    private CommonPageCMS commonPageCMS;

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public CommonPageCMS getCommonPage() {
        if (commonPageCMS == null) {
            commonPageCMS = new CommonPageCMS();
        }
        return commonPageCMS;
    }

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }

}
