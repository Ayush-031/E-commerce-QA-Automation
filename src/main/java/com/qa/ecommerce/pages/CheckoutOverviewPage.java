package com.qa.ecommerce.pages;

import com.qa.ecommerce.utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By overviewTitle =
            By.cssSelector("[data-test='title']");

    private final By finishButton =
            By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public String getOverviewTitle() {
        return waitUtils.getText(overviewTitle);
    }

    public OrderConfirmationPage clickFinish() {

        waitUtils.click(finishButton);

        return new OrderConfirmationPage(driver);
    }
}
