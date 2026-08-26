# E-Commerce QA Automation Framework

A Java-based UI automation framework built using Selenium WebDriver, TestNG, and Maven for validating critical e-commerce user workflows.
The framework follows the Page Object Model (POM) design pattern and provides reusable utilities for WebDriver management, configuration, explicit waits, and test execution.

----------------------------------

## 🚀 Features

- Selenium WebDriver-based UI automation
- Page Object Model (POM) architecture
- Reusable WebDriver initialization and teardown
- Centralized configuration management
- Reusable explicit wait utilities
- TestNG test execution and grouping
- Smoke and Regression test groups
- Maven-based test execution
- Chrome and Firefox browser support
- Login workflow validation
- Product and cart workflow validation
- Checkout workflow validation
- Git/GitHub version control

--------------------------------

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Programming language |
| Selenium WebDriver 4.35.0 | Browser automation |
| TestNG 7.11.0 | Test framework |
| Maven | Build and dependency management |
| Chrome / Firefox | Browser automation |
| Git & GitHub | Version control |

---------------------------------

## 📁 Project Structure

ecommerce-qa-automation/
│
├── pom.xml
├── testng.xml
├── README.md
│
└── src/
    │
    ├── main/
    │   └── java/
    │       └── com/
    │           └── qa/
    │               └── ecommerce/
    │                   │
    │                   ├── pages/
    │                   │   ├── LoginPage.java
    │                   │   ├── ProductsPage.java
    │                   │   ├── CartPage.java
    │                   │   ├── CheckoutPage.java
    │                   │   ├── CheckoutOverviewPage.java
    │                   │   └── OrderConfirmationPage.java
    │                   │
    │                   └── utils/
    │                       ├── ConfigReader.java
    │                       ├── DriverFactory.java
    │                       ├── TestDataReader.java
    │                       └── WaitUtils.java
    │
    └── test/
        │
        ├── java/
        │   └── com/
        │       └── qa/
        │           └── ecommerce/
        │               ├── base/
        │               │   └── BaseTest.java
        │               │
        │               └── tests/
        │                   ├── LoginTest.java
        │                   ├── CartTest.java
        │                   └── CheckoutTest.java
        │
        └── resources/
            ├── config.properties
            ├── testdata.properties
            └── testng.xml

--------------------------------

## 🏗️ Framework Architecture
The framework separates test logic, page interactions, utilities, and configuration to improve maintainability and reusability.

----------------------------------

## Page Objects
The pages package contains classes representing different application pages.
Examples:
LoginPage
ProductsPage
CartPage
CheckoutPage
CheckoutOverviewPage
OrderConfirmationPage

Page classes contain locators and reusable page actions, keeping Selenium interaction logic separate from test cases.
----------------------------------

## Utilities
The utils package contains reusable framework components:

DriverFactory — creates and configures WebDriver instances
ConfigReader — reads framework configuration
TestDataReader — reads test data
WaitUtils — provides reusable explicit wait operations

----------------------------------

## Base Test
BaseTest provides common test setup and cleanup functionality.
It handles:

WebDriver initialization
Browser configuration
Browser window setup
Test cleanup
WebDriver termination

Test classes extend BaseTest to reuse the common setup and teardown logic.
-----------------------------------

## 🧪 Test Coverage
The current automation suite covers critical e-commerce workflows.

Login
Valid login
Invalid login
Cart
Product addition to cart
Cart validation
Checkout
Checkout information
Checkout workflow
Order completion

▶️ Running the Tests
Run the Complete Test Suite
mvn clean test
Run Smoke Tests
mvn clean test -Dgroups=smoke
Run Regression Tests
mvn clean test -Dgroups=regression

📊 Test Execution
The current test suite successfully executes:
Tests run: 4
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
Smoke Test Execution
2 tests
2 passed
Regression Test Execution
4 tests
4 passed

-------------------------------

## ⚙️ Configuration
Test configuration is maintained separately from Java test code using a properties file.
Example:
browser=chrome
baseUrl=https://www.saucedemo.com/
username=standard_user
password=secret_sauce

This allows configuration changes without modifying the test implementation.

------------------------------

## 🔄 Test Execution Flow
TestNG Test
     ↓
 BaseTest
     ↓
DriverFactory
     ↓
 WebDriver
     ↓
 Page Object
     ↓
Application
     ↓
 Assertion
     ↓
Test Result

----------------------------

## 🎯 Design Principles

The framework focuses on:
Reusability
Maintainability
Separation of concerns
Page Object Model
Centralized configuration
Reusable wait mechanisms
Group-based test execution
Clean test and framework separation

---------------------------

## 🔐 Test Data Management
Test data and configuration are maintained separately from the test implementation.
This approach helps avoid hard-coding configuration values directly inside test classes and makes the framework easier to maintain.

-----------------------------

## 📈 Future Improvements
Planned improvements include:
HTML test reporting
Automatic screenshots on test failure
Structured logging
Parallel test execution
Cross-browser test execution
Data-driven testing
GitHub Actions CI/CD integration
Enhanced test reporting and dashboards
------------------------------

## 👨‍💻 Author
Ayush Kumar Pandey

This project demonstrates practical experience with:
Java
Selenium WebDriver
TestNG
Maven
Page Object Model
Test automation framework design
Git and GitHub 

--------------------------------

## 📌 Project Status
Active Development

The core automation framework is implemented with working login, cart, and checkout test flows. Additional reporting, logging, and CI/CD capabilities are planned as future enhancements.