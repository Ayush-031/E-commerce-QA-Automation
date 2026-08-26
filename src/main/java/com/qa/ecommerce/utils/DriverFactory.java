package com.qa.ecommerce.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {

        if (browser == null || browser.isBlank()) {
            browser = "chrome";
        }

        switch (browser.toLowerCase()) {

            case "chrome":

                ChromeOptions options = new ChromeOptions();

                // Disable Chrome password manager
                options.addArguments("--disable-notifications");

                options.setExperimentalOption(
                        "prefs",
                        java.util.Map.of(
                                "credentials_enable_service", false,
                                "profile.password_manager_enabled", false,
                                "profile.password_manager_leak_detection", false
                        )
                );

                return new ChromeDriver(options);

            case "firefox":
                return new FirefoxDriver();

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                );
        }
    }
}