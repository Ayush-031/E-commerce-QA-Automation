package com.qa.ecommerce.tests;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.pages.CartPage;
import com.qa.ecommerce.pages.CheckoutOverviewPage;
import com.qa.ecommerce.pages.CheckoutPage;
import com.qa.ecommerce.pages.LoginPage;
import com.qa.ecommerce.pages.OrderConfirmationPage;
import com.qa.ecommerce.pages.ProductsPage;
import com.qa.ecommerce.utils.ConfigReader;
import com.qa.ecommerce.utils.TestDataReader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(groups = {"regression"})
    public void verifyCheckoutFlow() {

        String productName =
                TestDataReader.get("productName");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        ProductsPage productsPage = loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        productsPage.addProductToCart(productName);

        CartPage cartPage = productsPage.openCart();

        Assert.assertTrue(
                cartPage.isProductDisplayed(productName),
                "Product was not found in cart"
        );

        CheckoutPage checkoutPage =
                cartPage.clickCheckout();

        checkoutPage.enterCustomerInformation(
                TestDataReader.get("firstName"),
                TestDataReader.get("lastName"),
                TestDataReader.get("postalCode")
        );

        CheckoutOverviewPage overviewPage =
                checkoutPage.clickContinue();

        Assert.assertEquals(
                overviewPage.getOverviewTitle(),
                "Checkout: Overview",
                "Checkout overview page was not displayed"
        );

        OrderConfirmationPage confirmationPage =
                overviewPage.clickFinish();

        Assert.assertEquals(
                confirmationPage.getConfirmationMessage(),
                "Thank you for your order!",
                "Order was not completed successfully"
        );
    }
}