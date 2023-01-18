package com.appium.runner;


import com.appium.utitilies.Config;
import com.appium.utitilies.Driver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt" ,
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "pretty"
        },
        features = "src/test/resources/features",
        glue = "com/appium/stepDef",
        dryRun = false,
        tags = "@eCommerce",
        publish = true
)

public class CukesRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {

                return super.scenarios();
        }

       // @Parameters("Browser")

        @BeforeMethod
        public void before(){

            Driver.getDriver();



        }



       @AfterMethod
        public void tearDown(){
            Driver.closeDriver();


        }


}
