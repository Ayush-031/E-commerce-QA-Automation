package com.qa.ecommerce.pages;

import com.qa.ecommerce.utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By productsTitle =
            By.cssSelector("[data-test='title']");

    private final By cartIcon =
            By.cssSelector("[data-test='shopping-cart-link']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public String getProductsTitle() {
        return waitUtils.getText(productsTitle);
    }

    public void addProductToCart(String productName) {

        String productId = productName
                .toLowerCase()
                .replace(" ", "-");

        By addToCartButton =
                By.id("add-to-cart-" + productId);

        waitUtils.click(addToCartButton);
    }

    public CartPage openCart() {

        waitUtils.click(cartIcon);

        return new CartPage(driver);
    }

}
