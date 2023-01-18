package com.appium.AppPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.de.Wenn;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage {

    AndroidDriver driver;
    public ShoppingCartPage(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id ="com.androidsample.generalstore:id/productName")
    private List<WebElement> allProducts;

    @AndroidFindBy(id ="com.androidsample.generalstore:id/productPrice")
    private List<WebElement> allProductsPrice;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmountElement;

    @AndroidFindBy(xpath = "//android.widget.CheckBox")
    private WebElement sendEmailCheckBox;

    @AndroidFindBy(id ="com.androidsample.generalstore:id/btnProceed")
    private WebElement purchaseButton;

    public List<WebElement> getAllProducts(){

        return allProducts;
    }


    public List<WebElement> getAllProductsPrice(){
        return allProductsPrice;

    }

    public WebElement getTotalAmountElement(){

        return totalAmountElement;

    }

    public WebElement getSendEmailCheckBox(){
        return sendEmailCheckBox;
    }

    public WebElement getPurchaseButton(){

        return purchaseButton;

    }


















}
