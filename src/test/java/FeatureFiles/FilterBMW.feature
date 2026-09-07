Feature: Filter Functionality

Scenario: Validate car brand filter functionality

Given the user is on the homepage

And user can view the entire list of vehicles

When the user applies the "BMW" filter under the brand category

Then BMW car results should be displayed



Then user again selecting "Toyota" filter

And Toyota car results should be displayed



When user  selecting "Mercedes" filter

And Mercedes car results should be displayed