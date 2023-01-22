package com.appium.utitilies;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver!=null){

            return driver;
        }

        UiAutomator2Options options= new UiAutomator2Options();
        options.setDeviceName(Config.getProperty("device"));
        options.setApp(System.getProperty("user.dir")+Config.getProperty("eCommerceApp"));
        options.setChromedriverExecutable(Config.getProperty("chromeBrowser"));

    try{
        driver= new AndroidDriver(new URL("http://0.0.0.0:4723"),options);
    }catch (MalformedURLException e){

        e.printStackTrace();
    }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;

    }

    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver= null;
        }
    }







}
