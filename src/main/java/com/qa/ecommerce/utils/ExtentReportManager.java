package com.qa.ecommerce.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String reportDirectory =
                    System.getProperty("user.dir")
                            + File.separator + "test-output";

            File directory = new File(reportDirectory);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            String reportPath =
                    reportDirectory
                            + File.separator
                            + "ExtentReport.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName(
                    "E-Commerce QA Automation Report"
            );

            sparkReporter.config().setDocumentTitle(
                    "E-Commerce Automation Test Results"
            );

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo(
                    "Project",
                    "E-Commerce QA Automation"
            );

            extent.setSystemInfo(
                    "Tester",
                    "Ayush Kumar Pandey"
            );

            extent.setSystemInfo(
                    "Environment",
                    "QA"
            );

            extent.setSystemInfo(
                    "Browser",
                    ConfigReader.get("browser")
            );
        }

        return extent;
    }
}