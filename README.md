# Contact List Automation Test Suite

## Overview

This project is an automation test suite designed to perform end-to-end (E2E) tests on a Contact List application. The test suite is built using Java, Selenium WebDriver, RestAssured, and TestNG, and it automates key functionalities such as creating, updating, and deleting contacts through both the UI and API.

## Project Structure

```
├── README.md
├── TestData
│   ├── contactData.json
│   ├── credentials.json
│   └── updatedContact.json
├── pom.xml
├── src
│   └── test
│       └── java
│           └── org
│               └── automation
│                   ├── API
│                   │   ├── ContactService.java
│                   │   └── Utils.java
│                   └── UI
│                       ├── pageObjects
│                       │   ├── LoginPage.java
│                       │   └── MainContactsPage.java
│                       └── tests
│                           ├── ContactTests.java
│                           └── PageBase.java
└── testng.xml
```

## Key Components

- **API/Utils.java**: Contains utility methods for interacting with the Contact List API, such as login, create, update, and delete operations for contacts.
- **UI/pageObjects**: Contains Page Object Model (POM) classes that represent the web pages and encapsulate the interaction logic for UI elements.
- **UI/tests/ContactTests.java**: Contains the TestNG test classes for verifying the creation, update, and deletion of contacts through UI and API.
- **BaseTest.java**: A base test class that includes common setup, teardown, and utility methods used across tests.

## Key Features

- **End-to-End Test Coverage**: Covers the critical functionalities of the Contact List application, including creating, updating, and deleting contacts.
- **API and UI Integration**: Utilizes both API and UI testing strategies to ensure thorough verification.
- **TestNG Annotations**: Uses TestNG annotations like `@BeforeMethod`, `@AfterMethod`, and `@Test` to manage test execution and dependencies.
- **Data-Driven Testing**: Uses JSON files to manage test data, allowing easy modification and extension of test cases.
- **Clean Up**: Ensures that each test runs independently by creating and deleting contacts before and after each test.
