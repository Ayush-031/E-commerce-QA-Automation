package com.qa.ecommerce.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

public class DriverFactory {

  public static WebDriver createDriver(String browser, boolean headless){

        if (browser == null || browser.isBlank()) {
            browser = "chrome";
        }

        switch (browser.toLowerCase()) {

            case "chrome":

    ChromeOptions options = new ChromeOptions();

    if (headless) {
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
    }

    options.addArguments("--window-size=1920,1080");
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