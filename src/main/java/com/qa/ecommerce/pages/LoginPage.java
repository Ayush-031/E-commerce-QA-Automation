package com.qa.ecommerce.pages;

import com.qa.ecommerce.utils.ConfigReader;
import com.qa.ecommerce.utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

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
        driver.get(ConfigReader.get("baseUrl"));
    }

    public ProductsPage login(String username, String password) {

        waitUtils.type(usernameField, username);
        waitUtils.type(passwordField, password);
        waitUtils.click(loginButton);

        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        return waitUtils.getText(errorMessage);
    }
}
