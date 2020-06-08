Feature: Nykaa website

Scenario: Ordering Loreal Paris shampoo from Nykaa


Given Go to https://www.nykaa.com
And Mouseover on Brands and Mouseover on Popular
And Click L'Oreal Paris
And Go to the newly opened window and check the title contains L'Oreal Paris
And Click sort By and select customer top rated
And Click Category and click Shampoo
And check whether the Filter is applied with Shampoo
And Click on L'Oreal Paris Colour Protect Shampoo
And GO to the new window and select size as 360ml and Print the MRP of the product and Click on ADD to BAG 
And Go to Shopping Bag and Make quantity as 2
And Print the Grand Total amount
And Click Proceed
And Click on Continue as Guest 
Then Print the warning message --> delay in shipment