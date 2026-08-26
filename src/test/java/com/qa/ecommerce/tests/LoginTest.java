package com.qa.ecommerce.tests;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.pages.LoginPage;
import com.qa.ecommerce.pages.ProductsPage;
import com.qa.ecommerce.utils.ConfigReader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void verifyValidLogin() {

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
    }

    @Test(groups = {"regression"})
    public void verifyInvalidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();

        loginPage.login(
                ConfigReader.get("username"),
                "wrong_password"
        );

        Assert.assertTrue(
                loginPage.getErrorMessage().contains(
                        "Username and password do not match"
                ),
                "Expected login error message was not displayed"
        );
    }
}