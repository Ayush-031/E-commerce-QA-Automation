package com.qa.ecommerce.pages;

import com.qa.ecommerce.utils.ConfigReader;
import com.qa.ecommerce.utils.WaitUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private static final Logger logger =
            LoggerFactory.getLogger(LoginPage.class);

    private final By usernameField =
            By.id("user-name");

    private final By passwordField =
            By.id("password");

    private final By loginButton =
            By.id("login-button");

    private final By errorMessage =
            By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void open() {

        logger.info("Opening login page");

        driver.get(ConfigReader.get("baseUrl"));
    }

    public ProductsPage login(String username, String password) {

        logger.info("Entering username");

        waitUtils.type(usernameField, username);

        logger.info("Entering password");

        waitUtils.type(passwordField, password);

        logger.info("Clicking login button");

        waitUtils.click(loginButton);

        logger.info("Login action completed");

        return new ProductsPage(driver);
    }

    public String getErrorMessage() {

        logger.info("Retrieving login error message");

        return waitUtils.getText(errorMessage);
    }
}