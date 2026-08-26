package com.qa.ecommerce.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.utils.ExtentReportManager;
import com.qa.ecommerce.utils.ScreenshotUtils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class ExtentTestListener implements ITestListener {

    private static final ExtentReports extent =
            ExtentReportManager.getInstance();

    private static final ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(
                        result.getMethod().getMethodName()
                );

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        Object testInstance = result.getInstance();

        if (testInstance instanceof BaseTest) {

            WebDriver driver =
                    ((BaseTest) testInstance).getDriver();

            if (driver != null) {

                String screenshotPath =
                        ScreenshotUtils.captureScreenshot(
                                driver,
                                result.getMethod().getMethodName()
                        );

                if (screenshotPath != null) {

                    test.get().addScreenCaptureFromPath(
                            screenshotPath
                    );
                }
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}