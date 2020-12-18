# Carpet Cost Calculator

A basic Spring-Boot MVC application, using Bootstrap and Thymeleaf, JPA and an H2 DB.
I created this application based on the requirements below 
and I improve it over time.   

# Problem Definition
* A Carpet Company wants to make a calculator that calculates the price of the carpet with the following values:
State (Implement only two states : VA and TX)
* City (TX: Dallas, Austin, San Antonio ; VA: Arlington, Fairfax, McLean)
* Area (Kitchen will be circle, Bedroom will be square, Living room will be a rectangle)
* Floor area will be calculated based on the values provided in application.properties.
* City can be implemented as a enum or you can go for your own solution.
* Unit price will be different for each city in the state. 
* You can use a Map for unit price with the city as a key. Or you can prefer your own solution.

# Prerequisites
You will need to following tools in order to work with this project and code

* git (http://git-scm.com/)
* JDK 1.8+ (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* Maven 3.x+ (http://maven.apache.org/)
* An IDE of your choice. (Eclipse, IntelliJ, Spring STS)

# Getting Started
To run this project locally, perform the following steps.
1. Clone project to your machine using git - "git clone https://github.com/GabrielLazar/carpetCalculator.git" 
2. Import the project to IDE
3. Run Spring-boot project
4. Access http://localhost:8084/CarpetCostCalculator/

Created by @Gabriel Lazar 
