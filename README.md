
# <p align="center">Mobile automation project for Wikipedia App</p>

<p align="center" ><a href="https://www.visitacity.com">
<img width=60% title="VISITACITY" src="media/images/wikipedia-logo.png">
</a></p>

## :link: Contents
- [Tools and Istruments](#wrench-tools-and-instruments)
- [How to run the automated tests](#bookmark_tabs-test-cases)
- - [Local Emulator](#computer-local-emulator)
- - [Remote](#satellite-remote)
- [Allure TestOps](#img-width3-titleallure-testops-srcmediaimagesallure-testops-logosvg-allure-testops-integration)
- [Allure Reports](#img-width3-titleallure-reports-srcmediaimagesallure-report-logosvg-allure-reports-integration)
- [Test Results](#ledger-test-results)
- - [Report](#example-of-a-test-run-report)
- - [Video](#img-width3-titleselenoid-srcmediaimagesselenoid-logosvg-video-of-the-test)
- - [Telegram](#img-width3-titletelegram-srcmediaimagestelegram-logosvg-telegram-test-result-notification)
- [Jira](#img-width4-titlejira-srcmediaimagesjira-logosvg-jira-integration)


## 	:wrench: Tools and Instruments

<p  align="center">
  <code><img width="5%" title="IntelliJ IDEA" src="media/images/IDEA-logo.svg"></code>
  <code><img width="5%" title="Java" src="media/images/java-logo.svg"></code>
  <code><img width="5%" title="Selenide" src="media/images/selenide-logo.svg"></code>
  <code><img width="5%" title="Selenoid" src="media/images/selenoid-logo.svg"></code>
  <code><img width="5%" title="Android Studio" src="media/images/androidStudio-logo.svg"></code>
  <code><img width="5%" title="Gradle" src="media/images/gradle-logo.svg "></code>
  <code><img width="5%" title="JUnit5" src="media/images/junit5-logo.svg"></code>
  <code><img width="5%" title="Jenkins" src="media/images/jenkins-logo.svg"></code>
  <code><img width="5%" title="Allure Report" src="media/images/allure-report-logo.svg"></code>
  <code><img width="5%" title="Allure TestOps" src="media/images/allure-testOps-logo.svg"></code>
  <code><img width="5%" title="Jira" src="media/images/jira-logo.svg"></code>
  <code><img width="5%" title="Telegram" src="media/images/telegram-logo.svg"></code>
</p>

- **Java** is the primary programming language for this project.
- **Selenide** and **Appium** frameworks are used for writing the automated tests.
- **JUnit 5** is used as a unit testing framework.
- **Gradle** is used to build the project.
- **Android Studio** is used to create a local emulator device.
- **Jenkins** is used for running the tests.
- **Browserstack** is used to launch tests on remote devices.
- **Allure Report** is used to visualize test results.
- **Telegram API** is used for receiving the final report via Telegram Bot.

# :bookmark_tabs: Test Cases

## :desktop_computer: Automated Tests

- Testing for successful Main search functionality operation.
- - Changing feed customization to hide all to display an empty feed.
- - Testing of save article functionality.
- Testing of Introduction screens of app use.
- - Testing screens for user base app launch.
- Testing of Search functionality.
- - Testing successful search functionality is working.
- - Testing for successful search for an article.

## :hand: Manual Test

- Article edit testing.
- - Searching for an existing article and editing it.
- Tests for Places .
- - Testing functionality of 'Places'

# :gear: How to run the automated tests

## :computer: Local Emulator

### :iphone: Local Emulator Test Run

To run the automated tests on local emulator:

```bash
gradle clean test -DdeviceHost=local
```

***Note: Preconditions required!!!***\
To run the automated tests locally on emulator some preconditions for this method are required:
- Appium GUI is installed
- Android Studio is installed (with Virtual Device Manager available)
- The following device is added:
- _Device name: **Pixel 3 API 34**_
- _Platform version: **14.0**_
- Appium server is running: <code>appium server</code>
- The AVD is running in the emulator

### Local BrowserStack Test Run

To run the automated tests on BrowserStack:

```bash
gradle clean test -DdeviceHost=local 
```

## :satellite: Remote

### <img width="3%" title="Jenkins" src="media/images/jenkins-logo.svg"> Using [Jenkins](https://jenkins.autotests.cloud/job/C23-mikenvico-wikipediaAppTestOnAndroid/)

To run this test through Jenkins, press button :arrow_forward:<code>Build with Parameters</code>.\
You can see the results via Allure Reports, or use the link to Allure TestOps on the same page.
<p align="center">
<img src="media/images/jenkins_autotests_cloud-howto.png" alt="How To Run Test" width="60%">
</p>

### <img width="3%" title="Jenkins" src="media/images/jenkins-logo.svg"> Test Parameters
You can change the following parameters in the test:
- <code>TASK</code> - Test to be executed. Default:<code>mobile_test</code>
- <code>DEVICE_HOST</code> - Set device platform to execute tests on. Default:<code>browserstack</code>
- <code>DEVICE</code> - Set default device to run tests on.
- <code>OS</code> - Set defaults device OS version.
- <code>SEARCH_REQUEST</code> - Set default search value for **Search** tests.
- <code>MAINSEARCH_REQUEST</code> - Set default search value for **Main** tests.

<p align="center">
<img src="media/images/jenkins_autotests_cloud-properties.png" alt="Test Parameters" width="60%">
</p>

## [<img width="3%" title="Allure TestOps" src="media/images/allure-testOps-logo.svg"> Allure TestOps](https://allure.autotests.cloud/project/4046/dashboards) Integration

### Dashboard

<p align="center">
<img src="media/images/allure_autotests_cloud-dashboard.png" alt="Allure TestOps Dashboard" width="80%">
</p>

---

### Launches

 <p align="center">
 <img src="media/images/allure_autotests_cloud-launches.png" alt="Allure TestOps Launches" width="80%">
 </p>

---


## :bookmark_tabs: Test Cases in TestOps

### Automated

> Example of Automated Test Cases

<p align="center">
<img src="media/images/allure_autotests_cloud-automated.png" alt="Automation Test Cases" width="80%">
</p>

---

### Manual

> Example of Manual Test Cases

<p align="center">
<img src="media/images/allure_autotests_cloud-manual.png" alt="Manual Test Cases" width="80%">
</p>




## [<img width="3%" title="Allure Reports" src="media/images/allure-report-logo.svg"> Allure Reports](https://jenkins.autotests.cloud/job/C23-mikenvico-wikipediaAppTestOnAndroid/allure/) Integration



### Jenkins Allure Overview

<p align="center">
<img src="media/images/allure_reports_cloud-overview.png" alt="Allure Reports Overview" width="80%">
</p>



## :ledger: Test Results

---

### Example of a Test Run report

> Allure Reports Provides a detailed step by step report of each test, test tag and other data like test severity level.\
> With each test result there is attached material such as test executed steps, page source as well as a video.

<p align="center">
<img src="media/images/allure_reports_cloud-result.png" alt="Allure Test Result" width="80%">
</p>

---

### <img width="3%" title="Selenoid" src="media/images/selenoid-logo.svg"> Video of the Test

> Example of a Test and how BrowserStack provides a video after each test.\
> Video of: Testing of save article functionality

<p align="center">
<img width="60%" title="Example Test Video" src="media/video-gif/test_video.gif">
</p>

---

### <img width="3%" title="Telegram" src="media/images/telegram-logo.svg"> Telegram test result notification

> After tests are finished created Telegram Bot sends generated test result notification.

<p align="center">
<img src="media/images/telegram-report.png" alt="Telegram Notification" width="60%">
</p>

---

## <img width="3%" title="Jira" src="media/images/jira-logo.svg"> Jira Integration

<p align="center">
<img src="media/images/jira_autotests_cloud.png" alt="Telegram Notification" width="80%">
</p>
