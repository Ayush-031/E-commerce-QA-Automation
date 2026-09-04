package com.qa.ecommerce.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static final Logger logger =
            LoggerFactory.getLogger(DriverFactory.class);

    public static WebDriver createDriver(
            String browser,
            boolean headless) {

        if (browser == null || browser.isBlank()) {
            browser = "chrome";
        }

        logger.info("Creating WebDriver for browser: {}", browser);

        switch (browser.toLowerCase()) {

            case "chrome":

                ChromeOptions options = new ChromeOptions();

                options.addArguments("--disable-notifications");

                options.setExperimentalOption(
                        "prefs",
                        java.util.Map.of(
                                "credentials_enable_service", false,
                                "profile.password_manager_enabled", false,
                                "profile.password_manager_leak_detection", false
                        )
                );

                if (headless) {
                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");

                    logger.info("Chrome running in headless mode");
                }

                logger.info("Starting ChromeDriver");

                return new ChromeDriver(options);

            case "firefox":

                logger.info("Starting FirefoxDriver");

                return new FirefoxDriver();

            default:

                logger.error(
                        "Unsupported browser requested: {}",
                        browser
                );

                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                );
        }
    }
}