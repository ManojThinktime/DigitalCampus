package com.thinktimetechno.runners;

import com.thinktimetechno.hooks.CucumberListener;
import com.thinktimetechno.utils.EmailSendUtils;
import com.thinktimetechno.utils.ZipUtils;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/SigninCRM.feature",
        glue = {"com.anhtester.projects.website.crm.stepdefinitions",
                "com.anhtester.hooks"},
        plugin = {"com.anhtester.hooks.CucumberListener",
                "pretty",
                "html:target/cucumber-reports/SigninCRMTestRunner.html",
                "json:target/cucumber-reports/SigninCRMTestRunner.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        , monochrome = true,
        tags = "@Regression or @Smoke"
)

public class SigninCRMTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("================ AFTER SUITE ================");
        ZipUtils.zipReportFolder();
        EmailSendUtils.sendEmail(CucumberListener.count_totalTCs
                , CucumberListener.count_passedTCs
                , CucumberListener.count_failedTCs
                , CucumberListener.count_skippedTCs);
    }
}
