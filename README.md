❏ Automated test



❏ How to run

Open Cmd, Navigate to your path 

mvn clean / build 

mvn test -Dsurefire.suiteXmlFiles=testng.xml
OR
mvn test -DsuiteXmlFile=testng.xml


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