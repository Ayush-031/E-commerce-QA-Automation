package com.qa.ecommerce.base;

import com.qa.ecommerce.listeners.ExtentTestListener;
import com.qa.ecommerce.utils.ConfigReader;
import com.qa.ecommerce.utils.DriverFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(ExtentTestListener.class)
public class BaseTest {

    protected WebDriver driver;

    private static final Logger logger =
            LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {

        logger.info("Starting test setup");

        driver = DriverFactory.createDriver(
                ConfigReader.get("browser"),
                Boolean.parseBoolean(
                        ConfigReader.get("headless")
                )
        );

        driver.manage().window().maximize();

        logger.info("WebDriver initialized successfully");
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void tearDown() {

        logger.info("Starting test teardown");

        if (driver != null) {
            driver.quit();
            logger.info("WebDriver closed successfully");
        }
    }
}