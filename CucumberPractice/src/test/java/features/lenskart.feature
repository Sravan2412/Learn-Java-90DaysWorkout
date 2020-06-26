Feature: lenskart

Scenario: Ordering lens from lenskart

Given Go to https://www.lenskart.com
And Mouseover on Contact Lenses 
And Click on Monthly under Explore By Disposability
And Select brand as Aqualens
And Click on the first product
And Click Buy Now
And Select No of boxes as 2 and Power as -1 for both eyes.
And Type your name in User's name 
When And click Save and continue
Then Print total amount and click Proceed to Checkout