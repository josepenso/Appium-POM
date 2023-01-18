package com.appium.AppPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import test.BaseTest;

import java.util.List;

public class CatalogPage  {

    AndroidDriver driver;
    public CatalogPage(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
    private List<WebElement> addToCart;


    @AndroidFindBy(id ="com.androidsample.generalstore:id/productName")
    private List<WebElement> allProductNames;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> allProductPrice;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement shoppingCartIcon;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[1]")
    private WebElement shoppingCartTitle;


    public List<WebElement> getAllAddToCart(){

        return addToCart;
    }

    public List<WebElement>getAllProductNames(){

        return allProductNames;
    }

    public List<WebElement> getAllProductPrice(){
        return allProductPrice;
    }

    public WebElement getShoppingCartIcon(){
        return shoppingCartIcon;
    }

    public WebElement getShoppingCartTitle(){
        return shoppingCartTitle;
    }







}
