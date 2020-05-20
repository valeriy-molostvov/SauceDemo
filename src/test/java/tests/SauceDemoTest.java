package tests;

import models.User;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest {
    @Test
    public void loginTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.validateNumberOfProducts(1);
        cartPage.validateProductDetails("Sauce Labs Fleece Jacket", 1, 49.99);
        checkoutPage.openPage();
        checkoutPage.submitForm("A", "B", "1");
        checkoutPage.clickContinueButton();
        checkoutPage.checkoutOverview();
        checkoutPage.validationItemQuantity(1);
        checkoutPage.clickFinishButton();
        checkoutPage.validationConfirmationHeader();
    }

    @Test
    public void openProductPage() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openPage();
    }

    @Test
    public void loginPageTest() {
        loginPageFactory
                .openPage()
                .login(user)
                .addToCart("Sauce Labs Fleece Jacket")
                .addToCart("Sauce Labs Bike Light")
                .clickCart()
                .validateNumberOfProducts(2);
    }
}
