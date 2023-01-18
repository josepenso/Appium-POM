package com.appium.AppPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage {

AndroidDriver driver;
    public FormPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "android:id/text1")
    private WebElement countryDropDown;

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameBox;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleRadioElement;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleRadioElement;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsGoShopElement;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[1]")
    public WebElement productTitle;

    public void setName(String name){

        nameBox.sendKeys(name);

    }

    public void setGender(String gender){
        if (gender.equalsIgnoreCase("male")){
            maleRadioElement.click();
        }
        if (gender.equalsIgnoreCase("female")){
            femaleRadioElement.click();
        }
    }

    public WebElement countryDropDown(){
        return countryDropDown;
    }
    public WebElement letsGoToShop(){

        return letsGoShopElement;
    }











}