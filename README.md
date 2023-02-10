# Automated Gradle Java project for an online bookstore [Oscar Sandbox](https://latest.oscarcommerce.com/en-gb/catalogue/)
## The automated test was created as part of a school project Telran

## Purpose of the project
To automate testing of an online bookstore.
Compilation of a set of autotests for smoke testing of the first version of the site. Identification of bugs and compilation of a set of autotests, checking the later version for elimination of bugs, compilation of regression tests

## The four body of project
- [x] Home Page
- [x] User
- [x] Product
- [x] Basket

## [Test Plan](https://docs.google.com/spreadsheets/d/1E53fUlBurmhZyhmSGJSuPg5L7KQCmIgu/edit#gid=543030468)
Also within the framework of the project were used:
+ ## [MIND MAP](https://github.com/ivladimir7/Oskar/blob/main/Images/mindMap.jpeg)
+ ## [Test-suites and Test-case in the TestLink](https://github.com/ivladimir7/Oskar/blob/main/Images/TestLink.png)
+ ## [Bugs in detail in the Jira software](https://github.com/ivladimir7/Oskar/blob/main/Images/BUG%20Voucher.png)

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


## Automated testing is implemented by:
| Functional testing   | implemented using| 
| -------------        |:-------------:| 
|  POM                 | Java 11, Selenium 3.141, Gradle | 
| Pattern               | Regex,Parameterized assembly|
| Loading lots of data from files            | Data Provider     |  
| Generating reports       | MyListner  |  
| Report a failed test     |  Screenshot with scroll down  | 
|Autotests, run on the server | Jenkins |




