# Selenium TestNG Framework 🚀
## 📌 Overview
This project is a **Selenium Test Automation Framework** using **TestNG** for parallel execution, **Extent Reports** for logging, and **Page Object Model (POM)** for maintainability. The framework is **thread-safe** using `DriverManager` and stores **XPath locators separately**.

---

## 🛠️ Tech Stack
- **Language**: Java 21+
- **Testing Framework**: TestNG
- **Automation Tool**: Selenium WebDriver
- **Dependency Management**: Maven
- **Reporting**: Extent Reports
- **Design Pattern**: Page Object Model (POM)
- **Thread Safety**: ThreadLocal in `DriverManager`

---

## 📁 Project Structure

Selenium-TestNG-Project/ 
│── src/ 
│
├── main/
│    │ 
│    └── java/
│        │
│        └──utils/ 
│               ├── DriverManager.java <-- Thread-safe WebDriver Manager
│               └── ConfigReader.java
├── test/ 
│    └── java/
│           │       
│           ├── locators/
│           │     └── locators.java <-- Stores XPath separately       
│           │
│           ├── pages/
│           │       ├── BasePage.java <-- Stores Reusable Selenium methods
│           │       ├── x..Page.Java <-- Store java methods based on UI Pages
│           ├── tests/ 
│           │   ├── BaseTest.java <-- Common setup & teardown for all tests 
│           │   ├──
│           │
│           ├── ReportManager.java <-- Extent Report generation methods
│           ├── resources/ 
│                   ├── config/ 
│                       └── selenium.properties <-- Config file for browser & timeouts
├── pom.xml <-- Maven dependencies 
│── testng.xml <-- Test execution suite
└── README.md <-- Documentation

---
## 📦 Dependencies (Maven)
Add these dependencies to `pom.xml`:

```xml
<dependencies>
    <!-- Selenium -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.10.0</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
        <scope>test</scope>
    </dependency>

    <!-- WebDriverManager (for automatic driver setup) -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.8.0</version>
    </dependency>

    <!-- Extent Reports for Reporting -->
    <dependency>
        <groupId>com.aventstack</groupId>
        <artifactId>extentreports</artifactId>
        <version>5.0.9</version>
    </dependency>
</dependencies>
```

---
## 🚀 How to Run Tests

1️⃣ Clone the Repository
    git clone https://github.com/ram26r/yahoo_Finance.git
    cd Selenium-TestNG-Project

2️⃣ Install Dependencies
    mvn clean install

3️⃣ Run Tests
    Option 1: Using TestNG XML
            `mvn test`
    Option 2: Using a Specific Test Class
        `mvn -Dtest=CrossPlatformTest test`

---
## 📊 Generating Reports
After running the tests:

TestNG Default Report: test-output/index.html
Extent Report: test-output/ExtentReport.html
📌 To open the report, navigate to test-output/ExtentReport.html and open it in a browser.

---

## 🖥️ Running Tests in Parallel

To run tests in multiple browsers, edit testng.xml:

```xml
<suite name="CrossPlatformSuite" parallel="tests" thread-count="3">
    <test name="ChromeTest">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="tests.HomePageTest"/>
        </classes>
    </test>
    <test name="FirefoxTest">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="tests.HomePageTest"/>
        </classes>
    </test>
    <test name="EdgeTest">
        <parameter name="browser" value="edge"/>
        <classes>
            <class name="tests.HomePageTest"/>
        </classes>
    </test>
</suite>
```
Run: `mvn test -Dsurefire.suiteXmlFiles=testng.xml`


---

## 👨‍💻 Contributing

- **Fork the repository.**
- **Create a feature branch: git checkout -b feature-branch-name**
- **Commit changes: git commit -m "Your message"**
- **Push to branch: git push origin feature-branch-name**
- **Submit a Pull Request.**

---

## 🎯 Happy Testing! 🚀

### **📌 Why This README is Useful?**
✅ **Explains project setup & structure** for new users.  
✅ **Includes commands to install dependencies & run tests.**  
✅ **Documents parallel execution and reports.**  
✅ **Helps contributors understand how to contribute.**

Would you like to add a **badge section (e.g., Test Status, Build Status)** at the top?
