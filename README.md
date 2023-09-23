# webstaurantstore-demo

## About The Project
This project aims to automate test cases for the Webstaurant Store website. The automation suite is built using Selenium WebDriver in Java and follows the Page Object Model (POM) design pattern for better maintainability and readability. The tests verify product search functionality, cart operations, and UI elements on the website.

## Getting Started
### Prequistes
* Java JDK: Download and install from [here](https://www.oracle.com/java/technologies/downloads/#java11)
* Maven: Download and install from [here](https://maven.apache.org/download.cgi)
* Chrome Browser: Ensure you have the latest version installed

### Dependencies
* Selenium WebDriver
* JUnit
* WebDriverManager

All dependencies are managed by Maven and are defined in the pom.xml file.

### Setup
* Clone this repository to your local machine.
* Open a terminal and navigate to the root directory of the project.
* Run `mvn clean` install to download the dependencies.

## Running Tests
* Open a terminal and navigate to the root directory of the project.
* Run `mvn test` to execute the test suite.
