Feature: JustDial

Scenario: Booking Flight ticket in JustDial website

Given https://www.justdial.com
And Cick on Air Tickets
And Type Chennai and choose Chennai, IN - Chennai Airport (MAA) as Leaving From 
And Type Toronto and select Toronto, CA - Toronto City Centre Airport (YTZ) as Going To
And Set Departure as 2020, July 22
And Add Adult 2, Children 1 click and Search
And Select Air Canada from multi-airline itineraries
And Click on Price to sort the result
And Click on +Details of first result under Price 
And Capture the Flight Arrival times.
And Capture the total price and Click on Book
When Capture the Airport name base on the list of time
Then Capture the total fare and print the difference amount from previous total price