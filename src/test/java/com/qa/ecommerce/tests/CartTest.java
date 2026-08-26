package com.qa.ecommerce.tests;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.pages.CartPage;
import com.qa.ecommerce.pages.LoginPage;
import com.qa.ecommerce.pages.ProductsPage;
import com.qa.ecommerce.utils.ConfigReader;
import com.qa.ecommerce.utils.TestDataReader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void verifyAddProductToCart() {

        String productName =
                TestDataReader.get("productName");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        ProductsPage productsPage = loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        Assert.assertEquals(
                productsPage.getProductsTitle(),
                "Products",
                "Products page was not displayed"
        );

        productsPage.addProductToCart(productName);

        CartPage cartPage = productsPage.openCart();

        Assert.assertTrue(
                cartPage.isProductDisplayed(productName),
                "Product was not found in cart"
        );
    }
}