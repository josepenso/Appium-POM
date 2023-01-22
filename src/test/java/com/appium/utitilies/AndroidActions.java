package com.appium.utitilies;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidActions  extends AppiumUtils{


    public static void longPressAction(AndroidDriver driver, WebElement ele)
    {
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
                        "duration",2000));
    }

    public static void swipeAction(AndroidDriver driver,WebElement element,String direction)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)element).getId(),

                "direction", direction,
                "percent", 0.75
        ));

    }

    public static WebElement scrollDownUntil(AndroidDriver driver,String option){

        return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+option+"\"));"));


    }

    public  static void waitUntilVisibility(AndroidDriver driver,WebElement element, int duration){

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOf(element));


    }


}
