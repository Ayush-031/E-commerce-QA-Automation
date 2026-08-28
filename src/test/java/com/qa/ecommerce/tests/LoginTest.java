package com.qa.ecommerce.tests;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.pages.LoginPage;
import com.qa.ecommerce.pages.ProductsPage;
import com.qa.ecommerce.utils.ConfigReader;
import com.qa.ecommerce.utils.TestDataReader;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class LoginTest extends BaseTest {

   @Test(
    groups = {"smoke", "regression"},
    dataProvider = "loginData"
)
public void verifyValidLogin(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();

         ProductsPage productsPage = loginPage.login(
                username,
                password
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
    @DataProvider(name = "loginData")
public Object[][] loginData() {

    return new Object[][] {
        {
            TestDataReader.get("login.username.1"),
            TestDataReader.get("login.password.1")
        },
        {
            TestDataReader.get("login.username.2"),
            TestDataReader.get("login.password.2")
        },
        {
            TestDataReader.get("login.username.3"),
            TestDataReader.get("login.password.3")
        }
    };
}
}