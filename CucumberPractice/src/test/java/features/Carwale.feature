Feature: CarWale

Scenario: Lowest KM Car

Given Go to https://www.carwale.com/
And Click on Used
And Select the City as Chennai
And Select budget min 9L and max 12L and Click Search
And Select Cars with Photos under Only Show Cars With 
And Select Manufacturer as BMW --> 3-Series
And Select Fuel Type as Diesel
And Select Best Match as KM: Low to High
And Validate the Cars are listed with KMs Low to High
And Add the least KM ran car to Wishlist
And Go to Wishlist and Click on More Details
When Print all the details under Overview in the Same way as displayed in application 
Then Close the browser