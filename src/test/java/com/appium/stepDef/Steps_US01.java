package com.appium.stepDef;

import com.appium.AppPages.CatalogPage;
import com.appium.AppPages.FormPage;
import com.appium.AppPages.ShoppingCartPage;
import com.appium.utitilies.AndroidActions;
import com.appium.utitilies.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Steps_US01  {

    @Given("the user is in the {string} app")
    public void the_user_is_in_the_app(String string) {

    }
    FormPage formPage= new FormPage(Driver.getDriver());
    @When("the user select {string}")
    public void the_user_select(String country) throws InterruptedException {

        Thread.sleep(4000);
        formPage.countryDropDown().click();
        AndroidActions.scrollDownUntil(Driver.getDriver(),country).click();


    }
    @When("the user write {string}")
    public void the_user_write(String name) {

        formPage.setName(name);

    }
    @When("the user select {string} gender")
    public void the_user_select_gender(String gender) {

        formPage.setGender(gender);
    }
    @Then("the user select Let's Shop")
    public void the_user_select_let_s_shop() throws InterruptedException {

        formPage.letsGoToShop().click();
     Thread.sleep(2000);
    }

    String expectedShoesName ="";

    CatalogPage catalogPage= new CatalogPage(Driver.getDriver());

    @Then("the user add to cart {string}")
    public void the_user_add_to_cart(String shoes) {
        expectedShoesName =shoes;

        AndroidActions.scrollDownUntil(Driver.getDriver(),shoes);
        for (int i=0;i<catalogPage.getAllProductNames().size();i++){
            String productName=catalogPage.getAllProductNames().get(i).getText();

            if (productName.equalsIgnoreCase(expectedShoesName)){

                catalogPage.getAllAddToCart().get(i).click();
            }
        }

    }
    @Then("the user clicks on Shopping cart icon")
    public void the_user_clicks_on_shopping_cart_icon() {

        catalogPage.getShoppingCartIcon().click();
        AndroidActions.waitUntilVisibility(Driver.getDriver(),catalogPage.getShoppingCartTitle(),20);
    }

    ShoppingCartPage shoppingCartPage= new ShoppingCartPage(Driver.getDriver());
    @Then("the user verifies shoes {string} are in the shopping cart")
    public void the_user_verifies_shoes_are_in_the_shopping_cart(String shoesName) {

        for (int i=0;i<shoppingCartPage.getAllProducts().size();i++){
            String actualShoesName=shoppingCartPage.getAllProducts().get(i).getText();
            if (shoesName.equalsIgnoreCase(actualShoesName)){
                Assert.assertEquals(shoppingCartPage.getAllProducts().get(i).getText(),shoesName);
            }
        }

    }
    @Then("the user verifies total amount is {string}")
    public void the_user_verifies_total_amount_is(String totalAmount) {

       Double expectedAmount= AndroidActions.getFormattedAmount(totalAmount);
       Double actualAmount=AndroidActions.getFormattedAmount(shoppingCartPage.getTotalAmountElement().getText());

       Assert.assertEquals(actualAmount,expectedAmount);


    }
    @Then("the user complete the purchase")
    public void the_user_complete_the_purchase() {

        shoppingCartPage.getSendEmailCheckBox().click();
        shoppingCartPage.getPurchaseButton().click();
    }


}
