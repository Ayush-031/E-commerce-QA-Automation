package com.qa.ecommerce.pages;

import com.qa.ecommerce.utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By checkoutButton =
            By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public boolean isProductDisplayed(String productName) {

        By product = By.xpath(
                "//div[@class='inventory_item_name' and text()='"
                        + productName
                        + "']"
        );

        try {
            waitUtils.waitForVisible(product);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public CheckoutPage clickCheckout() {

        waitUtils.click(checkoutButton);

        return new CheckoutPage(driver);
    }
}