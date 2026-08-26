package com.qa.ecommerce.base;

import com.qa.ecommerce.listeners.ExtentTestListener;
import com.qa.ecommerce.utils.ConfigReader;
import com.qa.ecommerce.utils.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(ExtentTestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.createDriver(
                ConfigReader.get("browser")
        );

        driver.manage().window().maximize();
    }
    
    public WebDriver getDriver() {
    return driver;
}

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}