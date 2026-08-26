package com.qa.ecommerce.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtils {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        try {
            Path screenshotDirectory = Path.of(
                    System.getProperty("user.dir"),
                    "test-output",
                    "screenshots"
            );

            Files.createDirectories(screenshotDirectory);

            String fileName = testName
                    + "_"
                    + System.currentTimeMillis()
                    + ".png";

            Path destination = screenshotDirectory.resolve(fileName);

            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Files.copy(
                    source.toPath(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING
            );

            return destination.toString();

        } catch (Exception e) {

            System.out.println(
                    "Failed to capture screenshot: "
                            + e.getMessage()
            );

            return null;
        }
    }
}