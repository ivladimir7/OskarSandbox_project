# Automated Gradle Java Project for an online bookstore [Oscar Sandbox](https://latest.oscarcommerce.com/en-gb/catalogue/)
## Project created at school Students Telran

## Purpose of the project
To automate testing of an online bookstore.
Compilation of a set of autotests for smoke testing of the first version of the site. Identification of bugs and compilation of a set of autotests, checking the later version for elimination of bugs, compilation of regression tests

## The Four Body of Project
- [x] Home Page
- [x] User
- [x] Product
- [x] Basket

## [Test Plan](https://docs.google.com/spreadsheets/d/1E53fUlBurmhZyhmSGJSuPg5L7KQCmIgu/edit#gid=543030468)
Also within the framework of the project were used:
+ ## Minimap
+ ## Test-suites and Test-case in the TestLink
+ ## Bugs in detail in the Jira software.

## Instalation
+ To run the project, do the following:
  + clone from the repository with Git: + git clone  [GIT](https://github.com/ivladimir7/Oskar.git)
  + Open IntelliJ IDEA → Get from version → Clone
 + Next, we use the project startup script
   + :arrow_right: for Windows  :left_right_arrow: gradlew.bat
   + :arrow_right: for MacOS/Linux  :left_right_arrow: gradlew
+ Press :heavy_plus_sign: : 
  +  select Gradle,specify 
  +  build configuration,
  +  accept and run the project
+ Going ahead, install Gradle


Automated Testing is implemented by:
| Functional testing   | implemented using| 
| -------------        |:-------------:| 
|  POM                 | Selenium, Gradle | 
| Pattern               | Regex,Parameterized assembly|
| Loading lots of data from files            | Data Provider     |  
| Generating reports       | MyListner  |  
| Report a failed test     |  Screenshot with scroll down  | 
|Autotests are run on the server | Jenkins |




