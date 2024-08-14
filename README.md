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
│                           └── TestBase.java
└── testng.xml
```

## Key Components

- **API/ContactService.java**: Contains methods for interacting with the Contact List API, such as login, create, update, and delete operations for contacts.
- **UI/pageObjects**: Contains Page Object Model (POM) classes that represent the web pages and encapsulate the interaction logic for UI elements.
- **UI/tests/ContactTests.java**: Contains the TestNG test classes for verifying the creation, update, and deletion of contacts through UI and API.
- **TestBase.java**: A base test class that includes common setup, teardown, and utility methods used across tests.

## Key Features

- **End-to-End Test Coverage**: Covers the critical functionalities of the Contact List application, including creating, updating, and deleting contacts.
- **API and UI Integration**: Utilizes both API and UI testing strategies to ensure thorough verification.
- **TestNG Annotations**: Uses TestNG annotations like `@BeforeMethod`, `@AfterMethod`, and `@Test` to manage test execution and dependencies.
- **Data-Driven Testing**: Uses JSON files to manage test data, allowing easy modification and extension of test cases.
- **Clean Up**: Ensures that each test runs independently by creating and deleting contacts before and after each test.

## Continuous Integration (CI) Pipeline

This project uses GitHub Actions for continuous integration (CI). GitHub Actions was chosen because it provides an easy-to-use solution that is fully integrated with GitHub, eliminating the need to add an external CI tool. The CI pipeline is automatically triggered on the following events:
- A push to the `master` branch
- A pull request targeting the `master` branch

### CI Pipeline Configuration

The CI pipeline is defined in a YAML file located in `.github/workflows/ci.yml`. Below is an overview of the steps performed in the pipeline:

1. Checkout Code
2. Set Up JDK 11
3. Cache Maven Packages
4. Install Dependencies and Run Tests
