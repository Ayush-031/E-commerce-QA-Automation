package com.qa.ecommerce.pages;

import com.qa.ecommerce.utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By firstNameField =
            By.id("first-name");

    private final By lastNameField =
            By.id("last-name");

    private final By postalCodeField =
            By.id("postal-code");

    private final By continueButton =
            By.id("continue");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void enterCustomerInformation(
            String firstName,
            String lastName,
            String postalCode) {

        waitUtils.type(firstNameField, firstName);
        waitUtils.type(lastNameField, lastName);
        waitUtils.type(postalCodeField, postalCode);
    }

    public CheckoutOverviewPage clickContinue() {

        waitUtils.click(continueButton);

        return new CheckoutOverviewPage(driver);
    }
}
