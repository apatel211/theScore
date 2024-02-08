❏ Automated test coverage 

These test case have integration , functional , end to end happy path coverage . Added 2 test cases to show case the usage of POM .

Happy test case for player Name search - Make sure search name is coming and verifing page data ( We can cover more in terms of each tab data and all data is coming correctly in term of full coverage )

Happy test case for team search -  Make sure search name is coming and verifing page data ( We can cover more in terms of each tab data and all data is coming correctly in term of full coverage )

❏ How to run

Open Cmd , run appium 

And

Open Cmd, Navigate to your path 

mvn clean / build 

mvn test -Dsurefire.suiteXmlFiles=testng.xml
OR
mvn test -DsuiteXmlFile=testng.xml

To execute single Test case 
 mvn test -Dtest=testCases.testRunner#verifyPlayerProfileSuccessfully
OR
mvn test -Dtest=testCases.testRunner#verifyTeamSuccessfully

❏ Prerequisites

appium 2.4.1

Maven 3.9.5

Java 17

testNG

Android studio Should be installed to set virtual device

Step 1 Open Android studio 

Step 2 Click on top right three dot 

Step 3 Click on virtual device manager

Step 4 Click on "+" sign to add device 

Step 5 Click on device size and APi level based on your system requirement

Set device : DeviceName "Pixel 7" and setAvdName "Pixel_7_API_31"

OR

Change device information based on what you have added : test/java/test/init

Step 6 Open cmd 

Step 7 adb devices 
See list of device which is created by you

❏ Test Framework Approach

The test strategy for the Appium Page Object framework in Java, coupled with TestNG, is meticulously crafted to ensure thorough coverage and efficient testing of the designated feature. This methodology involves a methodical understanding of the feature, identifying pertinent test scenarios, prioritizing test cases, and implementing page objects using the Page Object Model (POM). Integration with TestNG facilitates organized test execution and reporting, while continuous coverage assessment ensures robust validation across diverse scenarios and user interactions. This structured approach guarantees modular and maintainable test automation, enhancing the overall quality assurance process.
