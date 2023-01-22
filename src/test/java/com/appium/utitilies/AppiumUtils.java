package com.appium.utitilies;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;


public class AppiumUtils {
    AppiumDriverLocalService service;
    public  static Double getFormattedAmount(String amount){
        Double price= Double.parseDouble(amount.substring(1));
        return price;
    }

    public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
        if (service!=null){
            return service;
        }

        service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress(ipAddress).usingPort(port).build();
        service.start();
        return service;
    }
}
