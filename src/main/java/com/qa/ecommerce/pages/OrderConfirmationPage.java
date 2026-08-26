package com.qa.ecommerce.pages;

import com.qa.ecommerce.utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By confirmationMessage =
            By.cssSelector("[data-test='complete-header']");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public String getConfirmationMessage() {
        return waitUtils.getText(confirmationMessage);
    }
}
