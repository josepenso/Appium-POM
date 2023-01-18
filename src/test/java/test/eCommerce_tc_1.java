package test;

import com.appium.AppPages.FormPage;
import com.appium.AppPages.CatalogPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.appium.utitilies.AndroidActions;

public class eCommerce_tc_1 extends BaseTest {


    @Test
    public void fillForm() throws InterruptedException {


        FormPage formPage= new FormPage(driver);
     //   formPage.setName("ada fetic","female");

        formPage.countryDropDown().click();

        AndroidActions.scrollDownUntil(driver,"Argentina").click();
        formPage.letsGoToShop().click();
        //Thread.sleep(4000);

        AndroidActions.waitUntilVisibility(driver,formPage.productTitle,20);
        AndroidActions.scrollDownUntil(driver,"Jordan Lift Off");

        Thread.sleep(2000);
        CatalogPage productsPage = new CatalogPage(driver);

        for (int i=0;i<productsPage.getAllProductNames().size();i++){
            String productName=productsPage.getAllProductNames().get(i).getText();

            if (productName.equalsIgnoreCase("Jordan Lift Off")){

                productsPage.getAllAddToCart().get(i).click();
            }
        }

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        Thread.sleep(3000);




    }
}
