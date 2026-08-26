package com.qa.ecommerce.base;

import com.qa.ecommerce.utils.ConfigReader;
import com.qa.ecommerce.utils.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {


        driver = DriverFactory.createDriver(
                ConfigReader.get("browser")
        );


        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}